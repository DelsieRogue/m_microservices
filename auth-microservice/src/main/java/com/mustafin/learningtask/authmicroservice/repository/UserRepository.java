package com.mustafin.learningtask.authmicroservice.repository;

import com.mustafin.learningtask.authmicroservice.enums.Role;
import com.mustafin.learningtask.authmicroservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
