package book1.spring5guanwang.ioc.ltw;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/13 16:02
 * @Update Date: 2019/11/13 16:02
 */
@Aspect
@Slf4j
public class LogMethodInvokeAspect {

    @Pointcut("execution (* book1.spring5guanwang.ioc.ltw..*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void advise(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        log.info("start, signature = {}", signature);
        joinPoint.proceed();
        log.info("end, signature = {}", signature);
    }

}
