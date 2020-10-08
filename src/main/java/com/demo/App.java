package com.demo;

import java.io.Console;
import java.util.logging.LogManager;

import com.demo.LogManager.LogUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.BasicConfigurator;

@SpringBootApplication
public class App {

  public static void main(String[] args) throws Exception {
    // setup project logger
    PropertyConfigurator.configure(LogUtils.class.getResource("log4j.properties").getFile());

    Logger mongoLogger = Logger.getLogger(App.class);
    mongoLogger.setLevel(Level.ERROR);

    SpringApplication.run(App.class, args);

    LogUtils.logger.error("init project", new RuntimeException());
  }
}