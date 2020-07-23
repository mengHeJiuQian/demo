package springstudy.myioc;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 18:18
 * 版本：1.0
 * 内容描述：
 */
public interface MyBeanFactory {

    Object getBeanByName(String name) throws Exception;
}
