package com.zxh.dev.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxh.dev.entity.Scheduling;
import com.zxh.dev.mapper.SchedulingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SchedulingService {
    @Autowired
    SchedulingMapper schedulingMapper;

    public IPage<Scheduling> selectPageVo(Page<Scheduling> page, QueryWrapper<Scheduling> wrapper) {
        return schedulingMapper.selectPage(page, wrapper);
    }
}
