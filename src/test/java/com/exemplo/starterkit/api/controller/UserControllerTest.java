package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

    @Test
    void whenFindById_ReturnSucess(){
        when(userService.searchUserId(Mockito.anyLong())).thenReturn(user);
        when(modelMapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.searchUserId(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(AGE, response.getBody().getAge());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(CITY, response.getBody().getCity());
        assertEquals(CEP, response.getBody().getCep());
    }

    @Test
    void whenFindAll_Then_ReturnListOfUserDTO(){
        when(userService.list()).thenReturn(List.of(user));

        when(modelMapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = userController.list();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(UserDTO.class, response.getBody().get(0).getClass());

        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NAME, response.getBody().get(0).getName());
        assertEquals(AGE, response.getBody().get(0).getAge());
        assertEquals(EMAIL, response.getBody().get(0).getEmail());
        assertEquals(CITY, response.getBody().get(0).getCity());
        assertEquals(CEP, response.getBody().get(0).getCep());
    }

}