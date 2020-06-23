package lock;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/12 10:08
 * 版本：1.0
 * 内容描述：乐观锁,相当于数据库里的 记录信息和 版本号信息
 */
public class OptimLockMain {

    static int version = 1;
    static String file = "E:\\mytest\\lock\\IT小奋斗.txt";

    /**
     * 获取版本号
     *
     * @return
     */
    public static int getVersion(){
        return version;
    }

    /**
     * 更新版本号
     */
    public static void updateVersion(){
        version++;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            new OptimThread(String.valueOf(i),getVersion(),file).start();
        }
    }

}
