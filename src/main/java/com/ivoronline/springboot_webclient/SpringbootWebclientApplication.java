package com.ivoronline.springboot_webclient;

import com.ivoronline.springboot_webclient.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebclientApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootWebclientApplication.class, args);
    PersonService.getPerson();
    PersonService.getPersons();
  }

}

