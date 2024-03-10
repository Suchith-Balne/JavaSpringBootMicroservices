package com.java.springjdbc;

import com.java.springjdbc.Course.Course;
import com.java.springjdbc.Repository.CourseJpaRepository;
import com.java.springjdbc.Repository.CourseRepository;
import com.java.springjdbc.Repository.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    CourseRepository repository;

//    @Autowired
//    CourseJpaRepository repository;

    @Autowired
    CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Java", "Suchith"));
//        repository.insert(new Course(2, "C++", "Sameeri"));
//        repository.insert(new Course(3, ".NET", "Balne"));
//
//        repository.deleteById(2);
//
//        System.out.println(repository.findById(1));
//        System.out.println(repository.findById(3));

        repository.save(new Course(1, "Java", "Suchith"));
        repository.save(new Course(2, "C++", "Sameeri"));
        repository.save(new Course(3, ".NET", "Balne"));

        repository.deleteById(2l);

        System.out.println("Printing course by id");
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(3l));

        System.out.println("\nPrinting all the courses:");
        System.out.println(repository.findAll());

        System.out.println("\nPrinting course count:");
        System.out.println(repository.count());

        System.out.println("\nPrinting courses by author");
        System.out.println(repository.findByAuthor("Suchith"));
    }
}
