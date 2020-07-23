package com.metlife.wechat.common.utils;

import com.metlife.wechat.enums.ErrorEnum;
import com.metlife.wechat.exception.WeChatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * AES数据加解密工具类.
 * @author xuxiaodon
 */
@Slf4j
public class AesTool {
    
    /** 加解密模式. */
    private static String CIPHER_MODE = "AES/ECB/PKCS5Padding";
    
    /** 秘钥算法模式. */
    private static String ALGORITHM = "AES";

    /**
     * AES加密方法.
     * @param encryptStr 需要加密的数据
     * @param key 加密秘钥
     * @return 基于BASE64的加密字符串, 若解密异常则返回原内容
     */
    public static String encrypt(String encryptStr, String key) {
        //待加密字符串为空
        if (StringUtils.isBlank(encryptStr)) {
            return null;
        }
        
        try {
            byte[] keyBytes = md5(key);
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, ALGORITHM));
            byte[] encryptedByte = cipher.doFinal(encryptStr.getBytes(StandardCharsets.UTF_8));
            
            return Base64.encodeBase64String(encryptedByte);
        } catch (NoSuchAlgorithmException e) {
            log.error("[encrypt]:{}-NoSuchAlgorithmException:{}", encryptStr, e.getMessage());
        } catch (NoSuchPaddingException e) {
            log.error("[encrypt]:{}-NoSuchPaddingException:{}", encryptStr, e.getMessage());
        } catch (InvalidKeyException e) {
            log.error("[encrypt]:{}-InvalidKeyException:{}", encryptStr, e.getMessage());
        } catch (IllegalBlockSizeException e) {
            log.error("[encrypt]:{}-IllegalBlockSizeException:{}", encryptStr, e.getMessage());
        } catch (BadPaddingException e) {
            log.error("[encrypt]:{}-BadPaddingException:{}", encryptStr, e.getMessage());
        } catch (Exception e) {
            log.error("[encrypt]:{}-Exception:{}", encryptStr, e.getMessage());
            throw new WeChatException(ErrorEnum.DIGEST_EXCEPTION);
        }
        
        return encryptStr;
    }
    
    /**
     * AES解密方法.
     * @param decryptStr 基于BASE64的待解密数据
     * @param key 解密秘钥
     * @return 解密后的字符串, 若解密异常则返回原内容
     */
    public static String decrypt(String decryptStr, String key)  {
        //待解密字符串为空
        if (StringUtils.isBlank(decryptStr)) {
            return null;
        }
        
        try {
            byte[] keyBytes = md5(key);
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            SecretKey secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] content = Base64.decodeBase64(decryptStr);
            content = cipher.doFinal(content);
            return new String(content, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            log.error("[encrypt]:{}-NoSuchAlgorithmException:{}", decryptStr, e.getMessage());
        } catch (NoSuchPaddingException e) {
            log.error("[encrypt]:{}-NoSuchPaddingException:{}", decryptStr, e.getMessage());
        } catch (InvalidKeyException e) {
            log.error("[encrypt]:{}-InvalidKeyException:{}", decryptStr, e.getMessage());
        } catch (IllegalBlockSizeException e) {
            log.error("[encrypt]:{}-IllegalBlockSizeException:{}", decryptStr, e.getMessage());
        } catch (BadPaddingException e) {
            log.error("[encrypt]:{}-BadPaddingException:{}", decryptStr, e.getMessage());
        } catch (Exception e) {
            log.error("[encrypt]:{}-Exception:{}", decryptStr, e.getMessage());
            throw new WeChatException(ErrorEnum.DIGEST_EXCEPTION);
        }
        
        return decryptStr;
    }
    
    /**
     * 用MD5将密钥转化为16位定长密钥.
     * @param key 加解密秘钥
     * @return byte[]
     */
    private static byte[] md5(String key) {
        try {
            //生成MD5定长秘钥算法模式.
            String digestAlgorithm = "MD5";
            MessageDigest md5 = MessageDigest.getInstance(digestAlgorithm);
            return md5.digest(key.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            log.error("[md5]-NoSuchAlgorithmException:" + e.getMessage());
            throw new WeChatException(ErrorEnum.DIGEST_EXCEPTION);
        } catch (Exception e) {
            log.error("[md5]-Exception:" + e.getMessage());
            throw new WeChatException(ErrorEnum.DIGEST_EXCEPTION);
        }
    }
}


