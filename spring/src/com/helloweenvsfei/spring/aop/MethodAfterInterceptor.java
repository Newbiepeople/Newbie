package com.helloweenvsfei.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterInterceptor implements AfterReturningAdvice {

	public void afterReturning(Object value, Method method, Object[] args,
			Object instance) throws Throwable {

		System.out.println("方法 " + method.getName() + "运行完毕，返回值为：" + value);

	}

}
