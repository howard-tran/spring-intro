package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.*;

@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class AppTest {
  @Test
  void contextLoads() {
    assertTrue(true);
  }
}
