package headfirst.stragegy.war;

import headfirst.stragegy.war.weapon.WeaponBehavior;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午11:06
 * @Version: 1.0
 * Description: 抽象角色类
 */
public abstract class Character {

    WeaponBehavior weaponBehavior;

    // 抽象的打斗方法，留子类实现
    public abstract void fight();

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

}
