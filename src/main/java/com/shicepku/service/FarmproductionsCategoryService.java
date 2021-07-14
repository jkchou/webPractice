package com.shicepku.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Scheduling;
import com.shicepku.entity.Variety;
import com.shicepku.mapper.FarmproductionsCategoryMapper;
import com.shicepku.mapper.SchedulingMapper;
import com.shicepku.mapper.VarietyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmproductionsCategoryService {
    @Autowired
    private VarietyMapper varietyMapper;
    @Autowired
    private FarmproductionsCategoryMapper ffcMapper;
    public List<FarmproductionsCategory> FarmproductionsCategorySelectAll(){
        QueryWrapper<FarmproductionsCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag",1);
        return ffcMapper.selectList(wrapper);
    }
    public List<FarmproductionsCategory> FarmproductionsCategorySearch(String categoryName){
        QueryWrapper<FarmproductionsCategory>wrapper=new QueryWrapper<>();
        wrapper.like("name",categoryName);
        return ffcMapper.selectList(wrapper);
    }
    public  FarmproductionsCategory FarmproductionsCategorySelectById(int id){
        return ffcMapper.selectById(id);
    }
    public int FarmproductionsCategoryInsert(FarmproductionsCategory farmproductionsCategory){
        return ffcMapper.insert(farmproductionsCategory);
    }
    public int FarmproductionsCategoryDeleteById(int id){
        return ffcMapper.deleteById(id);
    }
    public int FarmproductionsCategoryUpdate(FarmproductionsCategory farmproductionsCategory){
        return ffcMapper.updateById(farmproductionsCategory);
    }
    public List<Variety> farmproductionsCategorySelectVariety(String category){
        QueryWrapper<Variety> wrapper = new QueryWrapper<>();
        wrapper.eq("category",category);
        wrapper.eq("del_flag",1);
        return varietyMapper.selectList(wrapper);
    }

    //删除Category
    public int deleteByCategoryName(String categoryName){
        return ffcMapper.deleteByName(categoryName);
    }

    //删除Variety

    public  int deleteByVarietyName(String name){
        return varietyMapper.deleteByName(name);
    }
}
