package com.exemplo.starterkit.api.exceptionhandler;

import com.exemplo.starterkit.domain.exception.DataIntegratyViolationException;
import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class UserControllerAdviceTest {

    @InjectMocks
    private UserControllerAdvice userControllerAdvice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundException_ThenReturnResponseEntity() {
        ResponseEntity<MessageExceptionHandler> response = userControllerAdvice
                .userNotFound(
                        new UserNotFoundException("Usuário não encontrado!"),
                        new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(MessageExceptionHandler.class, response.getBody().getClass());
        assertEquals("Usuário não encontrado!", response.getBody().getMessage());
        assertEquals(404, response.getBody().getStatus());
    }

    @Test
    void dataIntegrityViolationException(){
        ResponseEntity<MessageExceptionHandler> response = userControllerAdvice
                .dataIntegrityViolationNotFound(
                        new DataIntegratyViolationException("E-mail já cadastrado!"),
                        new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(MessageExceptionHandler.class, response.getBody().getClass());
        assertEquals("E-mail já cadastrado!", response.getBody().getMessage());
        assertEquals(400, response.getBody().getStatus());

    }

}