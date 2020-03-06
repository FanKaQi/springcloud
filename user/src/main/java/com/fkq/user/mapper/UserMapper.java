package com.fkq.user.mapper;


import com.fkq.user.entity.User;

public interface UserMapper {

    int deleteByPrimaryKey(String uid);

    int insertUser(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 人员总数
     */
    int selectAllCount();
}