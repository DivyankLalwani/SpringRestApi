package com.example.springrestapiapp.repository;

import com.example.springrestapiapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<Object> findByEmail(String email);

    @Override
    Optional<User> findById(Long aLong);
    @Query(value = "SELECT * from user u,Bank b where u.id=:id and b.id=:id",nativeQuery = true)
    Collection<User> findAllActiveUsersWithBank(Long id);
}
