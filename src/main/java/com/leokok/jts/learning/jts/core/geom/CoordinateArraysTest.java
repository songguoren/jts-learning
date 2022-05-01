package com.leokok.jts.learning.jts.core.geom;


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateArrays;

import java.util.ArrayList;
import java.util.List;

/**
 *  Coordinate数组工具类操作示例
 */
public class CoordinateArraysTest {

    public static void main(String[] args) {

        //创建 coordinate数组
        Coordinate[] coordinates = new Coordinate[4];
        coordinates[0] = new Coordinate(0.0,0.0);
        coordinates[1] = new Coordinate(1.0,0.0);
        coordinates[2] = new Coordinate(1.0,2.0);
        coordinates[3] = new Coordinate(0.0,0.0);

        //用CoordinateArrays操作数组
        //判断几何是否闭合
        System.out.println(CoordinateArrays.isRing(coordinates));

        //反转几何
        CoordinateArrays.reverse(coordinates);

        for (int i=0; i< coordinates.length; i++){
            System.out.println("reverse: x="+coordinates[i].getX()+" y="+coordinates[i].getY());
        }

        //复制几何
        Coordinate[] coordinates1 = CoordinateArrays.copyDeep(coordinates);
        for (int i=0; i< coordinates1.length; i++){
            System.out.println("copyDeep: x="+coordinates1[i].getX()+" y="+coordinates1[i].getY());
        }

        //将list转换为 coordinate[]
        List<Coordinate> coordinateList = new ArrayList<>();
        coordinateList.add(new Coordinate(0.0,0.0));
        coordinateList.add(new Coordinate(1.0,0.0));
        coordinateList.add(new Coordinate(1.0,2.0));
        coordinateList.add(new Coordinate(0.0,0.0));

        Coordinate[] coordinates2 = CoordinateArrays.toCoordinateArray(coordinateList);
        for (int i=0; i< coordinates2.length; i++){
            System.out.println("toCoordinateArray: x="+coordinates2[i].getX()+" y="+coordinates2[i].getY());
        }

    }
}
