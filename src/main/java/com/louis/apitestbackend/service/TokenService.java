package com.louis.apitestbackend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.louis.apitestbackend.entity.Customer;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public String getToken(Customer customer) throws UnsupportedEncodingException {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 15 * 60 * 1000;//15分钟有效时间
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(customer.getId().toString())// 将 customer id 保存到 token 里面
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(customer.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
