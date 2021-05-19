package example.spring5.aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
//增强的类
/**
 * @author hua
 * @create 2021-04-07 15:58
 */
public class UserProxy {
    @Pointcut(value = "execution(* example.spring5.aopAnno.User.add(..))")
    public void point(){
    }
    // 前置通知
    @Before(value = "point()")
    public void before(){
        System.out.println("before......");
    }
    // 最终通知，有异常也执行
    @After(value = "point()")
    public void after(){
        System.out.println("after......");
    }
    // 后置通知，有异常不执行
    @AfterReturning(value = "point()")
    public void afterReturning(){
        System.out.println("afterReturning......");
    }
    // 异常通知，有异常才执行
    @AfterThrowing(value = "point()")
    public void afterThrowing(){
        System.out.println("afterThrowing......");
    }
    // 环绕通知
    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕之前......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后......");
    }
}
