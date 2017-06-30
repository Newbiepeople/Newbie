package com.helloweenvsfei.spring.example;

public class ServiceExample {

	private DaoExample daoExample = new DaoExample();

	public void service(String name) {
		System.out.println(daoExample.sayHello(name));
	}

}
