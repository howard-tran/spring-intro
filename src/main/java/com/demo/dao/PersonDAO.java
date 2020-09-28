package com.demo.dao;

import java.util.*;
import com.demo.model.Person;

public interface PersonDAO {
  int insertPerson(UUID _id, Person _person);

  default int addPerson(Person _person) {
    UUID _id = UUID.randomUUID();
    return insertPerson(_id, _person);
  }
}
