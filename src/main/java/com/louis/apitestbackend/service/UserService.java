package com.louis.apitestbackend.service;


import com.louis.apitestbackend.dao.UserRepository;
import com.louis.apitestbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(User user) {
        User oldUser = userRepository.findUserById(user.getId());
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        return userRepository.saveAndFlush(oldUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findUserById(id);
        if(user == null){
            System.out.println("没有这个用户");
        }else {
            userRepository.delete(user);
        }
    }
}
