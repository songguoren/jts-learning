package com.leokok.jts.learning.jts.core.demo;

import org.locationtech.spatial4j.distance.DistanceUtils;

import java.math.BigDecimal;

/**
 *  单位转换
 */
public class DisDegreeTest {

    public static void main(String[] args) {
        //厘米转换为角度
        System.out.println(DisDegreeTest.cmToDegree(100));

        //角度转换为厘米
        System.out.println(degreeToCm(DisDegreeTest.cmToDegree(100)));

    }


    /**
     * 角度转换为厘米
     * @param degree
     * @return
     */
    public static double degreeToCm(double degree){

        return DistanceUtils.degrees2Dist(degree, DistanceUtils.EARTH_MEAN_RADIUS_KM) * 100000;
    }


    /**
     * 厘米转换为角度
     * @param cm
     * @return
     */
    public static double cmToDegree(double cm){
        double radius = DistanceUtils.EARTH_MEAN_RADIUS_KM; //地球平均半径

        //1KM大约等于多少度
        BigDecimal bigDecimalCm = new BigDecimal(cm);
        BigDecimal bigDecimalFM = new BigDecimal(100000);

        double bufferDegree = bigDecimalCm.divide(bigDecimalFM).doubleValue();

        double kmToDegree = DistanceUtils.dist2Degrees(bufferDegree, radius);

        return kmToDegree;
    }
}
