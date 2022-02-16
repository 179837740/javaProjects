package com.ycx.lend;

import com.ycx.lend.exception.ParamException;
import com.ycx.lend.mapper.*;
import com.ycx.lend.pojo.Application;
import com.ycx.lend.pojo.ApplicationType;
import com.ycx.lend.pojo.Audit;
import com.ycx.lend.pojo.Car;
import com.ycx.lend.service.ApplicationService;
import com.ycx.lend.service.AuditService;
import com.ycx.lend.service.CarService;
import com.ycx.lend.service.IdService;
import com.ycx.lend.utils.ServiceUtils;
import com.ycx.lend.utils.WebCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ApplicationTypeMapper applicationTypeMapper;
    @Autowired
    AuditorMapper auditorMapper;
    @Autowired
    CarMapper carMapper;
    @Autowired
    IdService idService;
    @Autowired
    AuditService auditService;
    @Autowired
    IdMapper idMapper;
    @Autowired
    AuditMapper auditMapper;
    @Autowired
    CarService carService;

    @Test
    public void findAll() {
        for (Application application : applicationService.queryAllApplication(1, 1)) {
            System.out.println(application);
        }
    }

    @Test
    public void add() {
        Application application = new Application();
        application.setApplicationId("1");
        application.setUserId("1");
        application.setCarId("1");
        application.setType(0);
        int i = applicationService.addApplication(application);
        System.out.println(i);
    }

    @Test
    public void test() throws ParamException, ParseException {
        System.out.println(carMapper.selectByPrimaryKey(3).getCarStatus());
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    @Test
    public void getDistance() {
        double EARTH_RADIUS = 6378.137;//地球半径,单位千米
        double lat1 = 118.871904, lng1 = 28.991337,
        lat2 = 118.875125, lng2 = 28.991231;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10;
        System.out.println(5/3);
        System.out.println(s);

    }
}



