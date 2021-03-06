package com.ycx.lend.utils;

import com.ycx.lend.pojo.GPS;

/**
 * @Author ycx
 * @Date 2022/2/9 21:28
 * @Description
 */
public class CalculateTwoLanLon {

    private static final double EARTH_RADIUS = 6378.137;//地球半径,单位千米

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * @param lat1 第一纬度
     * @param lng1 第一经度
     * @param lat2 第二纬度
     * @param lng2 第二经度
     * @return 两坐标之间的距离
     */
    public static double getDistance(double lat1,double lng1,double lat2,double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10;
        return s;
    }
}
