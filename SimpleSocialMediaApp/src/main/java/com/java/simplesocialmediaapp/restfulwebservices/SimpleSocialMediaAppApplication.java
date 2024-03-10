package com.java.simplesocialmediaapp.restfulwebservices;

import com.java.simplesocialmediaapp.restfulwebservices.user.UserDaoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleSocialMediaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSocialMediaAppApplication.class, args);
    }

}
