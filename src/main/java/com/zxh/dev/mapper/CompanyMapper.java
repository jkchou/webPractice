package com.zxh.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxh.dev.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
}
