package com.shicepku.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shicepku.entity.Variety;
import com.shicepku.mapper.VarietyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyService {
    @Autowired
    VarietyMapper varietyMapper;

    public List<Variety> selectAll(){
        return varietyMapper.selectList(null);
    }

    public int insert(Variety variety) {
        return varietyMapper.insert(variety);
    }

    public int updateById(Variety variety) {
        return varietyMapper.updateById(variety);
    }

    public int deleteById(Integer id) {
        return varietyMapper.deleteById(id);
    }

    public int updateByName(Variety variety){
        QueryWrapper<Variety> wrapper = new QueryWrapper<>();
        wrapper.eq("name",variety.getName());
        return varietyMapper.update(variety,wrapper);
    }
}
