package com.itachi.DemoMaven.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class AnimalAsp {
	public AnimalAsp() {
		// TODO Auto-generated constructor stub
	}
	
	@Pointcut("execution(int *.*(..))")
	void pointcut1()
	{
		
	}
	
	@Pointcut("execution(* com.itachi.DemoMaven.model2.Animal.set*(..))")
	void pointcut2()
	{
		
	}
	@Pointcut("execution(* com.itachi.DemoMaven.model2.Animal.get*(..))")
	void pointcut3()
	{
		
	}
	@Pointcut("execution(void *.*(..))")
	void pointcut4()
	{
		
	}
	@Pointcut("execution(String *.s*(..))")
	void pointcut5()
	{
		
	}
	@Pointcut("execution(int *.k*(..))")
	void pointcut6()
	{
		
	}
	
	
	
	  @Before("pointcut1()") void invokeBefore(JoinPoint jp) {
	  System.out.println("in invokeBefore"+jp.getSignature()); }
	  
	  @After("pointcut2()") void invokeAfter(JoinPoint jp) {
	  System.out.println("in invokeAfter"+jp.getSignature()); }
	 
	
	@Around("pointcut3()")
	Object invokeAround(ProceedingJoinPoint  jp)throws Throwable
	{
		System.out.println("in invokeAround"+jp.getSignature());
		Object obj=jp.proceed();
		System.out.println("out invokeAround"+jp.getSignature());
		return obj;
	}
	@AfterReturning(pointcut="pointcut5()",returning="result")
	void invokeSuccess(JoinPoint jp,Object result)
	{
		System.out.println("in invokeSuccess"+jp.getSignature());
		System.out.println("result is: "+result);
	}
	@AfterThrowing(pointcut="pointcut6()",throwing="error1")
	void invokeFailure(JoinPoint jp,Throwable error1)
	{
		System.out.println("in invokeFailure"+jp.getSignature());
		System.out.println("error is: "+error1);
	}
}
