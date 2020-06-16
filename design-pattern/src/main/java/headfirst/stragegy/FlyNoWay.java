package headfirst.stragegy;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:14
 * @Version: 1.0
 * Description:
 */
public class FlyNoWay implements FlyBehavior {

    /**
     * 有些是不会飞的行为。
     */
    @Override
    public void fly() {
        System.out.println("I can not fly");
    }

}
