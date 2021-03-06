package com.ycx.lend.service.impl;

import com.alibaba.fastjson.JSON;
import com.ycx.lend.mapper.*;
import com.ycx.lend.pojo.Application;
import com.ycx.lend.pojo.Car;
import com.ycx.lend.pojo.CarChange;
import com.ycx.lend.pojo.GPS;
import com.ycx.lend.service.CarService;
import com.ycx.lend.utils.CalculateTwoLanLon;
import com.ycx.lend.utils.EmptyChecker;
import com.ycx.lend.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.ycx.lend.pojo.CompanyLocal.companyLatitude;
import static com.ycx.lend.pojo.CompanyLocal.companyLongitude;

/**
 * @Author ycx
 * @Date 2022/1/30 12:49
 * @Description
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;
    @Autowired
    StatusMapper statusMapper;
    @Autowired
    CarChangeMapper carChangeMapper;
    @Autowired
    CarTypeMapper carTypeMapper;
    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public int updateCar(String carId, Integer carStatus) {
        if (EmptyChecker.isAnyOneEmpty(carId, carStatus)) {
            return 0;
        }
        if (EmptyChecker.isEmpty(carMapper.selectByPrimaryKey(carId))) {
            return -3;
        }
        if (EmptyChecker.isEmpty(statusMapper.selectByPrimaryKey(carStatus))) {
            return -2;
        }
        Car car = new Car();
        car.setCarId(carId);
        car.setCarStatus(carStatus);
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public int addCarChange(String carId, Integer afterStatus, Date changeTime) {
        if (EmptyChecker.isAnyOneEmpty(carId, changeTime, afterStatus)) {
            return 0;
        }
        if (EmptyChecker.isEmpty(carMapper.selectByPrimaryKey(carId))) {
            return -2;
        }
        if (EmptyChecker.isEmpty(statusMapper.selectByPrimaryKey(afterStatus))) {
            return -2;
        }

        CarChange carChange = new CarChange();
        carChange.setChangeTime(changeTime);
        carChange.setAfterStatus(afterStatus);
        carChange.setCarId(carId);
        carChange.setBeforeStatus(carMapper.selectByPrimaryKey(carId).getCarStatus());
        if (!Objects.equals(carChange.getAfterStatus(), carChange.getBeforeStatus())) {
            return carChangeMapper.insert(carChange);
        }
        return -4;
    }

    @Override
    public int returnCar(String userId, String carId, String gps, String time) throws ParseException {
        if (EmptyChecker.isAnyOneEmpty(carId, time)) {
            return 0;
        }
        //???????????????????????????
        if (EmptyChecker.isEmpty(carMapper.selectByPrimaryKey(carId))) {
            return -2;
        }
        //???????????????????????????
        Integer carStatus = carMapper.selectByPrimaryKey(carId).getCarStatus();

        //????????????????????????????????????????????????
        if (carStatus == 2) {
            if (EmptyChecker.isEmpty(userId))
                return 0;
            Application application = applicationMapper.queryByCarAndUser(carId, userId);
            //?????????????????????,??????????????????
            if (EmptyChecker.notEmpty(application)) {
                if (application.getIfReturn() != 0) {
                    return -7;
                }
                //???????????????????????????????????????
                GPS gps1 = JSON.parseObject(gps, GPS.class);
                CalculateTwoLanLon.getDistance(companyLatitude, companyLongitude, , );

                applicationMapper.updateIfReturn(application.getApplicationId(), 1);
            } else return -6;
        }
        //??????????????????????????????
        else if (carStatus == 3) {
            Application application = applicationMapper.queryNotReturnByCarId(carId);
            if (EmptyChecker.notEmpty(application)) {
                applicationMapper.updateIfReturn(application.getApplicationId(), 1);
            } else return -4;
        }
        //?????????????????????????????????????????????
        else return -5;
        Car car = new Car();
        car.setCarId(carId);
        car.setCarStatus(1);
        addCarChange(carId, 1, ServiceUtils.StrToDate(time));
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public List<Car> queryIdleCar() {
        return carMapper.queryIdleCar();
    }

    @Override
    public String queryCarStatusName(Integer carStatus) {
        if (EmptyChecker.isEmpty(carStatus)) {
            return "0";
        }
        if (EmptyChecker.isEmpty(carTypeMapper.selectByPrimaryKey(carStatus))) {
            return "-2";
        }
        return statusMapper.queryCarStatusName(carStatus);
    }

    @Override
    public boolean ifWithinScope(String car) {

        Point carP = new Point();
        Point companyP = new Point();
        return false;
    }
}
