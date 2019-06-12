package util.excel.utils;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 在当前工作簿创建指定做引创建行 如果此行已经存在 会被覆盖
     *
     * @param sheet
     * @param rowNumber 第几行
     * @return
     */
    public static Row createRow(Sheet sheet, int rowNumber) {
        return sheet.createRow(rowNumber);
    }


    /**
     * 在当前行创建新的单元格,如果单元格已经存在 会被覆盖
     *
     * @param row
     * @param cellNumber 第几列
     * @return
     */
    public static Cell createCell(Row row, int cellNumber) {
        return row.createCell(cellNumber);
    }

    /**
     * 在单元格的第几列中写入数据
     * @param row   行对象
     * @param cellNumber
     * @param data
     */
    public static void addData(Row row,int cellNumber,String data) {
        addData(createCell(row,cellNumber),data);
    }

    /**
     * 在单元格中写数据
     * @param cell  单元格对象
     * @param data   数据
     */
    public static void addData(Cell cell, String data) {
        cell.setCellValue(data);
    }


    /**
     * 在最后一行添加数据
     * @param sheet
     * @param data
     */
    public static int addLastRow(Sheet sheet,List<String> data){
        int rowNumber = sheet.getLastRowNum();
        if(rowNumber>0 || getRow(sheet, rowNumber)!=null){
            rowNumber +=1;
        }
        Row row = createRow(sheet, rowNumber);
        for (int i=0;i<data.size();i++){
            addData(createCell(row,i),data.get(i));
        }
        return rowNumber;
    }

    public static int addLastRow(Sheet sheet, Map<Integer,String> map){
        int rowNumber = sheet.getLastRowNum();
        if(rowNumber>0 || getRow(sheet, rowNumber)!=null){
            rowNumber +=1;
        }
        Row row = createRow(sheet, rowNumber);
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            addData(createCell(row,entry.getKey()),entry.getValue());
        }
        return rowNumber;
    }

    public static Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    /**
     * 创建工作簿
     *
     * @param workbook
     * @return
     */
    public static Sheet createSheet(Workbook workbook) {
        return createSheet(workbook,null);
    }

    /**
     * 创建工作簿
     *
     * @param workbook
     * @param name     工作簿名称
     * @return
     */
    public static Sheet createSheet(Workbook workbook, String name) {
        return StringUtils.isNotBlank(name) ? workbook.createSheet(name) : workbook.createSheet();
    }

    /**
     * 将文件写入本地磁盘
     *
     * @param workbook 文件对象
     * @throws IOException
     */
    public static String writeExcel(Workbook workbook) throws IOException {
            String path=new StringBuilder()
                    .append(File.separator)
                    .append("temp")
                    .append(File.separator)
                    .append("excel")
                    .append(File.separator)
                    .append(System.currentTimeMillis())
                    .append(UUID.randomUUID().toString().replaceAll("-",""))
                    .append(".xlsx").toString();
        writeExcel(workbook,path);
        return  path;
    }

    /**
     * 将文件写入本地磁盘
     *
     * @param workbook 文件对象
     * @param fileName 文件地址
     * @throws IOException
     */
    public static void writeExcel(Workbook workbook, String fileName) throws IOException {
        File file = new File(fileName);
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        try (FileOutputStream fileOut = new FileOutputStream(fileName); Workbook wk = workbook) {
            wk.write(fileOut);
        }
    }

    /**
     * 将文件写入本地磁盘
     *
     * @param workbook 文件对象
     * @throws IOException
     */
    public static void writeExcel(Workbook workbook, OutputStream out) throws IOException {
        try {
            workbook.write(out);
            workbook.close();
            if (workbook instanceof SXSSFWorkbook) {
                ((SXSSFWorkbook) workbook).dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建空的 excel 对象
     *
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook() throws IOException {
        //使用此对象是因为可以保证不会内存溢出
        return new SXSSFWorkbook(200);
    }

    /**
     * 获取本地文件 excel Workbook对象
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(String path) throws IOException {
        return getWorkbook(new File(path));
    }

    /**
     * 获取本地文件 excel Workbook对象
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(File file) throws IOException {
        return WorkbookFactory.create(file);
    }

    public static Workbook getStreamingWorkbook(InputStream in) throws IOException {
        return StreamingReader.builder()
                .rowCacheSize(100)  //缓存到内存中的行数，默认是10
                .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
    }

    public static Workbook getWorkbook(InputStream in) throws IOException {
        return WorkbookFactory.create(in);
    }

    /**
     * 获取一个工作簿的一个sheet文件的某一列信息
     * @param workbook
     * @param sheetIndex sheet数从1开始
     * @param column 列数从1开始
     * @return
     */
    public static List<String> getColumnList(Workbook workbook, int sheetIndex, int column) {
        Sheet sheet = workbook.getSheetAt(sheetIndex - 1);
        return ExcelDataUtil.analyzeOnly(sheet, column, 0);
    }


    public static String getCellValue(Cell cell) {
        return getCellValue(cell, false);
    }

    public static String getCellValue(Cell cell, boolean isPoint) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return isPoint ? String.valueOf(cell.getNumericCellValue()) : String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }


    public static void main(String[] args) throws IOException {
        Workbook workbook = ExcelUtil.getWorkbook();
        Sheet sheet = workbook.createSheet();
        System.out.println(sheet.getRow(0) == null);
        sheet.createRow(0).createCell(0).setCellValue("第一个格子测试1");
        System.out.println(sheet.getRow(0) == null);
        sheet.createRow(0).createCell(0).setCellValue("第一个格子测试2");
        sheet.createRow(0).createCell(0).setCellValue("第一个格子测试3");
        ExcelUtil.writeExcel(workbook, "E:\\123.xlsx");
        workbook.close();
        workbook.close();
    }


}
