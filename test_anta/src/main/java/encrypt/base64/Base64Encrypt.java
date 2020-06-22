package encrypt.base64;

import org.junit.jupiter.api.Test;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * 创建人：yang.liu
 * 创建时间：2020/6/15 13:34
 * 版本：1.0
 * 内容描述：
 */
public class Base64Encrypt {

    @Test
    public void testBase64Encrypt() {
        String msg = "刘洋";
        /*BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(msg.getBytes());*/

        String encode = Base64.getEncoder().encodeToString(msg.getBytes());

        System.out.println(encode);

        byte[] decode = Base64.getDecoder().decode(encode);
        String message = new String(decode);
        System.out.println(message);
    }

}
