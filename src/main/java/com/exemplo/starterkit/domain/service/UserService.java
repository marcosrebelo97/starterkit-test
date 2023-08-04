package com.exemplo.starterkit.domain.service;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.exception.DataIntegratyViolationException;
import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    private UserRepository userRepository;

    public List<UserDTO> list() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public User createUser (UserDTO userdto){
        //User user = new User(userdto);
        findByEmail(userdto);
        return userRepository.save(modelMapper.map(userdto, User.class));
    }

    @Transactional(readOnly = true)
    public User searchUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
    }

    public void deleteUser(Long id){
        searchUserId(id);
        userRepository.deleteById(id);
    }

    public User update(Long id, UserDTO userDTO){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setCity(userDTO.getCity());
        user.setCep(userDTO.getCep());
        return userRepository.save(user);
    }

    private void findByEmail(UserDTO userDTO){
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado!");
        }
    }
}





