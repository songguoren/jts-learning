# 案例:单位换算
## 使用场景
距离(厘米\米)转换为角度,角度转换为距离(厘米\米)
## 示例代码
```java
package com.leokok.jts.learning.jts.core.algorithm;

import org.locationtech.spatial4j.distance.DistanceUtils;

import java.math.BigDecimal;

/**
 *  单位转换
 */
public class KmDegreeTest {

    public static void main(String[] args) {
        //厘米转换为角度
        System.out.println(KmDegreeTest.cmToDegree(100));

        //角度转换为厘米
        System.out.println(degreeToCm(KmDegreeTest.cmToDegree(100)));

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

```