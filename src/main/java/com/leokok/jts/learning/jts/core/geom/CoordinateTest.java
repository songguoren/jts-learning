package com.leokok.jts.learning.jts.core.geom;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXY;

/**
 * 经纬度实体类操作示例
 */
public class CoordinateTest {

    public static void main(String[] args) {

        //1. 通过构造函数赋值 x经度 y纬度
        Coordinate coordinateXY = new Coordinate(0.0,1.1);
        System.out.printf("经纬度为x=%s,y=%s \r\n",coordinateXY.getX(), coordinateXY.getY());

        //2. 通过构造函数赋值 x经度 y纬度 z高度
        Coordinate coordinateXYZ = new Coordinate(0.0,1.1,16.0);
        System.out.printf("经纬度为x=%s,y=%s,z=%s \r\n",coordinateXY.getX(), coordinateXY.getY(), coordinateXYZ.getZ());

        //3. 通过set参数赋值
        Coordinate coordinateXYSetP = new Coordinate();
        coordinateXYSetP.setX(0.1);
        coordinateXYSetP.setY(1.1);
        System.out.printf("经纬度为x=%s,y=%s \r\n",coordinateXYSetP.getX(), coordinateXYSetP.getY());

        //4.子类示例
        CoordinateXY coordinateXY1 = new CoordinateXY();
        coordinateXY1.setX(0.0);
        coordinateXY1.setY(1.1);
        System.out.printf("经纬度为x=%s,y=%s \r\n",coordinateXY1.getX(), coordinateXY1.getY());


    }
}
