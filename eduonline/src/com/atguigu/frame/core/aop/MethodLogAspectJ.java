package com.atguigu.frame.core.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.atguigu.frame.core.annotation.MethodLog;

@Component
@Aspect
public class MethodLogAspectJ {

	@Pointcut("execution(* com.atguigu..service.*.*(..))")
	public void methodLogPointcut() {

	}

	@Before("execution(* com.atguigu.sys.service.impl.*.*(..))")
	public void before() {
		System.out.println("before11........");
	}

	@After("methodLogPointcut()")
	public void after() {
		System.out.println("after........");
	}

	//@Around("methodLogPointcut()")
	public Object methodLogHold(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("aop start ");
		String methodRemark = getMthodRemark(joinPoint);
		Object result = null;
		try {
			// 记录操作日志...谁..在什么时间..做了什么事情..
			result = joinPoint.proceed();
		} catch (Exception e) {
			// 异常处理记录日志..log.error(e);
			throw e;
		}

		System.out.print(methodRemark);
		System.out.println("aop end ");
		return result;
	}

	// 获取方法的中文备注____用于记录用户的操作日志描述
	public static String getMthodRemark(ProceedingJoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();

		Class targetClass = Class.forName(targetName);
		Method[] method = targetClass.getMethods();
		String methode = "";
		for (Method m : method) {
			if (m.getName().equals(methodName)) {
				Class[] tmpCs = m.getParameterTypes();
				if (tmpCs.length == arguments.length) {
					MethodLog methodLog = m.getAnnotation(MethodLog.class);
					methode = methodLog.remark();
					break;
				}
			}
		}
		return methode;
	}

}