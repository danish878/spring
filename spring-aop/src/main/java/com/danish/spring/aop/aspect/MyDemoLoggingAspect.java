package com.danish.spring.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.danish.spring.aop.Account;
import com.danish.spring.aop.demo.AroundDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

    // add a new advice for @After on the findAccounts method
    @Around("execution(* com.danish.spring.aop.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n===>>> Executing @Around on method: " + method);

        // get being timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the Exception
            logger.warning(e.getMessage());

            // give user a custom message
//			result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            // rethrow Exception
            throw e;
        }
        // get end timestamp
        long end = System.currentTimeMillis();

        // computer duration and display it
        long duration = end - begin;
        logger.info("\n===>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    // add a new advice for @After on the findAccounts method
    @After("execution(* com.danish.spring.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n===>>> Executing @After on method: " + method);
    }

    // add a new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(pointcut = "execution(* com.danish.spring.aop.dao.AccountDAO.findAccounts(..))", throwing = "ex")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n===>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        logger.info("\n===>>> The exception is: " + ex);
    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.danish.spring.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n===>>> Executing @AfterReturning on method: " + method);

        /****** let's post-process the data ... let's modify it :-) ******/

        // convert the account names to upper case
        convertAccountNamesToUpperCase(result);

        // print out the results of the method call
        logger.info("\n===>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account account : result) {

            // get uppercase version of name
            String upperCaseName = account.getName().toUpperCase();

            // update the name on the account

            account.setName(upperCaseName);
        }

    }

    @Before("com.danish.spring.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n===>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        // display method argument
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info(arg.toString());

            if (arg instanceof String/* ,Account, etc. */) {
                // to downcast objects
            }
        }
    }

}
