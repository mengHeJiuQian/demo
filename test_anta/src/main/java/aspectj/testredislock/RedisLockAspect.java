package aspectj.testredislock;

import org.apache.commons.beanutils.BeanMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yu.yue
 * @Date: Created in 2018/5/24 10:19
 * @Modified By:
 * @Description:
 */
@Aspect
@Component
public class RedisLockAspect {

    @Around(value="@annotation(aspectj.testredislock.RedisLocked) && @annotation(locked)")
    public Object around(ProceedingJoinPoint joinPoint,RedisLocked locked) throws Throwable {
        String key = locked.key();
        Object[] args = joinPoint.getArgs();
        for(int i=0;i<args.length;i++){
            key = matchKey(args[i],key,String.format("args[%d]",i));
        }
        System.out.println("key = " + key);

        joinPoint.proceed();

        System.out.println("key = " + key);

        return key;
    }

    private String matchKey(Object obj,String value,String replaceStr){
        String returnValue = value;
        if(value.contains(replaceStr+".")){
            BeanMap map = new BeanMap(obj);
            Object[] matchObj = map.keySet().stream().filter(k->value.contains(String.format("%s.%s",replaceStr,k.toString()))).toArray();
            if(matchObj!=null&&matchObj.length!=0){
                for(Object o:matchObj){
                    returnValue = matchKey(map.get(o),returnValue,String.format("%s.%s",replaceStr,o.toString()));
                }
            }
        }else if(value.contains(replaceStr)){
            returnValue = returnValue.replace(replaceStr,obj==null?"":obj.toString());
        }
        return returnValue;
    }
}
