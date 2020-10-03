package com.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.demo.model.Person;

public interface PersonDAO extends ObjectDAO<Person> {
  Optional<Person> getPersonById(UUID id) throws Exception;

  void updateMany(List<UUID> listId, List<Person> listPerson) throws Exception;

  void deleteMany(List<UUID> listId) throws Exception;
}