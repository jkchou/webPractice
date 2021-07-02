package com.zxh.dev.service;

import com.zxh.dev.bean.User;
import com.zxh.dev.mapper.CompanyMapper;
import com.zxh.dev.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service("userService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }
}
