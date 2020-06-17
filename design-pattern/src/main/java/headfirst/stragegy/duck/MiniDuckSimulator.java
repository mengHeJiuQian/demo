package headfirst.stragegy.duck;

import headfirst.stragegy.duck.fly.FlyRocketPowered;

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

        // 创建一个模型鸭子
        Duck model = new ModelDuck();
        model.performFly(); // 此时模型鸭子不会飞
        // 此时模型鸭子是火箭动力飞行能力
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }

}
