package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Address;
import com.helloweenvsfei.hibernate.bean.Customer;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedCustomerAddress {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Customer customer = new Customer();
		customer.setName("Helloween");

		Address address = new Address();
		address.setAddress("北京市海淀区中关村");
		address.setTelephone("010-77883210");
		address.setZip("100001");

		// address.setCustomer(customer);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		// 保存 customer，数据库会为 customer 自动分配 ID
		session.persist(customer);

		// 要手工设置 address 的 ID 保证两个ID一致
		address.setId(customer.getId());

		// 保存 address
		session.persist(address);

		session.flush();

		List<Customer> list = session.createQuery(
				" select c from Customer c where c.name = :name ")
				.setParameter("name", "Helloween").list();

		for (Customer c : list) {
			session.refresh(c);
			System.out.println("客户姓名：" + c.getName());
			System.out.println("\t电话：" + c.getAddress().getTelephone());
			System.out.println("\t邮编：" + c.getAddress().getZip());
			System.out.println("\t地址：" + c.getAddress().getAddress());
		}

		session.getTransaction().commit();
		session.close();
	}
}
