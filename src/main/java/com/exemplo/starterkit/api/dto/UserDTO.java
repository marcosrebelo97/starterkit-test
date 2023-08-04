package com.exemplo.starterkit.api.dto;

import com.exemplo.starterkit.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String city;
    private Integer cep;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        age = user.getAge();
        email = user.getEmail();
        city = user.getCity();
        cep = user.getCep();
    }

}
