package com.fkq.feign.controller;

import com.fkq.feign.service.HelloService;
import com.fkq.feign.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;
    @Resource
    private RibbonService ribbonService;

    @GetMapping("getHelloUser")
    public Object getUser(String uid) {
        Object Object = helloService.getUser( uid);
        return Object;
    }

    /**
     * 假如这个客户端要提供一个getUser的方法
     */
    @GetMapping(value = "/getHelloUserMap")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Integer id) {
        Map<String,Object> jsonData = ribbonService.getUser(id);
        return jsonData;
    }

}
