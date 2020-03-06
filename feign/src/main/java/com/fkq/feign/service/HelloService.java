package com.fkq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-server")
public interface HelloService {

    @GetMapping("/getUser")
    Object getUser(@RequestParam(value = "uid")String uid);
}
