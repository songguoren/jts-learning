package com.leokok.jts.learning.jts.core.geom;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

/**
 * GeometryFactory 测试类
 */
public class GeometryFactoryTest {

    public static void main(String[] args) {
        PrecisionModel precisionModel = new PrecisionModel(PrecisionModel.FLOATING); //double类型

        GeometryFactory geometryFactory = new GeometryFactory(precisionModel, 4326); //84坐标

        //创建等相关操作方法
        Point point = geometryFactory.createPoint(new Coordinate(0.0,1.1));


    }
}
