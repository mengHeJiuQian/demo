package headfirst.stragegy.war.weapon;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午11:08
 * @Version: 1.0
 * Description: 匕首武器
 */
public class KnifeWeapon implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("使用匕首武器");
    }

}
