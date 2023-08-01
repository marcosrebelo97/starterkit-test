package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import com.exemplo.starterkit.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private UserRepository userRepository;

    @GetMapping
    public List<User> list (){
        return userService.list();
    }

    @PostMapping
    public ResponseEntity<User> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(user));
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
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User user){
        return new ResponseEntity<User>(userService.update(id, user), HttpStatus.OK);
    }

}
