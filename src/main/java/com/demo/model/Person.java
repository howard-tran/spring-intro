package com.demo.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
  private UUID Id;

  @NotBlank
  private String Name;

  public Person(@JsonProperty("id") UUID Id, @JsonProperty("name") String Name) {
    this.Id = Id;
    this.Name = Name;
  }

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
