package transfer;

import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/10/10 16:20
 */
public class Decode {
    public static void main(String[] args) {
        //String dataLine = "RklMQeW5s+WPsCPlkKYjMDAwMjM1ZjVjNjVkM2YxYjNkYzZkN2FhMzFlMTkyZjMjIyMjMTk3NyMj6Z+p6ImzIzA3LTA3IzE1OTk4OTA2MDUyI+WlsyMyOTM0QjAwMDUj";
        String dataLine = "5bmz5Y+wI+aYr+WQpuaOp+WItue7hCPkvJrlkZhJRCPln47luIIj5Zyw5Yy6I+ecgeS7vSPnlJ/ml6XlubTku70jRW1haWwj5aeT5ZCNI+eUn+aXpSPmiYvmnLrlj7cj5oCnIOWIqyPljaHlj7c=";

        String encodeStr = null;
        try {
            encodeStr = new String(org.apache.commons.codec.binary.Base64.decodeBase64(dataLine.getBytes()), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encodeStr);
    }
}
