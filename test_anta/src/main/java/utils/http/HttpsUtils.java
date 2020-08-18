package utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class HttpsUtils {

    private static Logger logger = Logger.getLogger(HttpsUtils.class);
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    static {

        try {
            builder = new SSLContextBuilder();
            TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] certificate, String authType) {
                    return true;
                }
            };
            builder.loadTrustMaterial(null, acceptingTrustStrategy);
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" },
                    null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);// max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * httpClient post
     *
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static HttpResponse postIgnoreCookie(String url, Map<String, String> header, Map<String, Object> param) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        try {
            httpClient = getHttpClientIgnoreCooke();
            httpPost = new HttpPost(url);
            httpPost.setConfig(getRqCookieIgnoreConfig());
            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (MapUtils.isNotEmpty(param)) {
                JSONObject jsonParam = new JSONObject();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    jsonParam.put(key, value);
                }
                HttpEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
            }
        } catch (Exception e) {
            logger.error("post error " + e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * httpClient post
     *
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static HttpResponse post(String url, Map<String, String> header, Map<String, Object> param) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        try {
            httpClient = getHttpClient();
            httpPost = new HttpPost(url);

            httpPost.setConfig(getRqConfig());

            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (MapUtils.isNotEmpty(param)) {
                JSONObject jsonParam = new JSONObject();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    jsonParam.put(key, value);
                }
                HttpEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
            }
        } catch (Exception e) {
            logger.error("post error " + e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * httpClient get
     *
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static HttpResponse get(String url, Map<String, String> header, Map<String, String> param) {
        HttpResponse httpResponse = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            if (MapUtils.isNotEmpty(param)) {
                url += "?";
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    url += entry.getKey() + "=" + entry.getValue() + "&";
                }
                url = url.substring(0, url.lastIndexOf("&"));
            }

            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(getRqConfig());
            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpGet.abort();
            }
        } catch (Exception e) {
            logger.error("get error" + e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("get close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * httpClient delete
     *
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static HttpResponse delete(String url, Map<String, String> header, Map<String, String> param) {
        HttpResponse httpResponse = null;
        CloseableHttpClient httpClient = null;
        try {
            if (MapUtils.isNotEmpty(param)) {
                url += "?";
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    url += entry.getKey() + "=" + entry.getValue() + "&";
                }
            }
            String urlWithParam = url;
            if (url.lastIndexOf("&") > 0) {
                urlWithParam = url.substring(0, url.lastIndexOf("&"));
            }
            httpClient = getHttpClient();
            HttpDelete httpDelete = new HttpDelete(urlWithParam);
            httpDelete.setConfig(getRqConfig());

            httpResponse = httpClient.execute(httpDelete);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpDelete.abort();
            }
        } catch (Exception e) {
            logger.error("get error" + e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("get close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * httpClient put
     *
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static HttpResponse put(String url, Map<String, String> header, Map<String, Object> param) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        try {
            httpClient = getHttpClient();
            HttpPut httpPut = new HttpPut(url);
            httpPut.setConfig(getRqConfig());

            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPut.addHeader(entry.getKey(), entry.getValue());
                }
            }
            //微店改造-查询统一客户中心
            if (MapUtils.isNotEmpty(param)) {
                JSONObject jsonParam = new JSONObject();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    jsonParam.put(key, value);
                }
                HttpEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
                httpPut.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPut);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPut.abort();
            }
        } catch (Exception e) {
            logger.error("post error" + e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
                .setConnectionManagerShared(true).build();
        return httpClient;
    }

    public static CloseableHttpClient getHttpClientIgnoreCooke() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
                .setConnectionManagerShared(true).build();
        return httpClient;
    }

    public static RequestConfig getRqCookieIgnoreConfig() {
        RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        return config;
    }

    public static RequestConfig getRqConfig() {
        RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).build();
        return config;
    }

    /**
     *
     * @param url
     * @param header
     * @param param
     * @return
     */
    public static HttpResponse postForMsgReply(String url, Map<String, String> header, Map<String, Object> param) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        try {
            httpClient = getHttpClient();
            httpPost = new HttpPost(url);

            httpPost.setConfig(getRqConfig());

            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (MapUtils.isNotEmpty(param)) {
                JSONObject jsonParam = new JSONObject();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    jsonParam.put(key, value);
                }
                HttpEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
            }
        } catch (Exception e) {
            logger.error("post error " + e);
        } finally {
            try {
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    public static HttpResponse postXml(String url, String xmlInfo) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        try {
            httpClient = getHttpClient();
            httpPost = new HttpPost(url);

            httpPost.setConfig(getRqConfig());

            httpPost.addHeader("Content-Type","text/xml");
            httpPost.addHeader("charset","utf-8");

            HttpEntity entity = new StringEntity(xmlInfo, "UTF-8");
            httpPost.setEntity(entity);

            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
            }
        } catch (Exception e) {
            logger.error("post error " + e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * httpClient post
     *
     * @param url
     * @param param
     * @return
     * @throws Exception
     *
     */
    public static String postSendDHTRed(String url, String param) {
        PostMethod postMethod = new PostMethod(url) ;
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
        NameValuePair[] data = {
                new NameValuePair("redpackReceiveDTO",param)
        };
        postMethod.setRequestBody(data);
        HttpClient httpClient = new HttpClient();
        String result = null;
        try {
            int response = httpClient.executeMethod(postMethod); // ִ��POST����
            result = postMethod.getResponseBodyAsString() ;
            System.out.println(response);
            System.out.println(result);

        } catch (Exception e) {
            logger.error("post error " + e);
        }
        return result;
    }

    public static HttpResponse post(String url, Map<String, String> header, String param) {
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        try {
            httpClient = getHttpClient();
            httpPost = new HttpPost(url);

            httpPost.setConfig(getRqConfig());

            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (null !=param && "".equals(param)) {
//				HttpEntity entity = new StringEntity(param, "UTF-8");
                HttpEntity entity = new StringEntity(param, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
            }
        } catch (Exception e) {
            logger.error("post error " + e);
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }

            } catch (IOException e) {
                logger.error("post close httpclient faild" + e);
            }
        }
        return httpResponse;
    }

    /**
     * CR1903087_微店改造	同一客户中心 post
     * @param url
     * @param param
     * @return
     *
     */
    public static String postForCusCenter(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("CUSTOMER_CENTER_SOURCE", "WD");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * CR1903087_微店改造	同一客户中心 post	代理人
     * @param url
     * @param param
     * @return
     *
     */
    public static String postForCusCenterAgent(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("CUSTOMER_CENTER_SOURCE", "WD_AGENT");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * CR1903087_微店改造	同一客户中心 get
     * @param url
     * @param param
     * @return
     *
     */
    public static String getForCusCenter(String url, Map<String, String> param) {
        String result = "";
        BufferedReader in = null;
        try {
            if (MapUtils.isNotEmpty(param)) {
                url += "?";
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    url += entry.getKey() + "=" + entry.getValue() + "&";
                }
                url = url.substring(0, url.lastIndexOf("&"));
            }
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("CUSTOMER_CENTER_SOURCE", "WD");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

        } catch (Exception e) {

            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();

        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * CR1903087_微店改造	同一客户中心 post
     * @param url
     * @param param
     * @return
     *
     */
    public static String putForCusCenter(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("PUT");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("CUSTOMER_CENTER_SOURCE", "WD");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * CR1903087_微店改造	同一客户中心 post
     * @param url
     * @param param
     * @return
     *
     */
    public static String postBlueDeer(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            //conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //conn.setRequestProperty("Accept-Encoding","gzip, deflate, br");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String url = "https://sit.tohours.com/metlifecs/activity/save-national-day-info";
//		String param = "zbE5CzqMn1ivA1Ip6yxdDpPI40leW5P6lea4rG1HAz7gHQLAtIj4DOq6ulTxDnOPNxxtWbkhEABLQfMPhqtaf4uzf1HlTyXfAGyDXsDhirGLTRLoU6UQQqJTnvFjHOvrtHz7vSSTUWoFRmcMT+RrSaeGGj9yPdqgZgGDXoSD0/EurBqOp9r5C3jokz0APSZtTBpF0/JOX5LeJt4t0CVVINi3ZauuiJKFxhz5xIZdsorEMaYiVWbkOQnXMVXXP3QKWxeqwu14CnUg2k2bC+BTyFAVseL7Mvq0egFANeBwgX1yhOkARaTz9rR+QeEo13o8hzPARn5bVm06Z/Zj8x18HsD1pK+4nkIRdwy2xvYAh13PyVGY8uDdHl5Nts+njwZgKnBsverZsqfjeYWvSpQzj2E0sIy7MLj9/MfPS8IpLcnxBzdP2xgfvJiV8RKRfB3UYy3ICCqRI5PXRyWho0gPUQ==";
//        String param = "csvd7ma+l+eOjNyJlUA80tiTdxLJwuzoyy7u1FQclWg+YPePon3yNocXAyDUZh+rRTn+Pfsb0B2ms1u/BnRsEFyC+5XpQdLWFRVMJJNYSBMcx4KfTD8WAKJ2M3F2LEOLPi6f0Q2QUEdtp5eMUWhnPgfVe4G1cFZeZE3WqBt/aMt2JwtcaGMeKwK0i/p7DS8opXsvnU5YGxcoDBMWvYxF90Z5elTrePOeHbMJLduEvgZWzfJ9FJ8+ociAAp2jXvQ62XIUvtUIH7w+5uFuhyw3oWGWl0maYXgZ3S+iICrMD7nKHqDfFEM1SmsgQ7FfJ/Lrl8NBBSXuNWDsdpJvR+iTzzTgYs+ffDmpUp4UHpgqEatK0NGbv+VrDl/UrC2REnRquFt1WS2DeGYJr8vFiKJkyc6fBK3dl1DTvnH2Q+j6LYH2rOGTTIGhS7Nch1O9IRehwgqnQtvKYx1uILYmhLSdQUp5Q/TasDwzWuznam41y2Naj3CiZMrgxjNUvHFsJSfh";
        String param = null;
        String s = HttpsUtils.postBlueDeer(url, param);
        System.out.println(s);
    }
}