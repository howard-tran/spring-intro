package com.demo.api.v1;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.demo.model.Person;
import com.demo.model.Response;
import com.demo.model.Response.ErrorType;
import com.demo.service.PersonService;
import com.demo.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = { VersionHelper.V1 + "person" })
@RestController
public class PersonController {
  private final PersonService _personService;

  @Autowired
  public PersonController(PersonService _personService) {
    this._personService = _personService;
  }

  @PostMapping(path = "add")
  public Response<Object> addPerson(@Valid @NotNull @RequestBody Person _person) {
    _personService.addPerson(_person);

    return new Response<Object>("", ErrorType.OK);
  }

  @GetMapping(path = "getAll")
  public Response<Object> getAllPerson() {
    return new Response<Object>(_personService.getAllPerson(), ErrorType.OK);
  }

  @PostMapping(path = "remove")
  public Response<Object> removePerson(@RequestParam(name = "id", required = true) UUID id) {
    _personService.deletePersonById(id);

    return new Response<Object>("", ErrorType.OK);
  }

  @PostMapping(path = "update")
  public Response<Object> updatePerson(@RequestParam(name = "id", required = true) UUID id,
      @Valid @NotNull @RequestBody Person newPerson) {
    _personService.updatePersonById(id, newPerson);

    return new Response<Object>("", ErrorType.OK);
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