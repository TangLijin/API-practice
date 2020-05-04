package com.louis.apitestbackend.dao;

import com.louis.apitestbackend.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "select * from user where binary id = :id", nativeQuery = true)
    User findUserById(Long id);

}
