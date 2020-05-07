package com.fkq.feign.service;

import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "ribbon-server-p")
public interface RibbonService {

    @GetMapping("/getUser")
    Map<String,Object> getUser(@RequestParam(value = "id") Integer id);
}
