package lock;

import java.io.*;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/12 10:15
 * 版本：1.0
 * 内容描述：
 */
public class OptimThread extends Thread {

    // 文件版本号
    public int version;
    // 文件
    public String file;

    public OptimThread(String name,int version,String file){
        this.setName(name);
        this.version = version;
        this.file = file;
    }

    public void run() {
        // 1. 读取文件
        String text = read(file);
        println("线程"+ getName() + "，文件版本号为：" + OptimLockMain.getVersion());
        println("线程"+ getName() + "，版本号为：" + getVersion());
        // 2. 写入文件
        if(OptimLockMain.getVersion() == getVersion()){
            println("线程" + getName() + "，版本号为：" + version + "，正在执行");
            // 文件操作，这里用synchronized就相当于文件锁
            // 如果是数据库，相当于表锁或者行锁
            synchronized(OptimThread.class){
                if(OptimLockMain.getVersion() == this.version){
                    // 写入操作
                    write(file, text);
                    // 更新文件版本号
                    OptimLockMain.updateVersion();
                    return ;
                }
            }
        }
        // 3. 版本号不正确的线程，需要重新读取，重新执行
        println("线程"+ getName() + "，文件版本号为：" + OptimLockMain.getVersion());
        println("线程"+ getName() + "，版本号为：" + getVersion());
        System.err.println("线程"+ getName() + "，需要重新执行。");
    }

    /**
     * @return
     */
    private int getVersion(){
        return this.version;
    }

    /**
     * 写入数据
     *
     * @param file
     * @param text
     */
    public static void write(String file,String text){
        try {
            FileWriter fw = new FileWriter(file,false);
            fw.write(text + "\r\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取数据
     *
     * @param file
     * @return
     */
    public static String read(String file){
        StringBuilder sb = new StringBuilder();
        try {
            File rFile = new File(file);
            if(!rFile.exists()){
                rFile.createNewFile();
            }
            FileReader fr = new FileReader(rFile);
            BufferedReader br = new BufferedReader(fr);
            String r = null;
            while((r=br.readLine())!=null){
                sb.append(r).append("\r\n");
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * @param content
     */
    public static void println(String content){
        System.out.println(content);
    }

}

