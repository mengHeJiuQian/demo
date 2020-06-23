package io;

import java.io.*;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/21 23:06
 * 版本：1.0
 * 内容描述：
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\mytest\\filecopy\\spring-framework-4.3.11.RELEASE.zip"));
        FileOutputStream fos = new FileOutputStream(new File("E:\\mytest\\filecopy\\spring-framework-4.3.11.RELEASE1.zip"));

        byte[] buff = new byte[1024];

        while (fis.read(buff) != -1) {
            fos.write(buff);
            fos.flush();
        }

        fos.close();
        fis.close();
    }
}
