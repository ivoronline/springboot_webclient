package com.ivoronline.springboot_webclient.services;

import com.ivoronline.springboot_webclient.entities.Person;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;
import java.util.List;

public class PersonService {

  //===============================================================
  // GET PERSON
  //===============================================================
  public static void getPerson() {

    //GET PERSON FROM SERVER
    Person person = WebClient.create("http://localhost:8085")
                             .get()
                             .uri("/GetPerson")
                             .retrieve()
                             .bodyToMono(Person.class)
                             .block(Duration.ofSeconds(3));

    //DISPLAY PERSON
    System.out.println("getPerson()");
    System.out.println(person.id + " " + person.name+ " " + person.age);

  }

  //===============================================================
  // GET PERSONS
  //===============================================================
  public static void getPersons() {

    //GET PERSON FROM SERVER
    Person[] persons = WebClient.create("http://localhost:8085")
                                .get()
                                .uri("/GetPersons")
                                .retrieve()
                                .bodyToMono(Person[].class)
                                .block(Duration.ofSeconds(3));

    //DISPLAY PERSONS
    System.out.println("getPersons()");
    for (Person person : persons) {
      System.out.println(person.id + " " + person.name+ " " + person.age);
    }

  }

}


