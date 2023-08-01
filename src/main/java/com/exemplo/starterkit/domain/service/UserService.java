package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import com.exemplo.starterkit.domain.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
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

    public User update(Long id, User user){
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        user.getName();
        user.getAge();
        user.getCity();
        user.getCep();
        return userRepository.save(user);
    }
}





