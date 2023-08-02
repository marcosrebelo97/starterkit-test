package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> list (){
        return userService.list();
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchUserId (@PathVariable Long id){
        return new ResponseEntity<User>(userService.searchUserId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody @Valid User user){
        return new ResponseEntity<User>(userService.update(id, user), HttpStatus.OK);
    }

}
