package com.fkq.user.service;

import com.fkq.user.entity.User;
import com.fkq.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public boolean deleteUser(String uid) {
        int result = userMapper.deleteByPrimaryKey(uid);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getUserCount() {
        int count = userMapper.selectAllCount();
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)//(事务控制)
    public int insertUser(User user) {
        int count = userMapper.insertUser(user);
        return count;
    }
}
