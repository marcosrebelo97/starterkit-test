package com.exemplo.starterkit.domain.repository;

import com.exemplo.starterkit.domain.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Tests for User Repository")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void testSaveUser(){
        //Given
        User user = new User("Marcos", 25, "Manaus", 69077769);

        //When
        User savedUser = userRepository.save(user);

        // Then
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo(user.getName());
        assertThat(foundUser.getAge()).isEqualTo(user.getAge());
        assertThat(foundUser.getCity()).isEqualTo(user.getCity());
        assertThat(foundUser.getCep()).isEqualTo(user.getCep());
    }





}