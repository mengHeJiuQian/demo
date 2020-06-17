package headfirst.stragegy.duck.quack;

/**
 * @author: sheldon
 * @Date: 2020/6/16 下午11:28
 * @Version: 1.0
 * Description:
 */
public class MuteQuack implements QuackBehavior {

    /**
     * 沉默的叫声
     */
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }

}
