package com.java.springjdbc.Repository;

import com.java.springjdbc.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    //Custom find by methods

    List<Course> findByAuthor(String author);

}
