package com.zxh.dev.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxh.dev.DTO.ResultDTO;
import com.zxh.dev.bean.User;
import com.zxh.dev.entity.Scheduling;
import com.zxh.dev.mapper.SchedulingMapper;
import com.zxh.dev.service.SchedulingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/scheduling")
public class SchedulingController {
    @Autowired
    SchedulingMapper schedulingMapper;
    @Autowired
    SchedulingService schedulingService;


    @PostMapping("/selectById")
    public Scheduling select(Integer id) {
        return schedulingMapper.selectById(id);
    }


    @PostMapping("/selectPage")
    public IPage<Scheduling> selectPage(String categoryId, int current, int size) {
        QueryWrapper<Scheduling> schedulingQueryWrapper = new QueryWrapper<>();
        schedulingQueryWrapper.eq("delFlag", 1);
        if (!categoryId.equals("全部"))
            schedulingQueryWrapper.eq("farmProductionsCategoryId", categoryId);
        Page<Scheduling> page = new Page<>(current, size);
        IPage<Scheduling> schedulingIPage = schedulingService.selectPageVo(page, schedulingQueryWrapper);
        long total = schedulingIPage.getTotal();
        return schedulingIPage;
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Scheduling scheduling) {
        return schedulingMapper.insert(scheduling);
    }

    @PostMapping("/update")
    public int update(@RequestBody Scheduling scheduling) {
        return schedulingMapper.updateById(scheduling);
    }

    @PostMapping("/delete")
    public int delete(@RequestParam("id") int id) {
        return schedulingMapper.deleteById(id);
    }

    @RequestMapping("/")
    public ResultDTO init() {
        return ResultDTO.success(Map.of("time", new Date()), "成功");
    }
}
