package util.excel.read;

import com.google.gson.Gson;
import lombok.Setter;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大批量读取excel
 *
 * @author zhenhua.ma   source:network
 */
@Setter
public class Excel2007HeadRead {

    private Gson JSON = new Gson();

    private static Logger logger = LoggerFactory.getLogger(Excel2007HeadRead.class);

    private List<Map<String, String>> cache = new ArrayList<>();

    private int cacheRowNumber = 1;

    private String filename;

    private Excel2007HeadReadCall call;


    public static Excel2007HeadReadBuilder newExcel2007HeadReadBuild() {
        return new Excel2007HeadReadBuilder();
    }

    public void processOneSheet(Excel2007HeadReadCall call, int sheetId) throws Exception {
        this.call = call;
        new SheetHandler().process(filename, sheetId);
    }

    private void rowHandle(String filePath, String sheetName, int sheetIndex, int curRow, Map<String, String> cellMap) {
        logger.debug("filePath=" + filePath + "  sheetName=" + sheetName + " sheetIndex=" + sheetIndex + "  curRow=" + curRow + " " + " cellList=" + JSON.toJson(cellMap));
        cache.add(cellMap);
        if (cellMap.size() >= cacheRowNumber) {
            call.execute(filePath, sheetName, sheetIndex, cache);
            cache.clear();
        }
    };

    private void rowEnd(String filePath, String sheetName, int sheetIndex) {
        call.execute(filePath, sheetName, sheetIndex, cache);
        cache.clear();
    };

    public static final class Excel2007HeadReadBuilder {
        private int cacheRowNumber = 1;

        private Excel2007HeadReadBuilder() {
        }

        public Excel2007HeadReadBuilder cacheRowNumber(int cacheRowNumber) {
            this.cacheRowNumber = cacheRowNumber;
            return this;
        }


        public Excel2007HeadRead build(String filename) {
            Excel2007HeadRead excel2007HeadRead = new Excel2007HeadRead();
            excel2007HeadRead.setCacheRowNumber(cacheRowNumber);
            excel2007HeadRead.setFilename(filename);
            return excel2007HeadRead;
        }
    }


    /**
     * excel 数据事件处理类
     */
    class SheetHandler extends DefaultHandler {

        /**
         * 单元格中的数据可能的数据类型
         */
        /**
         * 共享字符串表
         */
        private SharedStringsTable sst;

        /**
         * 上一次的索引值
         */
        private String lastIndex;

        /**
         * 文件的绝对路径
         */
        private String filePath = "";

        /**
         * 工作表索引
         */
        private int sheetIndex = 0;

        /**
         * sheet名
         */
        private String sheetName = "";

        /**
         * 总行数
         */
        private int totalRows = 0;


        private Map<String, String> head = new HashMap<>();

        /**
         * 一行内cell集合
         */
        private Map<String, String> cellMap = new HashMap<>();

        /**
         * 判断整行是否为空行的标记
         */
        private boolean flag = false;

        /**
         * 当前行
         */
        private int curRow = 1;

        /**
         * 单元格数据类型，默认为字符串类型
         */
        private CellDataTypeEnum nextDataType = CellDataTypeEnum.SSTINDEX;

        private final DataFormatter formatter = new DataFormatter();

        /**
         * 单元格日期格式的索引
         */
        private short formatIndex;

        /**
         * 日期格式字符串
         */
        private String formatString;

        //当前单元格的位置
        private String ref = null;
        /**
         * 单元格
         */
        private StylesTable stylesTable;

        /**
         * 遍历工作簿中所有的电子表格
         * 并缓存在mySheetList中
         *
         * @param filename
         * @throws Exception
         */
        public int process(String filename, int sheetId) throws Exception {
            filePath = filename;
            OPCPackage pkg = OPCPackage.open(filename);
            XSSFReader r = new XSSFReader(pkg);
            stylesTable = r.getStylesTable();
            this.sst = r.getSharedStringsTable();
            XMLReader parser = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser");
            parser.setContentHandler(this);
            InputStream sheet2 = r.getSheet("rId" + sheetId);
            sheetIndex++;
            InputSource sheetSource = new InputSource(sheet2);
            parser.parse(sheetSource);
            sheet2.close();
            return totalRows; //返回该excel文件的总行数，不包括首列和空行
        }

        /**
         * 第一个执行
         *
         * @param uri
         * @param localName
         * @param name
         * @param attributes
         * @throws SAXException
         */
        @Override
        public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
            //c => 单元格
            if ("c".equals(name)) {
                //当前单元格的位置
                ref = attributes.getValue("r").replaceAll("\\d+", "");
                //设定单元格类型
                this.setNextDataType(attributes);
            }

            //置空
            lastIndex = "";
        }

        /**
         * 第二个执行
         * 得到单元格对应的索引值或是内容值
         * 如果单元格类型是字符串、INLINESTR、数字、日期，lastIndex则是索引值
         * 如果单元格类型是布尔值、错误、公式，lastIndex则是内容值
         *
         * @param ch
         * @param start
         * @param length
         * @throws SAXException
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastIndex += new String(ch, start, length);
        }

        /**
         * 第三个执行
         *
         * @param uri
         * @param localName
         * @param name
         * @throws SAXException
         */
        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {
            //t元素也包含字符串
            if ("v".equals(name)) {
                //v => 单元格的值，如果单元格是字符串，则v标签的值为该字符串在SST中的索引
                String value = this.getDataValue(lastIndex.trim(), "");//根据索引值获取对应的单元格值
                //补全单元格之间的空单元格
                if (curRow == 1) {
                    head.put(ref, value);
                } else {
                    cellMap.put(head.get(ref), value);
                }
                //如果里面某个单元格含有值，则标识该行不为空行
                if (value != null && !"".equals(value)) {
                    flag = true;
                }
            } else {
                //如果标签名称为row，这说明已到行尾，调用optRows()方法
                if ("row".equalsIgnoreCase(name)) {
                    if (flag && curRow != 1) { //该行不为空行且该行不是第一行，则发送（第一行为列名，不需要）
                        rowHandle(filePath, sheetName, sheetIndex, curRow, new HashMap<>(cellMap));
                        totalRows++;
                    }
                    cellMap.clear();
                    curRow++;
                    ref = null;
                    flag = false;
                } else if ("Worksheet".equalsIgnoreCase(name)) {
                    rowEnd(filePath, sheetName, sheetIndex);
                }
            }
        }

        /**
         * 处理数据类型
         *
         * @param attributes
         */
        public void setNextDataType(Attributes attributes) {
            nextDataType = CellDataTypeEnum.NUMBER; //cellType为空，则表示该单元格类型为数字
            formatIndex = -1;
            formatString = null;
            String cellType = attributes.getValue("t"); //单元格类型
            String cellStyleStr = attributes.getValue("s"); //
            String columnData = attributes.getValue("r"); //获取单元格的位置，如A1,B1

            if ("b".equals(cellType)) { //处理布尔值
                nextDataType = CellDataTypeEnum.BOOL;
            } else if ("e".equals(cellType)) {  //处理错误
                nextDataType = CellDataTypeEnum.ERROR;
            } else if ("inlineStr".equals(cellType)) {
                nextDataType = CellDataTypeEnum.INLINESTR;
            } else if ("s".equals(cellType)) { //处理字符串
                nextDataType = CellDataTypeEnum.SSTINDEX;
            } else if ("str".equals(cellType)) {
                nextDataType = CellDataTypeEnum.FORMULA;
            }

            if (cellStyleStr != null) { //处理日期
                int styleIndex = Integer.parseInt(cellStyleStr);
                XSSFCellStyle style = stylesTable.getStyleAt(styleIndex);
                formatIndex = style.getDataFormat();
                formatString = style.getDataFormatString();

                if (formatString.contains("m/d/yy")) {
                    nextDataType = CellDataTypeEnum.DATE;
                    formatString = "yyyy-MM-dd hh:mm:ss";
                }

                if (formatString == null) {
                    nextDataType = CellDataTypeEnum.NULL;
                    formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
                }
            }
        }

        /**
         * 对解析出来的数据进行类型处理
         *
         * @param value   单元格的值，
         *                value代表解析：BOOL的为0或1， ERROR的为内容值，FORMULA的为内容值，INLINESTR的为索引值需转换为内容值，
         *                SSTINDEX的为索引值需转换为内容值， NUMBER为内容值，DATE为内容值
         * @param thisStr 一个空字符串
         * @return
         */
        @SuppressWarnings("deprecation")
        public String getDataValue(String value, String thisStr) {
            switch (nextDataType) {
                // 这几个的顺序不能随便交换，交换了很可能会导致数据错误
                case BOOL: //布尔值
                    char first = value.charAt(0);
                    thisStr = first == '0' ? "FALSE" : "TRUE";
                    break;
                case ERROR: //错误
                    thisStr = "\"ERROR:" + value.toString() + '"';
                    break;
                case FORMULA: //公式
                    thisStr = '"' + value.toString() + '"';
                    break;
                case INLINESTR:
                    XSSFRichTextString rtsi = new XSSFRichTextString(value.toString());
                    thisStr = rtsi.toString();
                    rtsi = null;
                    break;
                case SSTINDEX: //字符串
                    String sstIndex = value.toString();
                    try {
                        int idx = Integer.parseInt(sstIndex);
                        XSSFRichTextString rtss = new XSSFRichTextString(sst.getEntryAt(idx));//根据idx索引值获取内容值
                        thisStr = rtss.toString();
                        rtss = null;
                    } catch (NumberFormatException ex) {
                        thisStr = value.toString();
                    }
                    break;
                case NUMBER: //数字
                    if (formatString != null) {
                        thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString).trim();
                    } else {
                        thisStr = value;
                    }
                    thisStr = thisStr.replace("_", "").trim();
                    break;
                case DATE: //日期
                    thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString);
                    // 对日期字符串作特殊处理，去掉T
                    thisStr = thisStr.replace("T", " ");
                    break;
                default:
                    thisStr = " ";
                    break;
            }
            return thisStr;
        }
    }

    public static void main(String[] args) throws Exception {


    }
}
