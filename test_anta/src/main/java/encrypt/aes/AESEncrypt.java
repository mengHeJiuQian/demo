package encrypt.aes;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建人：yang.liu
 * 创建时间：2020/6/11 12:52
 * 版本：1.0
 * 内容描述：
 */
public class AESEncrypt {

    @Test
    public void testAesEncrypt() throws Exception {
        String msg = "liuyang";
        String key = "KEY_STRING";
        byte[] keyBytes = md5(key);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));
        byte[] encryptedByte = cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));

        String s = Base64.encodeBase64String(encryptedByte);
        System.out.println(s);
    }

    private static byte[] md5(String key) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] digest = md5.digest(key.getBytes(StandardCharsets.UTF_8));
        return digest;
    }

}
