package utils;

import com.alibaba.fastjson.JSON;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectUtil {


    public static boolean isSamePropertyValue(Object oldObj, Object newObj) {
        return JSON.toJSONString(oldObj).equals(JSON.toJSONString(newObj));
    }

    /**
     * source对象的属性复制到target对象中，仅仅复制非null的属性.
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesWithValue(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    /**
     * 获取一个对象中的属性为null的数组.
     * @param source source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
