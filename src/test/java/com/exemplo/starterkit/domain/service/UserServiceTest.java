package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.exception.DataIntegratyViolationException;
import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@DataJpaTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> userOptional;
    public static final String NAME     = "Marcos";
    public static final String EMAIL    = "marcos@gmail.com";
    public static final String CITY     = "Manaus";
    public static final int CEP         = 69077769;
    public static final int AGE         = 25;
    public static final long ID         = 2L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void startUser(){
        user = new User(ID, NAME, AGE, EMAIL, CITY, CEP);
        userDTO = new UserDTO(ID, NAME, AGE, EMAIL, CITY, CEP);
        userOptional = Optional.of(new User(ID, NAME, AGE, EMAIL, CITY, CEP));
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
    void whenFindById_Then_ReturnUserNotFound() {
        when(userRepository.findById(Mockito.anyLong())).thenThrow(new UserNotFoundException("Usuário não encontrado!"));

        try{
            userService.searchUserId(ID);
        } catch (Exception ex){
            assertEquals(UserNotFoundException.class, ex.getClass());
            //assertEquals("Usuário não encontrado!", ex.getMessage());
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
    void whenCreate_Then_ReturnSucess() {
        when(userRepository.save(Mockito.any())).thenReturn(user);

        User response = userService.createUser(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(AGE, response.getAge());
        assertEquals(CITY, response.getCity());
        assertEquals(CEP, response.getCep());
    }

    @Test
    void whenCreate_Then_ReturnDataIntegrityViolationException() {
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userOptional);

        try{
            userOptional.get().setId(2L);
            userService.createUser(userDTO);
        } catch (Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado!", e.getMessage());
        }
    }

    @Test
    void whenUpdate_Then_ReturnSucess() {
        when(userRepository.save(Mockito.any())).thenReturn(user);

        User response = userService.update(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(AGE, response.getAge());
        assertEquals(CITY, response.getCity());
        assertEquals(CEP, response.getCep());
    }
    @Test
    void whenUpdate_Then_ReturnDataIntegrityViolationException() {
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userOptional);

        try{
            userOptional.get().setId(2L);
            userService.update(userDTO);
        } catch (Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado!", e.getMessage());
        }
    }

    @Test
    void deleteWithSuccess(){
        when(userRepository.findById(Mockito.anyLong())).thenReturn(userOptional);
        doNothing().when(userRepository).deleteById(anyLong());

        userService.deleteUser(ID);

        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteWithObjectNotFoundException(){
        when(userRepository.findById(anyLong()))
                .thenThrow(new UserNotFoundException("Usuário não encontrado!"));
        try{
            userService.deleteUser(ID);
        } catch (Exception ex){
            assertEquals(UserNotFoundException.class, ex.getClass());
            //assertEquals("Usuário não encontrado!", ex.getMessage());
        }
    }

}