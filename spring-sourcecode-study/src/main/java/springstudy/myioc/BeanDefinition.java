package springstudy.myioc;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 17:37
 * 版本：1.0
 * 内容描述：
 */
public class BeanDefinition {

    private String className;
    private String alias;
    private String superNames;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSuperNames() {
        return superNames;
    }

    public void setSuperNames(String superNames) {
        this.superNames = superNames;
    }
}
