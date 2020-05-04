package com.louis.apitestbackend.controller;

import com.louis.apitestbackend.dao.UserRepository;
import com.louis.apitestbackend.entity.User;
import com.louis.apitestbackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "用户相关接口", tags = "用户类")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ApiOperation(value = "获取全部用户", notes = "查看全部用户的信息",httpMethod = "GET")
    public List<User> getUsers(){
        return userRepository.findAllUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取某一个用户", notes = "查看某一个用户的信息",httpMethod = "GET")
    public User getUser(@ApiParam(name = "id", value = "ID", required = true) @PathVariable Long id){
        return userRepository.findUserById(id);
    }

    @PostMapping(produces = {"application/json"})
    @ApiOperation(value = "新建一个用户", notes = "提交某一个新用户的信息",httpMethod = "POST")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping
    @ApiOperation(value = "根据id，修改一个用户", notes = "更新某一个用户的信息",httpMethod = "PUT")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id，删除一个用户", notes = "删除某一个用户的信息",httpMethod = "DELETE")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
