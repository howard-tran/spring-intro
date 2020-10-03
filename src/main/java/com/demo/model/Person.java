package com.demo.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Person {

  public Person() {
  }

  public Person(UUID id, Person t) {
    this.id = id;
    this.jobs = t.jobs;
    this.name = t.name;
    this.user = t.user;
    this.date = t.date;
  }

  public class User {
    private String name;
    private String pass;

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPass() {
      return this.pass;
    }

    public void setPass(String pass) {
      this.pass = pass;
    }

  }

  public UUID id;

  @NotBlank
  private String name;
  @NotBlank
  private List<String> jobs;
  @NotBlank
  private User user;

  private String date;

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getJobs() {
    return this.jobs;
  }

  public void setJobs(List<String> jobs) {
    this.jobs = jobs;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
