package headfirst.stragegy;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:31
 * @Version: 1.0
 * Description:
 */
public class Squeak implements QuackBehavior {

    /**
     * 吱吱声
     */
    @Override
    public void quack() {
        System.out.println("Squeak");
    }

}
