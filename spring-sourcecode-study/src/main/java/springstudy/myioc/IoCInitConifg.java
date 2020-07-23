package springstudy.myioc;

import org.springframework.boot.CommandLineRunner;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 18:14
 * 版本：1.0
 * 内容描述：
 */
public class IoCInitConifg implements CommandLineRunner {

    @Override
    public void run(String... args){
        ConcurrentHashMap<String,BeanDefinition> concurrentHashMap = new ConcurrentHashMap<>();
        Reflections reflections = new Reflections();
        //获得项目中所有被MyIoc标记得类
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(MyIoc.class);
        //将其信息初始进自定义容器MyBeanFactory中
        for (Class clazz : typesAnnotatedWith){
            BeanDefinition beanDefinition = new BeanDefinition();
            String className = clazz.getName();
            String superclassName = clazz.getSuperclass().getName();
            beanDefinition.setClassName(className);
            beanDefinition.setSuperNames(superclassName);
            beanDefinition.setAlias(getClassName(className));
            concurrentHashMap.put(className,beanDefinition);
        }
        MyBeanFactoryImpl.setBeanDineMap(concurrentHashMap);
    }

    private String getClassName(String beanClassName) {
        String className = beanClassName.substring(beanClassName.lastIndexOf(".") + 1);
        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        return className;
    }

}
