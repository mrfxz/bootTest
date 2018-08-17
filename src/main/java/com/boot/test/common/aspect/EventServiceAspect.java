package com.boot.test.common.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 事件service层切面
 */
@Aspect
@Component
public class EventServiceAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 切点,切event的service层
     * 表达式还可以写为
     * * com.boot.test..service..*.*(..) 切所有模块的service层与下面相同
     * * com.boot.test.*.service.*.*.*(..)
     */
    @Pointcut("execution(* com.boot.test.event.service.*.*(..))")
    public void pointCut(){

    }
    @Pointcut("execution(* com.boot.test.poi.service.*.*(..))")
    public void arround(){

    }

    /**
     * 环绕通知
     * ProceedingJoinPoint.proceed()调用后才会执行目标方法
     * @param point
     */
    @Around("pointCut()")
    public void around(ProceedingJoinPoint point){
        String aspectedClassName = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
//        logger.info( "开始调用" + aspectedClassName + "." + methodName);

        try{
            point.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
//        logger.info( "调用结束" + aspectedClassName + "." + methodName);
    }

//    @Before("pointCut()")
    public void before(JoinPoint point){
        System.out.println("===========前置通知================");
    }

//    @AfterReturning(returning ="result",pointcut = "pointCut()")
    public void afterReturning(Object result){
        System.out.println("===========结果通知================");
    }

//    @After("pointCut()")
    public void after(JoinPoint point){
        System.out.println("===========后置通知================");
    }

    /**
     * 异常通知和环绕通知有冲突,不要一起使用
     * @param point
     * @param ex
     */
    //@AfterThrowing(pointcut = "pointCut()",throwing="ex")
    public void afterThrowing(JoinPoint point ,Exception ex){
        System.out.println("===========异常通知================");
    }
}
