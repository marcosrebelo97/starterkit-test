package com.exemplo.starterkit.domain.model;

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
    private String city;
    private Integer cep;

    public User(String name, Integer age, String city, Integer cep){
        this.name = name;
        this.age = age;
        this.city = city;
        this.cep = cep;
    }
}
