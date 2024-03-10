package com.java.springjdbc.Repository;

import com.java.springjdbc.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private static String INSERT_QUERY =
            """
            insert into Course values(?, ?, ?);
            """;

    private static  String DELETE_QUERY = """
            delete from Course where id =?;
            """;

    private static  String SELECT_QUERY_BY_ID = """
            select * from Course where id =?;
            """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY_BY_ID,
                new BeanPropertyRowMapper<>(Course.class),id);

    }

}
