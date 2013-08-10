package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistence.PersonMapper;
import com.po.Person;

@Service("personService")
public class PersonService {
	
	@Autowired
	private PersonMapper personMapper;

	public void insert(Person person){
		personMapper.insertPerson(person);
	}
	
	public void update(Person person){
		personMapper.updatePerson(person);
	}
	
	public void delete(String id){
		personMapper.deletePerson(id);
	}
	
	public Person findById(String id){
		return personMapper.findPerson(id);
	}
	
	public List<Person> queryAll(){
		return personMapper.queryAllPerson();
	}
}
