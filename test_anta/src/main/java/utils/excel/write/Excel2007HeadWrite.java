package utils.excel.write;

import utils.excel.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Excel2007HeadWrite implements IExcelWrite<Map<String, String>> {

    private Workbook workbook;

    private Sheet sheet;

    private boolean haveHead;

    //记录头信息对应的列索引
    private Map<String, Integer> headMap = new HashMap<>();

    public Excel2007HeadWrite() throws IOException {
        workbook = ExcelUtil.getWorkbook();
        sheet = ExcelUtil.createSheet(workbook);
    }

    @Override
    public void addHead(List<String> heads) {
        if (haveHead) {
            throw new RuntimeException("已经添加过头信息,不能再次添加");
        }
        for (int i = 0; i < heads.size(); i++) {
            String head = heads.get(i);
            headMap.put(head, i);
        }
        ExcelUtil.addLastRow(sheet,heads);
        haveHead = true;
    }

    @Override
    public void addLastRow(Map<String, String> data) {
        if (!haveHead) {
            throw new RuntimeException("请先添加头信息在添加数据");
        }
        HashMap<Integer, String> map = new HashMap<>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            Integer number = headMap.get(key);
            if (number != null) {
                map.put(number, entry.getValue());
            }
        }
        ExcelUtil.addLastRow(sheet,map);
    }

    @Override
    public void addAllLastRow(List<Map<String, String>> data) {
        for (Map<String, String> m : data) {
            addLastRow(m);
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
    public void close() throws Exception {
        workbook.close();
    }


    public boolean isHaveHead() {
        return haveHead;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("第一列");
        objects.add("第二列");
        Excel2007HeadWrite excel2007Write = new Excel2007HeadWrite();
        excel2007Write.addHead(objects);

        HashMap<String, String> map = new HashMap<>();
        map.put("第一列","张三");
        map.put("第二列","李四");
        excel2007Write.addLastRow(map);
        map.put("第二列","李四");
        map.put("第一列","张三");
        excel2007Write.addLastRow(map);
        excel2007Write.addLastRow(map);
        map.put("第一列","王五");
        map.put("第二列","麻溜");
        excel2007Write.addLastRow(map);
        map.put("第二列","鬼知道");
        map.put("第一列","不认识");
        excel2007Write.addLastRow(map);
        map.put("第一列","张三");
        map.put("第二列","李四");
        excel2007Write.addLastRow(map);
        excel2007Write.write();


    }
}
