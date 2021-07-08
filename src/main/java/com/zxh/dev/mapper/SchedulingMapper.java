package com.zxh.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxh.dev.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {
    //IPage<Scheduling> selectPageVo(IPage<?> page);
}
