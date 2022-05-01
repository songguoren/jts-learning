package com.leokok.jts.learning.jts.core.geom;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.geom.impl.CoordinateArraySequenceFactory;
import org.locationtech.jts.geom.impl.PackedCoordinateSequenceFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeometryTest {

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        PrecisionModel precisionModel = new PrecisionModel();
        GeometryFactory geometryFactory = new GeometryFactory(precisionModel, 0 ,PackedCoordinateSequenceFactory.DOUBLE_FACTORY);

        //通过geometryFactory 或者 Geometry子类创建 Geometry 实例
        //通过wktReader读取飞机形状wkt数据 （见图一）
        WKTReader wktReader = new WKTReader(geometryFactory);
        InputStream is = GeometryTest.class.getResourceAsStream("/wkt/plane.wkt");
        Geometry geometry = wktReader.read(new InputStreamReader(is));
        System.out.printf("WKT几何形状%s \r\n",geometry.toText());

        //Geometry常用方法示例 （见图一） 红色框代表边界
        Geometry envelopeGeo =  geometry.getEnvelope();
        System.out.printf("WKT边界 geometry.getEnvelope %s \r\n", envelopeGeo.toText());

        //创建LineString
        //方式一  通过构造函数
        List<Coordinate> coordinateList = new ArrayList<>();
        coordinateList.add(new Coordinate(0.0,1.1));
        coordinateList.add(new Coordinate(1.1,2.2));
        coordinateList.add(new Coordinate(2.2,3.3));
        coordinateList.add(new Coordinate(3.3,4.4));
        coordinateList.add(new Coordinate(4.4,5.5));
        CoordinateSequence coordinateSequence = CoordinateArraySequenceFactory.instance().create(CoordinateArrays.toCoordinateArray(coordinateList));

        LineString lineString = new LineString(coordinateSequence, geometryFactory);

        //方式二 通过 GeometryFactor构建
        LineString lineString1 = geometryFactory.createLineString(coordinateSequence);
    }
}
