package headfirst.stragegy.war.weapon;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午11:09
 * @Version: 1.0
 * Description: 宝剑武器
 */
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("使用宝剑武器");
    }

}
