package com.java.springjdbc.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private static String INSERT_QUERY =
            """
            insert into Course values(1, 'Learn AWS', Suchith);
            """;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }


}
