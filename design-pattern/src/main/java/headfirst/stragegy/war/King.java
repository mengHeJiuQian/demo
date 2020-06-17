package headfirst.stragegy.war;

import headfirst.stragegy.war.weapon.SwordBehavior;

/**
 * @author: sheldon
 * @Date: 2020/6/17 下午11:13
 * @Version: 1.0
 * Description: 国王人物
 */
public class King extends Character {

    // 国王使用宝剑打斗
    public King() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }

}
