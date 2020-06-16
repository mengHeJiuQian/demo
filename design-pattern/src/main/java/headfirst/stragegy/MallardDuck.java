package headfirst.stragegy;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:25
 * @Version: 1.0
 * Description:
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a real Mallard duck");
    }

}
