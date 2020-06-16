package headfirst.stragegy;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:24
 * @Version: 1.0
 * Description: 测试类
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        // 创建一个绿头鸭对象
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
    }

}
