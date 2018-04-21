package com.akshay.springhibernatedemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//private Logger logger = Logger.getLogger(getClass().getName());
	
	//Point cuts
	@Pointcut("execution(* com.akshay.springhibernatedemo.controller.*.*(..))")
	private void forController() {}
	
	@Pointcut("execution(* com.akshay.springhibernatedemo.service.*.*(..))")
	private void forService() {}
	
	@Pointcut("execution(* com.akshay.springhibernatedemo.dao.*.*(..))")
	private void forDAO() {}
	
	@Pointcut("forController()||forService()||forDAO()")
	private void forAppFlow() {}
	
	
	//@Before Advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		System.out.println("---------\n=> @Before calling method:\t"+joinPoint.getSignature().toShortString());
		
		Object[] args = joinPoint.getArgs();
		for(Object obj : args) {
			System.out.println("***Args:\n"+obj.toString());
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturn(JoinPoint joinPoint,Object result) {
		System.out.println("=> @Returning from method:\t"+joinPoint.getSignature().toShortString()+"\n---------");
		System.out.println("Returning data:\t"+result+"\n------------");
	}
}
