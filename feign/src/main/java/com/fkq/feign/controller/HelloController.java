package com.fkq.feign.controller;

import com.fkq.feign.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("getHelloUser")
    public Object getUser(String uid) {
        Object Object = helloService.getUser( uid);
        return Object;
    }
}
