package com.ycx.lend.service.impl;

import com.ycx.lend.pojo.CarChange;
import com.ycx.lend.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ycx
 * @Date 2022/1/30 17:02
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CarServiceImplTest {
    @Autowired
    CarService carService;

    @Test
    void updateCar() {
        System.out.println(carService.updateCar("1",50));
    }

    @Test
    void addCarChange() {

    }
}