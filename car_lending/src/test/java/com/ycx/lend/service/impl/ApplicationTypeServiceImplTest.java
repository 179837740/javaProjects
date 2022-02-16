package com.ycx.lend.service.impl;

import com.ycx.lend.pojo.ApplicationType;
import com.ycx.lend.service.ApplicationService;
import com.ycx.lend.service.ApplicationTypeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/23 18:54
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTypeServiceImplTest {

    @Autowired
    ApplicationTypeService applicationTypeService;

    @Test
    void queryAllApplicationType() {
    }

    @Test
    void queryApplicationTypeByNum() {
        System.out.println(applicationTypeService.queryApplicationTypeByNum(1));
    }
}