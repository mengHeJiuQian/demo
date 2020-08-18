package util.excel.write;

import java.io.OutputStream;
import java.util.List;

public interface IExcelWrite<T>  extends   AutoCloseable{

    void addHead(List<String> heads);

    void addLastRow(T t);

    void addAllLastRow(List<T> list);

    String write() throws Exception;

    void write(OutputStream out) throws Exception;

    void write(String fileName) throws Exception;
}
