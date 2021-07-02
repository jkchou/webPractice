package com.zxh.dev.mybatis;


import com.zxh.dev.bean.User;
import com.zxh.dev.entity.Company;
import com.zxh.dev.mapper.CompanyMapper;
import com.zxh.dev.mapper.UserMapper;
import com.zxh.dev.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

@Slf4j
@Transactional
@SpringBootTest
@Rollback(value = false)
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CompanyMapper companyMapper;

    @Test
    void testUser() {
        User user = new User();
        user.setName("asd");
        user.setAge(90);
        int i = userMapper.insertUser(user);
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
        String picture = "/static/3.jpg";
        Byte[] picByte = PictureUtils.getPicByte(picture);
        String comHonor = "/static/2.jpg";
        Byte[] picPride = PictureUtils.getPicByte(comHonor);
        company.setComPicture(picByte);
        company.setComHonor(picPride);
        company.setRemark("这个公司不得了");

        companyMapper.insert(company);
        //System.out.println(company);
    }
}
