package headfirst.stragegy.duck;

import headfirst.stragegy.duck.Duck;
import headfirst.stragegy.duck.fly.FlyWithWings;
import headfirst.stragegy.duck.quack.Quack;

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
