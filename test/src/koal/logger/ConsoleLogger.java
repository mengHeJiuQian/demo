package koal.logger;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 14:04
 * 版本：1.0
 * 内容描述：
 */
public class ConsoleLogger implements PrintLogger {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

}
