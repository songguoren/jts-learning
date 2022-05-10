package com.leokok.jts.learning.jts.core.algorithm;

import org.locationtech.jts.algorithm.distance.DistanceToPoint;
import org.locationtech.jts.algorithm.distance.PointPairDistance;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

/**
 * 点到线的最近点计算
 */
public class DistanceToPointTest {

    public static void main(String[] args) throws ParseException {

        WKTReader reader = new WKTReader();
        Geometry line2 = reader.read("LINESTRING(0 0, 10 0, 20 0)");
        Coordinate c = new Coordinate(5, 5);
        PointPairDistance ppd = new PointPairDistance();
        DistanceToPoint.computeDistance(line2, c, ppd);

        //返回垂线
        System.out.println(ppd.toString());

        System.out.println(ppd.getDistance());
        for (Coordinate cc : ppd.getCoordinates()) {
            System.out.println(cc);
        }

    }
}
