package com.demo.dao;

import java.util.*;

public interface ObjectDAO<T> {
  void insert(T t) throws Exception;

  void insertMany(List<T> listT) throws Exception;

  void delete(UUID id) throws Exception;

  void update(UUID id, T t) throws Exception;
}
