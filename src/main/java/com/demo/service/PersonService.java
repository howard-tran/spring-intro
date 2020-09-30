package com.demo.service;

import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

import com.demo.dao.*;
import com.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final ObjectDAO<Person> _personDAO;

  @Autowired
  PersonService(@Qualifier("PersonTable") ObjectDAO<Person> _personDAO) {
    this._personDAO = _personDAO;
  }

  public int addPerson(Person _person) {
    return _personDAO.add(_person);
  }

  public List<Person> getAllPerson() {
    return PersonDAO.class.cast(_personDAO).getAllPerson();
  }

  public Optional<Person> getPersonById(UUID id) {
    return PersonDAO.class.cast(_personDAO).getPersonById(id);
  }

  public int deletePersonById(UUID id) {
    return PersonDAO.class.cast(_personDAO).delete(id);
  }

  public int updatePersonById(UUID id, Person newPerson) {
    return PersonDAO.class.cast(_personDAO).update(id, newPerson);
  }
}
