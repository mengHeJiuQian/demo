package headfirst.stragegy.duck;

import headfirst.stragegy.duck.fly.FlyNoWay;
import headfirst.stragegy.duck.quack.Quack;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午10:24
 * @Version: 1.0
 * Description: 模型鸭子
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        // 一开始，这个模型鸭子是不会飞的
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck");
    }

}
