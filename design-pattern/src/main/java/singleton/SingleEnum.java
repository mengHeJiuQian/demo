package singleton;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 16:31
 * 版本：1.0
 * 内容描述：使用枚举的方式实现单例
 */
public enum SingleEnum {

    INSTANCE;

    public static SingleEnum getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        // SingleEnum se = new SingleEnum();
    }

}
