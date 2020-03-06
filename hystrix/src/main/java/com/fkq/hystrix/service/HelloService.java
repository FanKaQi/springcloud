package com.fkq.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HelloService {


    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        if (name.equals("0")){
            return "ok";
        }else {
            return "no";
        }
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
