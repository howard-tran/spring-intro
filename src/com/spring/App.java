package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;

import com.model.sup;

@SpringBootApplication
public class App {

  public static void main(String[] args) {

    sup arr = new sup();
    arr.out("hello world");
    arr.out("hello world");
    arr.out("hello world");
    arr.out("hello world");
    // SpringApplication.run(App.class, args);
  }

}