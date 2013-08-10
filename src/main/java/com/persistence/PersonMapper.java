package com.persistence;

import java.util.List;

import com.po.Person;

public interface PersonMapper {

	void insertPerson(Person person);
	
	void updatePerson(Person person);
	
	void deletePerson(String id);
	
	Person findPerson(String id);
	
	List<Person> queryAllPerson();
	
}
