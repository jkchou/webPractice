package com.shicepku.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Wrapper;
import java.util.List;

@Mapper
public interface FarmproductionsCategoryMapper extends BaseMapper<FarmproductionsCategory> {
//    List<FarmproductionsCategory>
}
