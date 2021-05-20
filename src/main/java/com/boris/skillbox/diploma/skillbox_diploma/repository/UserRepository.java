package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name = :name OR u.email = :email")
    List<User> findUser(@Param("name") String name, @Param("email") String email);
}
