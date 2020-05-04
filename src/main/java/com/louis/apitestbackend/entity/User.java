package com.louis.apitestbackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class User {

    @Id
    Long id;

    String name;
    Integer age;

    public User() {
    }

    public User(Long id, @NotNull String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
