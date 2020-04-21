package com.hp.service;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User queryUserById(Long userId) {

        //select * from tb_user where id=1
       return userMapper.selectByPrimaryKey(userId);
    }

    @Transactional//
    public void deleteById(Long userId) {

        //delete
        userMapper.deleteByPrimaryKey(userId);
    }

    public List<User> queryAll() {
        return  userMapper.selectAll();
        //select * from tb_user

    }
}
