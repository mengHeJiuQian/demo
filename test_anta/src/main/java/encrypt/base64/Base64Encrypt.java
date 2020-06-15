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
        String msg = "liuyang";
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(msg.getBytes());
        System.out.println(encode);

        encode = "/sgWw+TlEIT3XHv9luYj7tV/06n19id7mTUMLp/ywXU=";
        byte[] decode = Base64.getDecoder().decode(encode);
        String message = new String(decode);
        System.out.println(message);
    }

}
