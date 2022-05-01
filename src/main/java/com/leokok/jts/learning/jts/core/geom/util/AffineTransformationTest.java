package com.leokok.jts.learning.jts.core.geom.util;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.util.AffineTransformation;
import org.locationtech.jts.geom.util.AffineTransformationFactory;

/**
 *  仿射变换测试类
 */
public class AffineTransformationTest {

    public static void main(String[] args) {

        //通过 factory创建 AffineTransformation
        // 参考坐标C1(0,0)作为坐标零点; 移动到参考坐标(3,3)作为坐标原点记作参考系C2
        AffineTransformation affineTransformation = AffineTransformationFactory.createFromControlVectors(new Coordinate(0.0,0.0), new Coordinate(3.0,3.0));


        GeometryFactory geometryFactory = new GeometryFactory();
        //1. 平移
        //1.1 将A point(1,1) 移动到新坐标系上面
        Point pointA = geometryFactory.createPoint(new Coordinate(1.0,1.0));
        System.out.printf("坐标A,WKT:%s \r\n",pointA.toText());
        Geometry geometryA = affineTransformation.transform(pointA);
        System.out.printf("坐标A移动后的A',WKT:%s \r\n", geometryA.toText());

        //1.2 平移线 (0,1) (1,2)
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = new Coordinate(0,1);
        coordinates[1] = new Coordinate(1,2);
        LineString lineStringA = geometryFactory.createLineString(coordinates);
        System.out.printf("线A,WKT:%s \r\n",lineStringA.toText());
        Geometry lineStringATrans = affineTransformation.transform(lineStringA);
        System.out.printf("线A移动后的线A',WKT:%s \r\n", lineStringATrans.toText());

        //1.3 平移 pologn
        Coordinate[] coordinates3 = new Coordinate[4];
        coordinates3[0] = new Coordinate(0,1);
        coordinates3[1] = new Coordinate(1,2);
        coordinates3[2] = new Coordinate(1,3);
        coordinates3[3] = new Coordinate(0,1);
        Polygon polygonA = geometryFactory.createPolygon(coordinates3);
        System.out.printf("框A,WKT:%s \r\n",polygonA.toText());
        Geometry polygonATrans = affineTransformation.transform(polygonA);
        System.out.printf("框A移动后的框A',WKT:%s \r\n", polygonATrans.toText());


        //定义线参考
        AffineTransformation affineTransformationBaseLine = AffineTransformationFactory.createFromBaseLines(new Coordinate(0.0,1.0), new Coordinate(3.0,4.0),new Coordinate(6,0),new Coordinate(5,3));

        CoordinateList coordinateList = new CoordinateList();
        coordinateList.add(new Coordinate(2,2));
        coordinateList.add(new Coordinate(2,1));
        coordinateList.add(new Coordinate(3,1));
        coordinateList.add(new Coordinate(3,2));
        coordinateList.add(new Coordinate(2,2));

        Polygon polygon = geometryFactory.createPolygon(coordinateList.toCoordinateArray());
        System.out.printf("框A,WKT:%s \r\n",polygon.toText());
        Geometry polygonTrans = affineTransformationBaseLine.transform(polygon);
        System.out.printf("框A移动后的框A',WKT:%s \r\n", polygonTrans.toText());


        Coordinate[] coordinates1 = new Coordinate[2];
        coordinates1[0] = new Coordinate(0.0,1.0);
        coordinates1[1] = new Coordinate(2.0,3.0);
        LineString lineString = geometryFactory.createLineString(coordinates1);

        System.out.println(lineString.toText());

        Geometry geometry = affineTransformationBaseLine.transform(lineString);

        System.out.println(geometry.toText());



    }
}
