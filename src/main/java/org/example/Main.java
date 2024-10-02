package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
        //User user = new User("fdsf", "123", "dsfsd@fd.cd");
        //TestGenerator.generateTest(user.getId(), 5);
    }
}