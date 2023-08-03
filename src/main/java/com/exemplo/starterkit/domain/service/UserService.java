package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public User createUser (User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User searchUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new UserNotFoundException("Não encontrado"));
    }

    public void deleteUser(Long id){
        User user = userRepository.getUserById(id);
        if (user == null){
            throw new UserNotFoundException("Não encontrado");
        }
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Não encontrado"));
        user.getName();
        user.getAge();
        user.getCity();
        user.getCep();
        return userRepository.save(user);
    }
}





