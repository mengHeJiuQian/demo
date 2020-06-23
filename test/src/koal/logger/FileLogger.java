package koal.logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 14:04
 * 版本：1.0
 * 内容描述：
 */
public class FileLogger implements PrintLogger {

    private BufferedWriter bw;
    private String logdir = "logs";

    @Override
    public void print(String msg) {
        getWriter();
        try {
            bw.newLine();
            bw.write(msg);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedWriter getWriter() {
        if (bw != null) {
            return bw;
        }
        Date now = new Date();
        File file = new File(logdir
                + File.separator + new SimpleDateFormat("yyyy年").format(now)
                + File.separator + new SimpleDateFormat("MM月").format(now)
                + File.separator + new SimpleDateFormat("dd").format(now)
                + "日.log");
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                file.createNewFile();
            }
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bw;
    }
}
