package tools.excel;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;
import utils.datetime.DateUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 导出Excel工具类
 * @author FangSo
 */
@Slf4j
public class ExportExcelTool {

    /**
     * 导出Excel【流】
     * @param list  需要导出的数据集合
     * @param sheetName 工作表名称
     * @param title 每一项表头的中文标题
     * @param <T>
     * @return
     */
    public static <T> ByteArrayInputStream list2EcelStream(List<T> list, String sheetName, LinkedHashMap<String, String> title) {
        byte[] data;
        ByteArrayInputStream in = null;
        if(CollectionUtils.isEmpty(list)){
            throw new RuntimeException("导出的数据为空");
        }
        try {
            @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet(sheetName);
            fillVeticalSheet(sheet, list, title);
            wb.write(out);
            data = out.toByteArray();
            in = new ByteArrayInputStream(data);
        } catch (Exception e) {
            log.error("【导出Excel(流)异常】：{}", e);
        }
        return in;
    }

    private static <T> void fillVeticalSheet(Sheet sheet, List<T> list, LinkedHashMap<String, String> title) {
        if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(title)) {
            return;
        }
        // 定义存放英文字段名和中文字段名称的数组
        String[] enFields = new String[title.size()];
        String[] cnFields = new String[title.size()];
        // 填充数组
        int count = 0;
        for (Map.Entry<String, String> entry : title.entrySet()) {
            enFields[count] = entry.getKey();
            cnFields[count] = entry.getValue();
            count++;
        }
        // 填充表头
        Row row = sheet.createRow(0);
        for (int j = 0; j < cnFields.length; j++) {
            Cell cell = row.createCell(j);
            cell.setCellValue(cnFields[j]);
        }
        // 填充数据
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            row = sheet.createRow(i + 1);
            for (int j = 0; j < enFields.length; j++) {
                Object objValue = getFieldValueByNameSequence(enFields[j], item);
                if (objValue instanceof String) {
                    row.createCell(j).setCellValue((String) objValue);
                } else if (objValue instanceof Double) {
                    row.createCell(j).setCellValue((Double) objValue);
                } else if (objValue instanceof RichTextString) {
                    row.createCell(j).setCellValue((RichTextString) objValue);
                } else if (objValue instanceof Date) {
                    row.createCell(j).setCellValue((Date) objValue);
                } else if (objValue instanceof Boolean) {
                    row.createCell(j).setCellValue((Boolean) objValue);
                }else if (objValue instanceof Integer){
                    row.createCell(j).setCellValue((Integer)objValue);
                }
            }
        }
    }

    private static Object getFieldValueByNameSequence(String fieldNameSequence, Object o) {
        Object value = null;
        try {
            // 将fieldNameSequence进行拆分
            String[] attributes = fieldNameSequence.split("\\.");
            if (attributes.length == 1) {
                value = PropertyUtils.getProperty(o, fieldNameSequence);
            } else {
                // 根据属性名获取属性对象
                Object fieldObj = PropertyUtils.getProperty(o, attributes[0]);
                String subFieldNameSequence = fieldNameSequence.substring(fieldNameSequence.indexOf(".") + 1);
                value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
            }
            if (value instanceof Date) {
                value = new SimpleDateFormat(DateUtil.DATE_YYYY_MM_DD_HH_MM_SS).format(value);
            }
        } catch (Exception e) {
            log.error("【getFieldValueByNameSequence异常】：{}", e);
        }
        return value;
    }
}
