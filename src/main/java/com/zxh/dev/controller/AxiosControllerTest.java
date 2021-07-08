package com.zxh.dev.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxh.dev.DTO.ResultDTO;
import com.zxh.dev.bean.User;
import com.zxh.dev.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class AxiosControllerTest {
    /*@Autowired
    UserMapper userMapper;

    @PostMapping("/select")
    public User select(Integer id){
        return userMapper.selectById(id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody User user){
        return userMapper.insert(user);
    }
    @PostMapping("/update")
    public int update(@RequestBody User user){
        return userMapper.updateById(user);
    }

    @PostMapping("/delete")
    public int delete(@RequestParam("id") int id){
        return userMapper.deleteById(id);
    }

    @RequestMapping("/")
    public ResultDTO init() {
        return ResultDTO.success(Map.of("time", new Date()), "成功");
    }*/
}
