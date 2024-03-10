package com.java.simplesocialmediaapp.restfulwebservices.user;

import com.java.simplesocialmediaapp.restfulwebservices.repository.UserJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/jpa/users")
    public List<User> retreiveAllUsers(){
        return userJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
        Optional<User> user = userJpaRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        EntityModel<User> entityModel = EntityModel.of(user.get()); // Enity model to add links
        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).retreiveAllUsers()); //Build the link
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User savedUser = userJpaRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userJpaRepository.deleteById(id);
    }
}
