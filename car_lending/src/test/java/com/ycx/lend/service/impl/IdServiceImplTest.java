package com.ycx.lend.service.impl;

import com.ycx.lend.service.IdService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/24 19:33
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class IdServiceImplTest {

    @Autowired
    IdService idService;
    @Test
    void getMaxId() {
        System.out.println(idService.getMaxId("audit","audit_id"));
    }
}