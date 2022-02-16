package com.ycx.lend.service.impl;

import com.ycx.lend.mapper.ApplicationMapper;
import com.ycx.lend.mapper.AuditEndMapper;
import com.ycx.lend.mapper.AuditMapper;
import com.ycx.lend.mapper.AuditorMapper;
import com.ycx.lend.service.AuditEndService;
import com.ycx.lend.service.IdService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/29 15:27
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AuditEndServiceImplTest {

    @Autowired
    AuditEndService auditEndService;
    @Autowired
    AuditEndMapper auditEndMapper;
    @Autowired
    AuditMapper auditMapper;
    @Autowired
    AuditorMapper auditorMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    IdService idService;

    @Test
    void allotOneAuditEnd() {
        int i = auditEndService.allotOneAuditEnd("6");
        System.out.println(i);
    }

    @Test
    void delAuditEnd() {
    }

    @Test
    void updateAuditEnd() {
    }

    @Test
    void queryAllAuditEnd() {
    }

    @Test
    void queryAuditEndById() {
    }

    @Test
    void queryAuditEndByAuditor() {

    }
}