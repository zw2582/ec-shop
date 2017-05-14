package com.example.interceptor;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 创建AOP切面
 */
@Aspect
@Component
public class ControllerInterceptor {

	/**
	 * 创建AOP切点规则
	 */
	@Pointcut("execution(* com.example.controllers..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)") 
	public void controllerMethodPointCut(){};

	/**
	 * 切点执行程序
	 * @param pjp
	 * @return
	 */
	@Around("controllerMethodPointCut()")
	public Object Interceptor(ProceedingJoinPoint pjp) {
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		Method method = signature.getMethod();
		
		Object[] args = pjp.getArgs();
		System.out.println("------------before aop--------------");
		System.out.println("method:"+method.getName());
		System.out.println("args:"+args);
		
		System.out.println("------------------------------------");
		
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			System.out.println("--------------throw a exception----");
		}
		
		System.out.println("-----------------after aop----------");
		
		return result;
	}
	
}
