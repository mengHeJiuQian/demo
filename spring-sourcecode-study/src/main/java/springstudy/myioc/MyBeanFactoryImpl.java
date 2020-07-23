package springstudy.myioc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/2 18:18
 * 版本：1.0
 * 内容描述：
 */
@Log4j
public class MyBeanFactoryImpl implements MyBeanFactory{
    //存储对象名称和已经实例化的对象映射
    private static ConcurrentHashMap<String,Object> beanMap = new ConcurrentHashMap<>();
    //存储对象名称和对应对象信息的映射
    private static ConcurrentHashMap<String,BeanDefinition> beanDefineMap= new ConcurrentHashMap<>();
    //存储存储在容器中对象的名称
    private static Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Object getBeanByName(String name) throws Exception {
        //看有没有已经实例化的对象,有的话就直接返回
        Object object = beanMap.get(name);
        if (object != null){
            return object;
        }
        //没有的话就实例化一个对象
        object = getObject(beanDefineMap.get(name));
        if (object != null){
            //对实例化中对象的注入需要的参数
            setFild(object);
            //将实例化的对象放入Map中,便于下次使用
            beanMap.put(name,object);
        }
        return object;
    }

    public void setFild(Object bean) throws Exception {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field: declaredFields){
            String filedAllName = field.getType().getName();
            if (beanNameSet.contains(filedAllName)){
                Object findBean = getBeanByName(filedAllName);
                //为对象中的属性赋值
                field.setAccessible(true);
                field.set(bean,findBean);
            }
        }
    }

    public Object getObject(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.info("can not find bean by beanName: "+className);
            throw new Exception("can not find bean by beanName: "+className);
        }
        return clazz;
    }

    public static void setBeanDineMap(ConcurrentHashMap<String,BeanDefinition> beanDefineMap){
        MyBeanFactoryImpl.beanDefineMap = beanDefineMap;
    }

    public static void setBeanNameSet(Set<String> beanNameSet){
        MyBeanFactoryImpl.beanNameSet = beanNameSet;
    }

}
