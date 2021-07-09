package com.shicepku.service;

import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.mapper.FarmproductionsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmproductionsCategoryService {
    @Autowired
    private FarmproductionsCategoryMapper ffcMapper;
    public List<FarmproductionsCategory> FarmproductionsCategorySelectAll(){
        return ffcMapper.selectList(null);
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
}
