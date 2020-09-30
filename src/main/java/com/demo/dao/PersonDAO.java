package com.demo.dao;

import java.lang.reflect.Array;
import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

import com.demo.model.Person;

import org.springframework.stereotype.Repository;

@Repository("PersonTable")
public class PersonDAO implements ObjectDAO<Person> {

  private static List<Person> PersonDB = new ArrayList<Person>();

  // insert into DB
  // 1 = sucess
  // 0 = fail
  @Override
  public int insert(UUID _id, Person _person) {

    PersonDB.add(new Person(_id, _person.getName()));
    return 1;
  }

  // update Person in DB
  // 1 = sucess
  // 0 = not found
  @Override
  public int update(UUID id, Person t) {
    return getPersonById(id).map(p -> {
      int index = PersonDB.indexOf(p);

      if (index >= 0) {
        t.setId(p.getId());
        PersonDB.set(index, t);
        return 1;
      }
      return 0;
    }).orElse(0);
  }

  // get all person
  public List<Person> getAllPerson() {
    return this.PersonDB;
  }

  // get person by id
  public Optional<Person> getPersonById(UUID id) {
    return this.PersonDB.stream().filter(person -> person.getId().equals(id)).findFirst();
  }

  // delete person by id
  // return 1 if sucess
  // return 0 if not found
  public int delete(UUID id) {
    Optional<Person> _person = getPersonById(id);

    if (_person.isEmpty()) {
      return 0;
    } else {
      this.PersonDB.removeIf(x -> x.getId().equals(id));
      return 1;
    }
  }
}