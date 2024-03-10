package com.java.springjdbc;

import com.java.springjdbc.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
        courseRepository.insert();
    }
}
