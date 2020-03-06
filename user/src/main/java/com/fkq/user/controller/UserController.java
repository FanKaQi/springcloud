package com.fkq.user.controller;

import com.fkq.user.entity.JsonData;
import com.fkq.user.entity.User;
import com.fkq.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUser(@RequestParam("uid") String id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new JsonData(-1, null, "没有查到用户信息!");
        } else {
            return new JsonData(0, user, "OK");
        }
    }

    @DeleteMapping("/deleteUser/{uid}")
    public Object deleteUser(@PathVariable("uid") String uid) {
        boolean result = userService.deleteUser(uid);
        if (result == true) {
            return new JsonData(0, null, "删除成功");
        } else {
            return new JsonData(0, null, "OK");
        }
    }

    @PostMapping("/register")
    public Object register(@RequestParam("name") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUid(UUID.randomUUID().toString());
        user.setAddress("陕西西安");
        user.setAge(18);
        user.setName(username);
        user.setPassword(password);
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        int result = userService.insertUser(user);
        if (result > 0) {
            return new JsonData(0, user, "新增成功");
        } else {
            return new JsonData(0, null, "新增失败");
        }
    }
}
