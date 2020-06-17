package headfirst.stragegy.duck;

import headfirst.stragegy.duck.fly.FlyBehavior;
import headfirst.stragegy.duck.quack.QuackBehavior;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:03
 * @Version: 1.0
 * Description:
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() { }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public abstract void display();

    // 委托给行为类
    public void performFly() {
        flyBehavior.fly();
    }

    // 委托给行为类
    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float,even decoys!");
    }
}
