package com.ycx.lend.service.impl;

import com.ycx.lend.pojo.Application;
import com.ycx.lend.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/21 21:21
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationServiceImplTest {
    @Autowired
    ApplicationService applicationService;

    @Test
    void addApplication() {
        Application application = new Application();
        application.setApplicationId("1");
        application.setUserId("1");
        application.setCarId("1");
        application.setType(0);
        int i = applicationService.addApplication(application);
        System.out.println(i);
    }

    @Test
    void delApplication() {
        System.out.println(applicationService.delApplication("1"));
    }

    @Test
    void updateApplication() {
        Application application = new Application();
        application.setApplicationId("1");
        application.setUserId("23");
        application.setCarId("1");
        application.setType(2);
        applicationService.updateApplication(application);
    }

    @Test
    void queryAllApplication() {
        for (Application application : applicationService.queryAllApplication(1,1)) {
            System.out.println(application.toString());
        }
    }

    @Test
    void queryApplicationById() {
        System.out.println(applicationService.queryApplicationById("1"));
    }

    @Test
    void queryApplicationByUser() {
        System.out.println(applicationService.queryApplicationByUser("23"));
    }
}