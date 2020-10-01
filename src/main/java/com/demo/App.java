package com.demo;

import java.util.Optional;
import java.util.logging.FileHandler;
import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import org.bson.*;

import com.demo.log.LogUtils;
import com.demo.props.*;

@SpringBootApplication
public class App {

  public static void main(String[] args) throws Exception {
    // SpringApplication.run(App.class, args);

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    if (!connectionString.isEmpty()) {
      MongoClientURI mongoUri = new MongoClientURI(connectionString.get());
      MongoClient mongoClient = new MongoClient(mongoUri);

      MongoDatabase dtb = mongoClient.getDatabase("test-spring");

      MongoCollection<Document> collections = dtb.getCollection("person");

      for (Document cur : collections.find()) {
        System.out.println(cur.toJson());
      }
      mongoClient.close();
    }
  }
}