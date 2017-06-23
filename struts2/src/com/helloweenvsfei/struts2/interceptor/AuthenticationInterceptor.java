package com.helloweenvsfei.struts2.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -4433771430728214868L;

	@Override
	@SuppressWarnings("all")
	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> sessionValues = invocation.getInvocationContext()
				.getSession();

		String account = (String) sessionValues.get("account");

		if (account == null) {
			return Action.LOGIN;
		}

		return invocation.invoke();
	}

}
