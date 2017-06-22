package com.helloweenvsfei.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

public class PersonMappingQuery extends MappingSqlQuery {

	@Override
	protected Object mapRow(ResultSet rs, int columnIndex) throws SQLException {

		Person person = new Person();

		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setSex(rs.getString("sex"));
		person.setAge(rs.getInt("age"));
		person.setBirthday(rs.getTimestamp("birthday"));

		return person;
	}

}
