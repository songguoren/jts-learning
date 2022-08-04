package com.leokok.jts.learning.jts.core.triangulate;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.triangulate.DelaunayTriangulationBuilder;

/**
 * 根据点构造多边形
 */
public class DelaunayTriangulationBuilderTest {

    public static void main(String[] args) throws ParseException {
        GeometryFactory geometryFactory = new GeometryFactory();
        WKTReader reader = new WKTReader(geometryFactory);
        MultiPoint multiPoint = (MultiPoint)reader.read("MULTIPOINT((102.68194556236264 24.99925377243376), (102.6823854446411 24.998563388737196), (102.68381237983702 24.998495322528882), (102.68659114837645 25.000615081033544), (102.68534660339354 25.00118877085464))");

        DelaunayTriangulationBuilder builder = new DelaunayTriangulationBuilder();
        builder.setSites(multiPoint);

        // 实际为GeometryCollection（组成的geometry紧密相连）
        Geometry geometry = builder.getTriangles(geometryFactory);
        System.out.println(geometry.toText());

       // 以0的距离进行缓冲（因为各多边形两两共边），生成一个多边形
       // 此时则将点云构造成了多边形
        Geometry buffer = geometry.buffer(0);
        System.out.println(buffer.toText());

    }
}
