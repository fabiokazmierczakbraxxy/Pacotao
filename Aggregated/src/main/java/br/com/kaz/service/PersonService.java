package br.com.kaz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.kaz.dao.PersonDao;
import br.com.kaz.model.Person;

@Service
public class PersonService {

	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(Person person) {
		if(!getPersonByName(person.getName()).isPresent())
			return personDao.insertPerson(person);
		return 0;
	}
	
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonByName(String name) {
		return personDao.selectPersonByName(name);
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePersonById(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person newPerson) {
		return personDao.updatePersonById(id, newPerson);
	}
}
