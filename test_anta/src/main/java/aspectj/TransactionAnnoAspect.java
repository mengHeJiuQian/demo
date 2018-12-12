package aspectj;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/10/25 10:43
 */
@Component
@Aspect
public class TransactionAnnoAspect {


    @Around(value = "@annotation(aspectj.TransactionAnno) && @annotation(ta)")
    public void myRound(ProceedingJoinPoint pjp, TransactionAnno ta) {

        /*String transactionName = ta.transactionName();
        if (StringUtils.isNotBlank(transactionName)) {
            System.out.println("开启事务名称为：" + ta.transactionName());
        } else {
            System.out.println("开启匿名事物");
        }


        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("关闭事物");*/


        System.out.println("around1");
        try {
            pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around2");


    }

//    @Before(value = "@annotation(aspectj.TransactionAnno) && @annotation(ta)")
//    public void myBefore(ProceedingJoinPoint pjp, TransactionAnno ta) {
//        System.out.println("before");
//    }
//
//    @After(value = "@annotation(aspectj.TransactionAnno) && @annotation(ta)")
//    public void myAfter(ProceedingJoinPoint pjp, TransactionAnno ta) {
//        System.out.println("after");
//    }
//
//    @AfterReturning(value = "@annotation(aspectj.TransactionAnno) && @annotation(ta)")
//    public void myAfterReturning(ProceedingJoinPoint pjp, TransactionAnno ta) {
//        System.out.println("afterReturning");
//    }
//
//    @AfterThrowing(value = "@annotation(aspectj.TransactionAnno) && @annotation(ta)")
//    public void myAfterThrowing(ProceedingJoinPoint pjp, TransactionAnno ta) {
//        System.out.println("afterThrowing");
//    }

}
