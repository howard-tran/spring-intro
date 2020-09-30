package com.demo.api.v1;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.demo.model.Person;
import com.demo.model.Response;
import com.demo.model.Response.ErrorType;
import com.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
  private final PersonService _personService;

  @Autowired
  public PersonController(PersonService _personService) {
    this._personService = _personService;
  }

  @PostMapping(path = "add")
  public void addPerson(@Valid @NotNull @RequestBody Person _person) {
    _personService.addPerson(_person);

    System.out.println(_person.getName());
  }

  @GetMapping(path = "getAll")
  public Response<Object> getAllPerson() {
    return new Response<Object>(_personService.getAllPerson(), ErrorType.OK);
  }

  @PostMapping(path = "remove")
  public void removePerson(@RequestParam(name = "id", required = true) UUID id) {
    _personService.deletePersonById(id);
  }

  @PostMapping(path = "update")
  public void updatePerson(@RequestParam(name = "id", required = true) UUID id,
      @Valid @NotNull @RequestBody Person newPerson) {
    _personService.updatePersonById(id, newPerson);
  }

  @GetMapping(path = "get")
  public Response<Object> getPerson(@RequestParam(name = "id", required = true) UUID id) {
    Optional<Person> _result = _personService.getPersonById(id);

    if (_result.isEmpty()) {
      return new Response<Object>("", ErrorType.NOT_FOUND);
    } else {
      return new Response<Object>(_result, ErrorType.OK);
    }
  }
}