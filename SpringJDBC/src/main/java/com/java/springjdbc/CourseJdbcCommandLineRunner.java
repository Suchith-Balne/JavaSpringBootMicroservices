package com.java.springjdbc;

import com.java.springjdbc.Course.Course;
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
        courseRepository.insert(new Course(1, "Java", "Suchith"));
        courseRepository.insert(new Course(2, "C++", "Sameeri"));
        courseRepository.insert(new Course(3, ".NET", "Balne"));

        courseRepository.deleteById(2);

        System.out.println(courseRepository.findById(1));
    }
}
