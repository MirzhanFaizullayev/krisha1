package org.example.service;
import org.example.entity.User;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
 @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String addUser(User user){
        if(!user.getName().isBlank() && user.getName().length() > 3){
            repository.save(user);
        }
        return "Added";
    }
    public List<User> getAllUser(){
        return repository.findAll();
    }

    public ResponseEntity<?> deleteUser(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {repository.deleteById(id);
            return ResponseEntity.ok().body("User with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    public ResponseEntity<?> updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setId(updatedUser.getId());
            repository.save(user);
            return ResponseEntity.ok().body("User with ID " + id + " has been updated.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public User getById(Long userid){
        return  repository.findById(userid).orElse(null);
    }

}
