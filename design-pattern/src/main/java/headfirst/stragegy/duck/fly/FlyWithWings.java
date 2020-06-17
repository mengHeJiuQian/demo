package headfirst.stragegy.duck.fly;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:13
 * @Version: 1.0
 * Description:
 */
public class FlyWithWings implements FlyBehavior {

    /**
     * 真正会飞的实现
     */
    @Override
    public void fly() {
        System.out.println("I am flying");
    }

}
