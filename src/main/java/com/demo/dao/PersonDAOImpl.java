package com.demo.dao;

import java.util.*;

import com.demo.model.Person;
import com.demo.props.PropUtils;
import com.google.gson.Gson;

import com.mongodb.client.*;

import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository("Person")
public class PersonDAOImpl implements PersonDAO {

  /**
   * @param _person person object
   * @return void
   */
  @Override
  public void insert(Person _person) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    _person.setId(UUID.randomUUID());
    String jsonObj = new Gson().toJson(_person);
    db.getCollection("person").insertOne(new Document().parse(jsonObj));

    client.close();
  }

  /**
   * @param id      person id
   * @param _person person object
   * @return void
   */
  @Override
  public void update(UUID id, Person _person) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    _person.setId(id);
    String jsonObj = new Gson().toJson(_person);
    db.getCollection("person").updateOne(new Document("id", id.toString()), new Document().parse(jsonObj));

    client.close();
  }

  /**
   * @param id id of person
   * @return void
   */
  public void delete(UUID id) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    Document filter = new Document("id", id.toString());

    db.getCollection("person").deleteOne(filter);
    client.close();
  }

  /**
   * @param listPerson list of person
   * @return void
   */
  @Override
  public void insertMany(List<Person> listPerson) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    MongoCollection<Document> collection = db.getCollection("person");

    List<Document> insertList = new ArrayList<>();

    for (Person p : listPerson) {
      p.setId(UUID.randomUUID());
      String jsonObj = new Gson().toJson(p);

      insertList.add(new Document().parse(jsonObj));
    }

    collection.insertMany(insertList);
    client.close();
  }

  /**
   * @return list of all person in person collection
   */
  public List<Person> getAllPerson() throws Exception {

    List<Person> res = new ArrayList<>();

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    FindIterable<Document> cursor = db.getCollection("person").find();

    for (Document doc : cursor) {
      res.add(new Gson().fromJson(doc.toJson(), Person.class));
    }

    client.close();
    return res;
  }

  /**
   * @param listId     list of person id
   * @param listPerson list of person object
   */
  @Override
  public void updateMany(List<UUID> listId, List<Person> listPerson) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    for (int i = 0; i < listId.size(); i++) {
      Document filter = new Document("id", listId.get(i).toString());

      String jsonObj = new Gson().toJson(listPerson.get(i));
      db.getCollection("person").updateOne(filter, new Document().parse(jsonObj));
    }
    client.close();
  }

  /**
   * @param listId list of person id
   */
  @Override
  public void deleteMany(List<UUID> listId) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    for (int i = 0; i < listId.size(); i++) {
      Document filter = new Document("id", listId.get(i).toString());

      db.getCollection("person").deleteOne(filter);
    }
    client.close();
  }

  /**
   * @param id person id
   * @return Optional<Person>, empty if not found
   */
  public Optional<Person> getPersonById(UUID id) throws Exception {

    Optional<String> connectionString = PropUtils.getProperty("connectionString");

    MongoClient client = MongoClients.create(connectionString.get());
    MongoDatabase db = client.getDatabase(PropUtils.getProperty("database").get());

    Document filter = new Document("id", id.toString());

    FindIterable<Document> doc = db.getCollection("person").find(filter);

    Person res = new Gson().fromJson(doc.first().toJson(), Person.class);

    client.close();
    return Optional.of(res);
  }
}