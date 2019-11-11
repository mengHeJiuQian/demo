package aspectj.testredislock;

import json.JsonUtil;
import org.apache.commons.beanutils.BeanMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@Autowired
    private RedissonClient redissonClient;

    @Around(value="@annotation(aspectj.testredislock.RedisLocked) && @annotation(locked)")
    public Object around(ProceedingJoinPoint joinPoint,RedisLocked locked) throws Throwable {
        String key = locked.key();
        Object[] args = joinPoint.getArgs();
        for(int i=0;i<args.length;i++){
            key = matchKey(args[i],key,String.format("args[%d]",i));
        }
        System.out.println("key" + key);
        /*RLock lock = redissonClient.getLock(key);
        boolean islock=false;
        try{
            islock=tryLock(locked,lock);
            if(islock)
                return joinPoint.proceed(joinPoint.getArgs());
            else if(locked.returnValue().valueClass().equals(void.class))
                return null;
            else
                return JsonUtil.fromJson(locked.returnValue().value(),locked.returnValue().valueClass());
        }catch(Exception e){
            throw e;
        }finally {
            try {
                if (islock)
                    lock.unlock();
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
        return null;
    }

    private boolean tryLock(RedisLocked locked, RLock lock) throws InterruptedException {
        boolean islock=false;
        if(locked.blockTime().value()==0){
            islock = lock.tryLock(0,30, TimeUnit.SECONDS);
        }else{
            switch (locked.blockTime().timeType()){
                case MILLISECONDS:
                    islock = lock.tryLock(locked.blockTime().value()*2,locked.blockTime().value(), TimeUnit.MILLISECONDS);
                    break;
                case SECONDS:
                    islock = lock.tryLock(locked.blockTime().value()*2,locked.blockTime().value(), TimeUnit.SECONDS);
                    break;
                case MINUTES:
                    islock = lock.tryLock(locked.blockTime().value()*2,locked.blockTime().value(), TimeUnit.MINUTES);
                    break;
                case HOURS:
                    islock = lock.tryLock(locked.blockTime().value()*2,locked.blockTime().value(), TimeUnit.HOURS);
                    break;
            }
        }
        return islock;
    }

    /**
     *
     * @param obj
     * @param value key = "grantInstance_args[0].userId_args[0].projectId"
     * @param replaceStr args[i]
     * @return
     */
    private static String matchKey(Object obj,String value,String replaceStr){
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

    @Test
    public void testMatchKey() {
        String key = matchKey(new CreateBenefitRequest(),"grantInstance_args[0].userId_args[0].projectId", String.format("args[0]")); // output: grantInstance_user123_111
        String key1 = matchKey(new CreateBenefitRequest(),"projectId_args[0].userId_args[0].projectId", String.format("args[0]"));
        System.out.println(key);
        System.out.println(key1);
    }
}
