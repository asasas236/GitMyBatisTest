package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.po.Person;
import com.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping("/add")
	public void add(Person person,HttpServletResponse response) throws IOException{
		personService.insert(person);
		response.sendRedirect("queryAll");
	}
	@RequestMapping("/queryAll")
	public ModelAndView queryAll(){
		List<Person> list = personService.queryAll();
		ModelAndView modelAndView =new ModelAndView("../index");
		modelAndView.addObject("allPerson", list);
		return modelAndView;
	}
	
	@RequestMapping("/findById")
	public ModelAndView findById(String id){
		List<Person> list = new ArrayList<Person>();
		if (id!=null&&!id.isEmpty()) {
			list.add(personService.findById(id));
		}else{
			list.addAll(personService.queryAll());
		}
		ModelAndView modelAndView =new ModelAndView("../index");
		modelAndView.addObject("allPerson", list);
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public void delete(String id,HttpServletResponse response) throws IOException{
		personService.delete(id);
		response.sendRedirect("queryAll");
	}
	
	@RequestMapping("/update")
	public void update(Person person,HttpServletResponse response) throws IOException{
		person.setName(person.getName()+"1");
		personService.update(person);
		response.sendRedirect("queryAll");
	}
}
