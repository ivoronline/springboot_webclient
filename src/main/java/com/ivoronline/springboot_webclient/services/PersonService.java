package com.ivoronline.springboot_webclient.services;

import com.ivoronline.springboot_webclient.entities.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Component
public class PersonService {

  //===============================================================
  // GET TEXT
  //===============================================================
  public void getText() {

    //GET PERSON FROM SERVER
    String string = WebClient.create("http://localhost:8080")
                             .get()
                             .uri("/GetText?name=John")
                             .retrieve()
                             .bodyToMono(String.class)
                             .block(Duration.ofSeconds(3));

    //DISPLAY PERSON
    System.out.println("\n getText()");
    System.out.println(string);

  }

  //===============================================================
  // GET PERSON
  //===============================================================
  public void getPerson() {

    //GET PERSON FROM SERVER
    Person person = WebClient.create("http://localhost:8080")
                             .get()
                             .uri("/GetPerson")
                             .retrieve()
                             .bodyToMono(Person.class)
                             .block(Duration.ofSeconds(3));

    //DISPLAY PERSON
    System.out.println("\n getPerson()");
    System.out.println(person.id + " " + person.name+ " " + person.age);

  }

  //===============================================================
  // GET PERSONS
  //===============================================================
  public void getPersons() {

    //GET PERSON FROM SERVER
    Person[] persons = WebClient.create("http://localhost:8080")
                                .get()
                                .uri("/GetPersons")
                                .retrieve()
                                .bodyToMono(Person[].class)
                                .block(Duration.ofSeconds(3));

    //DISPLAY PERSONS
    System.out.println("\n getPersons()");
    for (Person person : persons) {
      System.out.println(person.id + " " + person.name+ " " + person.age);
    }

  }

}


