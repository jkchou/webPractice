package com.shicepku.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shicepku.entity.Scheduling;
import com.shicepku.mapper.SchedulingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class SchedulingService {
    @Autowired
    SchedulingMapper schedulingMapper;

    public IPage<Scheduling> selectPageVo(Page<Scheduling> page, QueryWrapper<Scheduling> wrapper) {
        return schedulingMapper.selectPage(page, wrapper);
    }

}
