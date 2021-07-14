package com.shicepku.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Variety;
import com.shicepku.mapper.FarmproductionsCategoryMapper;
import com.shicepku.mapper.VarietyMapper;
import com.shicepku.service.FarmproductionsCategoryService;
import com.shicepku.service.SchedulingService;
import com.shicepku.entity.Scheduling;
import com.shicepku.mapper.SchedulingMapper;
import com.shicepku.service.VarietyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
@Rollback(value = false)
public class MapperTest {
    @Autowired
    SchedulingMapper schedulingMapper;

    @Autowired
    SchedulingService schedulingService;

    @Autowired
    FarmproductionsCategoryService farmproductionsCategoryService;
    @Test
    void testService() {
        QueryWrapper<Scheduling> wrapper = new QueryWrapper<>();
        wrapper.eq("delFlag", 1);
        Page<Scheduling> page = new Page<>(1, 5);
        IPage<Scheduling> schedulingIPage = schedulingService.selectPageVo(page, wrapper);
      /*  List<Scheduling> schedulingList = schedulingIPage.getRecords();
        for (int i = 0; i < schedulingList.size(); i++) {
            Scheduling scheduling =  schedulingList.get(i);
            System.out.println(scheduling);
        }*/
        log.debug("total -> {}", schedulingIPage.getTotal());
        log.debug("pages -> {}", schedulingIPage.getPages());
        log.debug("current -> {}", schedulingIPage.getCurrent());
    }

    @Test
    void testScheduling() {
        Scheduling scheduling = new Scheduling();
        scheduling.setName("test2222");
        scheduling.setPlantArea(10.0);
        scheduling.setForeCast(500.0);
        scheduling.setRealCast(600.0);
        scheduling.setOfficeId(1);
        scheduling.setPlotId(1);
        scheduling.setGreenHouseId(1);
        scheduling.setFarmProductionsCategoryId("大豆类");
        scheduling.setFarmProductionsVarietyId("大豆");
        scheduling.setRemarks("test");
        scheduling.setCreateBy(1);
        //scheduling.setUpdateBy(1);
        //scheduling.setCreateDate(new Timestamp(System.currentTimeMillis()));
        //scheduling.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        schedulingMapper.insert(scheduling);
        log.debug("{}", scheduling);
    }

    @Test
    void updateSche() {
        Scheduling scheduling = new Scheduling();
        scheduling.setId(20);
        scheduling.setFarmProductionsCategoryId("大豆1111");
        scheduling.setGreenHouseId(2);
        scheduling.setUpdateBy(2);
        //scheduling.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        System.out.println(scheduling.getCreateDate());
        System.out.println(scheduling.getUpdateDate());
        schedulingMapper.updateById(scheduling);
    }

    @Test
    void deleteSch() {
        schedulingMapper.deleteById(3);
    }

    @Test
    void selectSch() {
        QueryWrapper<Scheduling> schedulingQueryWrapper = new QueryWrapper<>();
        schedulingQueryWrapper.eq("name", "大豆");
        List<Scheduling> schedulingList = schedulingMapper.selectList(schedulingQueryWrapper);
        for (int i = 0; i < schedulingList.size(); i++) {
            Scheduling scheduling = schedulingList.get(i);
            System.out.println(scheduling);
        }
    }
    @Test
    void deleteById(){
        int id=1;
        int res=farmproductionsCategoryService.FarmproductionsCategoryDeleteById(id);
        System.out.println(res);
    }
@Test
void insertCategory(){
    FarmproductionsCategory farmproductionsCategory=new FarmproductionsCategory();
    farmproductionsCategory.setName("我是wzc");
    farmproductionsCategory.setParentId(3);
    farmproductionsCategory.setCreateBy("wzc");
    farmproductionsCategory.setUpdateBy("zxh");
    farmproductionsCategory.setSort(10);
    farmproductionsCategory.setStatus(1);
        int res=farmproductionsCategoryService.FarmproductionsCategoryInsert(farmproductionsCategory);
    System.out.println(res);
}
    @Test
    void selectById() {
        log.debug("{}", schedulingMapper.selectById(1));
    }


    @Autowired
    VarietyService varietyService;
    @Autowired
    VarietyMapper varietyMapper;
    @Autowired
    FarmproductionsCategoryMapper farmproductionsCategoryMapper;

    @Test
    void testVariety(){
        Variety variety = new Variety();
        variety.setDelFlag(1);
        FarmproductionsCategory farmproductionsCategory = new FarmproductionsCategory();
        farmproductionsCategory.setDelFlag(1);
        Scheduling scheduling = new Scheduling();
        scheduling.setDelFlag(1);
       QueryWrapper<FarmproductionsCategory> CategoryQueryWrapper = new QueryWrapper<>();
       QueryWrapper<Variety> varietyQueryWrapper = new QueryWrapper<>();
       QueryWrapper<Scheduling> scQueryWrapper = new QueryWrapper<>();
       CategoryQueryWrapper.eq("del_flag",0);
       varietyQueryWrapper.eq("del_flag",0);
       scQueryWrapper.eq("del_flag",0);
       varietyMapper.update(variety,varietyQueryWrapper);
       farmproductionsCategoryMapper.update(farmproductionsCategory,CategoryQueryWrapper);
       schedulingMapper.update(scheduling,scQueryWrapper);
    }

    @Test
    void testdelete(){
        //farmproductionsCategoryService.deleteByCategoryName("大豆类");
        farmproductionsCategoryService.deleteByVarietyName("大豆");

    }

}
