package core1.chapter06.staticmethod;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/6 11:05
 */
public class Dog extends Animal {
    public static void main(String[] args) {
        int a = Dog.age;
        int b = Animal.age;
    }

}
