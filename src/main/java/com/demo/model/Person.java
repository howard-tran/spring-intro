package com.demo.model;

import java.util.*;

public class Person {
  private UUID Id;
  private String Name;

  public UUID getId() {
    return this.Id;
  }

  public void setId(UUID Id) {
    this.Id = Id;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

}
