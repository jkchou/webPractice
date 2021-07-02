package com.zxh.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxh.dev.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int insertUser(User user);
}
