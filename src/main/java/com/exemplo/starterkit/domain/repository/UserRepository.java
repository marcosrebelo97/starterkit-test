package com.exemplo.starterkit.domain.repository;

import com.exemplo.starterkit.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User getUserById(Long id);

    Optional<User> findByEmail(String email);

}
