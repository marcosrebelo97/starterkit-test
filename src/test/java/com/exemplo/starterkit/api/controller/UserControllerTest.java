package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    private User user;
    private UserDTO userDTO;
    public static final String NAME     = "Marcos";
    public static final String EMAIL    = "marcos@gmail.com";
    public static final String CITY     = "Manaus";
    public static final int CEP         = 69077769;
    public static final int AGE         = 25;
    public static final long ID         = 2L;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void startUser(){
        user = new User(ID, NAME, AGE, EMAIL, CITY, CEP);
        userDTO = new UserDTO(ID, NAME, AGE, EMAIL, CITY, CEP);
        //userOptional = Optional.of(new User(ID, NAME, AGE, EMAIL, CITY, CEP));
    }

}