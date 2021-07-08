package com.zxh.dev.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxh.dev.bean.User;
import com.zxh.dev.entity.Company;
import com.zxh.dev.entity.Scheduling;
import com.zxh.dev.mapper.CompanyMapper;
import com.zxh.dev.mapper.SchedulingMapper;
import com.zxh.dev.mapper.UserMapper;
import com.zxh.dev.service.SchedulingService;
import com.zxh.dev.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
@Rollback(value = false)
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    SchedulingMapper schedulingMapper;

    @Autowired
    SchedulingService schedulingService;

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
        scheduling.setName("test");
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
    }

    @Test
    void updateSche() {
        Scheduling scheduling = new Scheduling();
        scheduling.setId(1);
        scheduling.setFarmProductionsCategoryId("大豆");
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
    void testUser() {
        User user = new User();
        user.setName("asd");
        user.setAge(90);
        int i = userMapper.insert(user);
        log.debug("{}", user);
        log.debug("{}", i);
    }

    @Test
    void testCompany() {
        Company company = new Company();
        company.setComName("test");
        System.out.println(companyMapper);
        int i = companyMapper.insert(company);
//        System.out.println(i);
        log.debug("{}", i);
    }

    @Value("${img.root}")
    private String imgRoot;

    Company company = new Company();

    @Test
    void insert() throws IOException {
        company.setComName("香坊区高新科技有限公司");
        company.setContactor("zhuhaoxing");
        company.setContactTel("13154656781");
        company.setSinaWeibo("xiangfang.sina.com");
        company.setTencentWeibo("xiangfang.weibo");
        company.setEmail("18654564@me.com");
        company.setUrl("www.xiangfang.com");
        company.setCreator("1001");
        String picture = imgRoot + "1.jpg";
        String comHonor = imgRoot + "2.jpg";
        company.setComPicture(picture);
        company.setComHonor(comHonor);
        company.setRemark("这个公司不得了");

        companyMapper.insert(company);
        //System.out.println(company);
    }


    @Test
    void setImgRoot() {
        String imgPath = "1.jpg";
        log.debug("{}", imgRoot + imgPath);
    }

}
