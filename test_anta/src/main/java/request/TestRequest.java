package request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/10/19 16:05
 */
public class TestRequest {
    public static void main(String[] args) {
        try {
            HttpURLConnection urlConn = (HttpURLConnection) new URL("www.baidu.com").openConnection();
            urlConn.setRequestMethod("POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
