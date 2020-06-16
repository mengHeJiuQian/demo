package headfirst.stragegy;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:27
 * @Version: 1.0
 * Description:
 */
public class Quack implements QuackBehavior {

    /**
     * 鸭子叫
     */
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
