package util.excel.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class ExcelDataUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelDataUtil.class);




    /**
     * 获取单列数据
     * @param sheet    工作簿对象
     * @param column   读取第几列
     * @param skip     跳过的行数
     * @return
     */
    public static List<String> analyzeOnly(Sheet sheet, int column,int skip){
        List<String> list = new LinkedList<>();
        //总行数
        int lastRowNum = sheet.getLastRowNum()+1;
        for (int i=skip;i<lastRowNum;i++) {
            Row row = sheet.getRow(i);
            if (null != row) {
                String value = ExcelUtil.getCellValue(row.getCell(column-1));
                if (StringUtils.isNotBlank(value)) {
                    list.add(value);
                }
            }

        }
        logger.info(
                MessageFormat.format("sheet行数={0,number,#} 读取列数={1,number,#} 跳过行数={2,number,#} 读取到的列数={3,number,#}"
                ,lastRowNum,column,skip,list.size()));
        return list;
    }



    public static void main(String[] args) throws IOException {

        List<String> strings = ExcelDataUtil.analyzeOnly(        ExcelUtil.getWorkbook("E:\\ww.xlsx").getSheetAt(0), 1,0);
        for (String s : strings) {
            System.out.println(s);
        }


    }
}
