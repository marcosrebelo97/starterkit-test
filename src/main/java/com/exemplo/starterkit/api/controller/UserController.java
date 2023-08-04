package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list (){
        List<UserDTO> userDTOList = userService.list();
        return ResponseEntity.ok().body(userDTOList);
        //return ResponseEntity.ok().body(Collections.singletonList(modelMapper.map(userService.list(), UserDTO.class)));
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> searchUserId (@PathVariable Long id){
        return ResponseEntity.ok().
                body(modelMapper.map(userService.searchUserId(id), UserDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody @Valid UserDTO userDTO){
        return new ResponseEntity<User>(userService.update(id, userDTO), HttpStatus.OK);
    }

}
