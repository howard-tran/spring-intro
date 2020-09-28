package com.demo.AppTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.App.*;

@SpringBootTest(classes = { App.class })
class AppTest {
  @Test
  void contextLoads() {
    assertTrue(true);
  }
}
