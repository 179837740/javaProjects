package com.ycx.lend.service.impl;

import com.ycx.lend.pojo.Audit;
import com.ycx.lend.service.AuditService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/24 19:00
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AuditServiceImplTest {
    @Autowired
    AuditService auditService;

    @Test
    void allotAudit() {
        Audit audit = new Audit();
        auditService.allotAudit("2");
    }

    @Test
    void delAudit() {
    }

    @Test
    void updateAudit() {
    }

    @Test
    void queryAllAudit() {
    }

    @Test
    void startAudit() {
    }
}