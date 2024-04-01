package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getHome(){
        return "Hello welcom";
    }
    @GetMapping("/{name}")
    public String greetingToUser(@PathVariable String name){
        return "Helllo " + name;
    }
    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user) ;
    }
    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.getAllUser();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }



    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
//    }
//    @GetMapping("/GetbyId/{id}")
//    public List<User> getById(@PathVariable Long id){
//        return List.of(UserService.getById(id));
//    }
}}
