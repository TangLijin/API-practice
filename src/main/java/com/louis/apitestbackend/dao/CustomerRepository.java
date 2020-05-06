package com.louis.apitestbackend.dao;


import com.louis.apitestbackend.entity.Customer;
import com.louis.apitestbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where binary Id = :Id", nativeQuery = true)
    Customer findCustomerById(Long Id);

    Customer findByName(@Param("name") String name);

    @Query(value = "select name from customer", nativeQuery = true)
    List<String> findAllCustomers();
}
