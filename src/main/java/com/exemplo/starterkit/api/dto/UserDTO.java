package com.exemplo.starterkit.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String city;
    private Integer cep;

}
