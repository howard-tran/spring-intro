package com.demo.dao;

import java.util.*;
import com.demo.model.Person;

public interface ObjectDAO<T> {
  int insert(UUID _id, T t);

  int delete(UUID id);

  int update(UUID id, T t);

  default int add(T t) {
    UUID _id = UUID.randomUUID();
    return insert(_id, t);
  }
}
