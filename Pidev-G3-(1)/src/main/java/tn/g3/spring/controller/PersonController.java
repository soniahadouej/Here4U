package tn.g3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.g3.spring.entity.Person;
import tn.g3.spring.service.IPersonService;

@RestController
public class PersonController {

	@Autowired
	IPersonService ps;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-person
	@GetMapping("/retrieve-all-person")
	@ResponseBody
	public List<Person> getPersons() {
		List<Person> list = ps.retrieveAllPersons();
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-person/{person-id}
	@GetMapping("/retrieve-person/{person-id}")
	@ResponseBody
	public Person retrievePerson(@PathVariable("person-id") String id) {
		return ps.retrievePerson(id);
	} 


/*
    "idPerson":"idPerson","personType":"personType","firstName":"firstName",
    "lastName":"lastName","phoneNumber":"phoneNumber","age":"age","sex":"sex",
    "region":"region","city":"city","postalCode" : "postalCode", "street" :"street",
    "cin":"cin","typeGrade":"typeGrade","salary":"salary","delay":"delay","warning":"warning",
    "login":"login","passssword":"password","email":"email","category":"category","job":"job","startDate":"startDate"
*/	
	
	
	
	// http://localhost:8081/SpringMVC/servlet/add-person 
	@PostMapping("/add-person")
	@ResponseBody
	public Person addPerson(@RequestBody Person p) {
		Person person = ps.addPerson(p); 
		return person;
	}

	// http://localhost:8080/SpringMVC/servlet/remove-person/{person-id}
	@DeleteMapping("/remove-person/{person-id}") 
	@ResponseBody
	public void removePerson(@PathVariable("person-id") String id) { 
		ps.deletePerson(id);
	} 



	// http://localhost:8080/SpringMVC/servlet/update-person 
	@PutMapping("/update-person") 
	@ResponseBody
	public Person updatePerson(@RequestBody Person person) {
		return ps.updatePerson(person);
	}



}
