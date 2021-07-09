package com.shicepku.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shicepku.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {
    //IPage<Scheduling> selectPageVo(IPage<?> page);
}
