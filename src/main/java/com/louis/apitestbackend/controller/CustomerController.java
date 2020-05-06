package com.louis.apitestbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.louis.apitestbackend.annotation.LoginToken;
import com.louis.apitestbackend.entity.Customer;
import com.louis.apitestbackend.service.CustomerService;
import com.louis.apitestbackend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Object login(@RequestBody Customer customer) throws UnsupportedEncodingException {
        JSONObject jsonObject=new JSONObject();
        Customer customerForBase = customerService.findCustomerByName(customer.getName());
        if(customerForBase == null){
            jsonObject.put("message", "登录失败，用户不存在");
            return jsonObject;
        }else {
            if (!customerForBase.getPassword().equals(customer.getPassword())){
                jsonObject.put("message", "登录失败，密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(customerForBase);
                jsonObject.put("token", token);
                jsonObject.put("customer", customerForBase);

                System.out.println(token);
                System.out.println(Arrays.toString(token.split("\\.")));
                System.out.println(token.split("\\.")[0]);
                System.out.println(token.split("\\.")[1]);
                System.out.println(token.split("\\.")[2]);

                System.out.println(JWT.decode(token));

//                System.out.println(JWT.decode(token.split("\\.")[0]));
//                System.out.println(JWT.decode(token.split("\\.")[1]));
//                System.out.println(JWT.decode(token.split("\\.")[2]));

                return jsonObject;
            }
        }
    }

    @LoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @LoginToken
    @GetMapping
    public List<String> getCustomers(){
        List<String> customerList = customerService.findAllCustomers();
        return customerList;
    }

}
