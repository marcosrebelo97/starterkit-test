package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
