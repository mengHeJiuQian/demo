package _06_uuid;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/16 13:56
 *
 * 博客园：https://www.cnblogs.com/smallyard/p/8271082.html
 */
public class Java8Tester {

    public static void main(String args[]){
        String uuid = UUID.randomUUID().toString();
        boolean isFirst = false; // 是否是左边的高位
        StringBuilder decode = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < uuid.length(); i++) {
            char ch = uuid.charAt(i);
            if ('-' == ch) {
                continue;
            }
            Byte shortValue = Byte.valueOf(String.valueOf(ch), 16);
            if (isFirst) { // 为true，则表示把表示ch二进制移到左边
                temp = temp << 4;
                temp += shortValue;
                decode.append((char) temp);
                temp = 0;
                isFirst = false;
            } else {
                temp += shortValue;
                isFirst = true;
            }
        }
        System.out.println(decode.toString());
    }

}
