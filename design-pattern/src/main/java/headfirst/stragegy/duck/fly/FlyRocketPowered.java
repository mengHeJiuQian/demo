package headfirst.stragegy.duck.fly;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午10:26
 * @Version: 1.0
 * Description: 利用火箭动力的飞行行为
 */
public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am flying with a rocket!");
    }

}
