package com.java.springjdbc;

import com.java.springjdbc.Course.Course;
import com.java.springjdbc.Repository.CourseJpaRepository;
import com.java.springjdbc.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    CourseRepository repository;

    @Autowired
    CourseJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Java", "Suchith"));
        repository.insert(new Course(2, "C++", "Sameeri"));
        repository.insert(new Course(3, ".NET", "Balne"));

        repository.deleteById(2);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));
    }
}
