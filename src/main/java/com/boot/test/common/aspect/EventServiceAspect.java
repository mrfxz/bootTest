package com.boot.test.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 事件service层切面
 */
@Aspect
@Component
public class EventServiceAspect {

    /**
     * 切点,切event的service层
     * 表达式还可以写为
     * * com.boot.test..service..*.*(..) 切所有模块的service层与下面相同
     * * com.boot.test.*.service.*.*.*(..)
     */
    @Pointcut("execution(* com.boot.test.event.controller.*.*(..))")
    public void pointCut(){

    }

    /**
     * 环绕通知
     * ProceedingJoinPoint.proceed()调用后才会执行目标方法
     * @param point
     */
    @Around("pointCut()")
    public void around(ProceedingJoinPoint point){
        System.out.println("===========环绕通知前置================");
        try{
            point.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        System.out.println("===========环绕通知后置================");
    }

    @Before("pointCut()")
    public void before(JoinPoint point){
        System.out.println("===========before前置通知================");
    }

    @AfterReturning(returning ="result",pointcut = "pointCut()")
    public void afterReturning(Object result){
        System.out.println("===========afterReturning通知================");
    }

    @After("pointCut()")
    public void after(JoinPoint point){
        System.out.println("===========一定执行的after通知================");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint throwing){
        System.out.println("===========异常处理throwing通知================");
    }
}
