package com.fkq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-server", fallback = SchedualServiceHiHystric.class)
public interface HelloService {

    @GetMapping("/getUser")
    Object getUser(@RequestParam(value = "uid") String uid);


}

@Component
class SchedualServiceHiHystric implements HelloService {

    @Override
    public Object getUser(String uid) {
        return "sorry " + uid;
    }
}
