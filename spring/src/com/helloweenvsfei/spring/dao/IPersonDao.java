package com.helloweenvsfei.spring.dao;

import java.util.List;

public interface IPersonDao {

	public String getPersonName(Integer id);

	public void addPerson(Person person);

	public int getPersonsCount();

	public List<Person> listPersons();

	public List findAllPersons();
	
	public void testTransactions();

}
