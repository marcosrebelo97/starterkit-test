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

    public List<User> create(User user){
        userRepository.save(user);
        return list();
    }

    @Transactional(readOnly = true)
    public User searchUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public void deleteUser(Long id){
        User user = userRepository.getUserById(id);
        if (user == null){
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}





