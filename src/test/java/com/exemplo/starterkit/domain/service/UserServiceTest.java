package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class UserServiceTest {
    
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user;
    private Optional<User> userOptional;
    public static final String NAME = "Marcos";
    public static final String CITY = "Manaus";
    public static final int CEP = 69077769;
    public static final int AGE = 25;
    public static final long ID = 2L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void startUser(){
        user = new User(ID, NAME, AGE, CITY, CEP);
        userOptional = Optional.of(new User(ID, NAME, AGE, CITY, CEP));
    }
    @Test
    void whenFindById_Then_ReturnUserInstance() {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(userOptional);

        User response = userService.searchUserId(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(AGE, response.getAge());
        assertEquals(CITY, response.getCity());
        assertEquals(CEP, response.getCep());
    }

    @Test
    void whenFindById_Then_ReturnUserNotFound(){
        when(userRepository.findById(Mockito.anyLong())).thenReturn(null);

        try{
            userService.searchUserId(ID);
        } catch (Exception ex){
            assertEquals(NullPointerException.class, ex.getClass());
        }
    }
    @Test
    void whenFindAll_Then_ReturnListOfUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> response = userService.list();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(AGE, response.get(0).getAge());
        assertEquals(CITY, response.get(0).getCity());
        assertEquals(CEP, response.get(0).getCep());
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void update() {
    }
}