package com.helloweenvsfei.spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {

	public void initDatabase() {

		String sql = " create table if not exists tb_person "
				+ " (id int auto_increment, " + " name varchar(255), "
				+ " sex varchar(10),  age int, "
				+ " birthday timestamp,  primary key (id ) ) ";

		getJdbcTemplate().execute(sql);
	}

	@SuppressWarnings("all")
	public List<Person> listPersons() {

		String sql = " select id, name, sex, age, birthday from tb_person ";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		List<Person> personList = new ArrayList<Person>();

		for (Map<String, Object> row : list) {

			Person person = new Person();

			person.setId((Integer) row.get("id"));
			person.setName((String) row.get("name"));
			person.setSex((String) row.get("sex"));
			person.setAge((Integer) row.get("age"));
			person.setBirthday((Date) row.get("birthday"));

			personList.add(person);
		}

		return personList;
	}

	public void addPerson(Person person) {

		String sql = " insert into tb_person "
				+ " ( name, sex, age, birthday ) values ( ?, ?, ?, ? ) ";

		getJdbcTemplate().update(
				sql,
				new Object[] { person.getName(), person.getSex(),
						person.getAge(), person.getBirthday(), });
	}

	public String getPersonName(Integer id) {

		String sql = " select name from tb_person where id = " + id;

		return (String) getJdbcTemplate().queryForObject(sql, String.class);
	}

	public int getPersonsCount() {

		String sql = " select count(*) from tb_person ";

		return getJdbcTemplate().queryForInt(sql);
	}

	public List findAllPersons() {

		PersonMappingQuery personQuery = new PersonMappingQuery();
		personQuery.setDataSource(getDataSource());
		personQuery.setSql(" select * from tb_person ");
		// personQuery.declareParameter(new SqlParameter(Types.NUMERIC));
		personQuery.compile();

		return personQuery.execute(new Object[] {});
	}

	public void testTransactions() {

		Person person = new Person();
		person.setName("P.J.");
		person.setSex("");

		addPerson(person);

		getPersonName(Integer.MAX_VALUE);
	}

}
