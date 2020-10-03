package com.demo.service;

import java.util.*;

import com.demo.LogManager.*;
import com.demo.dao.*;
import com.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonDAO _personDAO;

  @Autowired
  PersonService(@Qualifier("Person") PersonDAO _personDAO) {
    this._personDAO = _personDAO;
  }

  public void addPerson(Person _person) {
    try {
      PersonDAOImpl.class.cast(_personDAO).insert(_person);
      //
    } catch (Exception e) {
      LogUtils.logger.error("[ERROR]", e);
      throw new RuntimeException(e);
    }
  }

  public List<Person> getAllPerson() {
    List<Person> res = null;
    try {
      res = PersonDAOImpl.class.cast(_personDAO).getAllPerson();
      //
    } catch (Exception e) {
      LogUtils.logger.error("[ERROR]", e);
      throw new RuntimeException(e);
    }

    return res;
  }

  public Optional<Person> getPersonById(UUID id) {
    Optional<Person> res = null;

    try {
      res = _personDAO.getPersonById(id);
      //
    } catch (Exception e) {
      LogUtils.logger.error("[ERROR]", e);
      throw new RuntimeException(e);
    }
    return res;
  }

  public void deletePersonById(UUID id) {
    try {
      _personDAO.delete(id);
      //
    } catch (Exception e) {
      LogUtils.logger.error("[ERROR]", e);
      throw new RuntimeException(e);
    }
  }

  public void updatePersonById(UUID id, Person newPerson) {
    try {
      _personDAO.update(id, newPerson);
      //
    } catch (Exception e) {
      LogUtils.logger.error("[ERROR]", e);
      throw new RuntimeException(e);
    }
  }
}
