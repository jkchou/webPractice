package com.zxh.dev.service;

import com.zxh.dev.bean.User;

import java.util.List;

public interface Service {
    User selectById();

    List<Object> selectByLimit(Object object);

    int insert(Object object);

    int update(Object object);

    boolean deleteById(Integer id);
}
