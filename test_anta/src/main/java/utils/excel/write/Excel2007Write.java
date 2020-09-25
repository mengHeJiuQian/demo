package utils.excel.write;

import utils.excel.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel2007Write implements IExcelWrite<List<String>>{

    private Workbook workbook;

    private Sheet sheet;

    private static final int MAX_ROW = 1_000_000;

    public Excel2007Write() throws IOException {
        workbook =  ExcelUtil.getWorkbook();
        sheet = ExcelUtil.createSheet(workbook);
    }

    @Override
    public void addHead(List<String> heads) {
        addLastRow(heads);
    }

    @Override
    public void addLastRow(List<String> data){
        int rowNumber =  ExcelUtil.addLastRow(sheet,data);
        if (rowNumber == MAX_ROW) {
            sheet = ExcelUtil.createSheet(workbook);
        }
    }

    @Override
    public void addAllLastRow(List<List<String>> data){
        for (List<String> l:data) {
            addLastRow(l);
        }
    }

    @Override
    public String write() throws IOException {
        return ExcelUtil.writeExcel(workbook);
    }

    @Override
    public void write(OutputStream out) throws Exception {
        ExcelUtil.writeExcel(workbook,out);
    }

    @Override
    public void write(String fileName) throws Exception {
        ExcelUtil.writeExcel(workbook,fileName);
    }


    @Override
    public void close(){
        try{
            if (workbook != null) {
                workbook.close();
                if (workbook instanceof SXSSFWorkbook) {
                    ((SXSSFWorkbook) workbook).dispose();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("111111");
        objects.add("222222");
        objects.add("333333");
        objects.add("444444");


        Excel2007Write excel2007Write = new Excel2007Write();
        excel2007Write.addLastRow(objects);
        excel2007Write.addLastRow(objects);
        excel2007Write.addLastRow(objects);
        excel2007Write.addLastRow(objects);
        excel2007Write.addLastRow(objects);
        excel2007Write.addLastRow(objects);
        excel2007Write.write();
    }


}
