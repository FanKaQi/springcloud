package com.fkq.user.service;

import com.fkq.user.entity.User;

public interface UserService {

    User getUser(String uid);

    boolean deleteUser(String uid);

    int getUserCount();

    int insertUser(User user);
}
