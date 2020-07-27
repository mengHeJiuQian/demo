package metlife.wechat.common;

import com.metlife.wechat.common.utils.AesTool;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author：yang.liu
 * @create time：2020/7/27 16:28
 * @version：1.0
 * @description： 测试AES工具
 */
public class AesToolTest {

    /**
     * 测试AES的加解密功能
     */
    @Test
    public void testEncryptAndDecrypt() {
        String encrypt = AesTool.encrypt("0123456789", "KEYS");
        String decrypt = AesTool.decrypt(encrypt, "KEYS");
        Assert.assertEquals("3VopPVGwnHg5NtPBxSjWkw==", encrypt);
        Assert.assertEquals("0123456789", decrypt);

        String str = "{}";

        /*String str = "{\n" +
                "    \"serviceOrderId\":\"202007271129\",\n" +
                "    \"serviceDate\":\"2020-07-27 14:29:00\",\n" +
                "    \"reserveDate\":\"2020-07-27 14:29:00\",\n" +
                "    \"customerId\":\"01006458\",\n" +
                "    \"customerName\":\"空中苏州\",\n" +
                "    \"customerRole\":\"01\",\n" +
                "    \"relativeName\":null,\n" +
                "    \"relativeBirthday\":\"2000-01-01\",\n" +
                "    \"relativeTypeCode\":\"01\",\n" +
                "    \"idType\":\"04\",\n" +
                "    \"idCard\":\"202002271406\",\n" +
                "    \"tel\":\"13062773639\",\n" +
                "    \"policyNo\":\"01292585\",\n" +
                "    \"productName\":\"都会天使（2017）\",\n" +
                "    \"productCode\":\"MR12AR\",\n" +
                "    \"packageName\":\"都会天使(2017)-MR12AR-都会天使(2017)\",\n" +
                "    \"packageCode\":\"F32D3E01-1FF6-4F3D-936D-E3EA8059770D\",\n" +
                "    \"serviceName\":\"上门护理康复指导\",\n" +
                "    \"serviceCode\":\"HRS-29\",\n" +
                "    \"serviceStatus\":\"已预约\",\n" +
                "    \"serviceStatusCode\":\"01\",\n" +
                "    \"serviceNumber\":2,\n" +
                "    \"residueNumber\":0,\n" +
                "    \"messageTemplateType\":\"01\",\n" +
                "    \"messageTemplateUrl\":\"www.baidu.com\",\n" +
                "    \"messageTemplateDate\":\"2020-06-16 14:29:00\"\n" +
                "}";*/
        String encryptStr = AesTool.encrypt(str, "MetLife&VHS.2020");
        System.out.println(encryptStr);
    }

}
