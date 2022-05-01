package com.leokok.jts.learning.jts.core.algorithm;

import org.locationtech.jts.algorithm.InteriorPointLine;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

/**
 * 需找距离中心点最近的点
 */
public class InteriorPointLineTest {

    public static void main(String[] args) throws ParseException {
        WKTReader wktReader = new WKTReader();
        Geometry geometry = wktReader.read("LINESTRING(116.3309972 39.9766881,116.3309474 39.9766882)");

        System.out.println(geometry.toText());

        InteriorPointLine interiorPointLine = new InteriorPointLine(geometry);
        Coordinate coordinate = interiorPointLine.getInteriorPoint();

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(coordinate);
        System.out.println(point.toText());
    }
}
