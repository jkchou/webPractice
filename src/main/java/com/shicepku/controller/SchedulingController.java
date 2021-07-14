package com.shicepku.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shicepku.DTO.ResultDTO;
import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Scheduling;
import com.shicepku.mapper.SchedulingMapper;
import com.shicepku.service.FarmproductionsCategoryService;
import com.shicepku.service.SchedulingService;
import com.shicepku.utils.ImageUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
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
    @Autowired
    FarmproductionsCategoryService farmproductionsCategoryService;
    @Autowired
    ImageUpload imageUpload;

    @PostMapping("/image")
    public String image(MultipartFile file){
        return imageUpload.saveImage(file);
    }

    @PostMapping("/selectById")
    public Scheduling selectById(Integer id) {
        return schedulingMapper.selectById(id);
    }


    @PostMapping("/selectPage")
    public IPage<Scheduling> selectPage(String categoryId, int current, int size) {
        QueryWrapper<Scheduling> schedulingQueryWrapper = new QueryWrapper<>();
        schedulingQueryWrapper.eq("del_flag", 1);
        if (!categoryId.equals("全部"))
            schedulingQueryWrapper.eq("farm_productions_category_id", categoryId);
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


    @RequestMapping("/getCategory")
    public List<String> getCategory() {
        List<FarmproductionsCategory> farmproductionsCategoryList =  farmproductionsCategoryService.FarmproductionsCategorySelectAll();
        List<String> categorys = new LinkedList<>();
        for (int i = 0; i < farmproductionsCategoryList.size(); i++) {
            FarmproductionsCategory farmproductionsCategory =  farmproductionsCategoryList.get(i);
            categorys.add(farmproductionsCategory.getName());
        }
        return categorys;
    }

    @RequestMapping("/")
    public ResultDTO init() {
        return ResultDTO.success(Map.of("time", new Date()), "成功");
    }
}
