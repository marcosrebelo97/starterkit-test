package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.domain.User;
import com.exemplo.starterkit.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setName("Marcos");
        user.setAge(25);
        user.setCity("Manaus");
        user.setCep(69077769);

        List<User> users = new ArrayList<>();
        users.add(user);

        userController.create(user);
    }
}
