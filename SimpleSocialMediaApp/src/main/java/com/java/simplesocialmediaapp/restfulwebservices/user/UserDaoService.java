package com.java.simplesocialmediaapp.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private static int userCount=0;

    static{
        users.add(new User(++userCount,"Suchith", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Sameeri", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"Balne", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        users.removeIf(user -> user.getId().equals(id));
    }
}
