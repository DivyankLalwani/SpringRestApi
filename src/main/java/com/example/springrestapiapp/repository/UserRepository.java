package com.example.springrestapiapp.repository;

import com.example.springrestapiapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<Object> findByEmail(String email);

    @Override
    Optional<User> findById(Long aLong);
}
