package util.excel.read;

import java.util.List;
import java.util.Map;

public interface Excel2007HeadReadCall {

    void execute(String filePath, String sheetName, int sheetIndex, List<Map<String, String>> list);
}
