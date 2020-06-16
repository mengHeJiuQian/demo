package headfirst.stragegy;

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
