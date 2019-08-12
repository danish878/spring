package com.danish.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.danish.spring.aop.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.danish.spring.aop.dao.*.set*(..))")
    public void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.danish.spring.aop.dao.*.get*(..))")
    public void setter() {
    }

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
