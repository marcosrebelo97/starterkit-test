package com.exemplo.starterkit.domain.model;

import com.exemplo.starterkit.api.dto.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private Integer age;

    @NotBlank
    private String email;

    @NotBlank
    private String city;
    private Integer cep;

    public User(UserDTO newUser) {
        name = newUser.getName();
        age = newUser.getAge();
        email = newUser.getEmail();
        city = newUser.getCity();
        cep = newUser.getCep();
    }

    //for test
    public User(String name, Integer age, String email, String city, Integer cep){
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
        this.cep = cep;
    }


}
