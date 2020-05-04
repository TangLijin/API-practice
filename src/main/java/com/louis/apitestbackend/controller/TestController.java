package com.louis.apitestbackend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "打招呼", tags = "测试类")
public class TestController {
    @GetMapping
    @ApiOperation(value = "say hello", notes = "hello",httpMethod = "GET")
    public String hello() {
        return "Hello Louis";
    }
}
