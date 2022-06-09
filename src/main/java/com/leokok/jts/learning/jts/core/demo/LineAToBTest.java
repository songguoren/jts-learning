package com.leokok.jts.learning.jts.core.demo;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.linearref.LengthLocationMap;
import org.locationtech.jts.linearref.LinearLocation;
import org.locationtech.jts.linearref.LocationIndexedLine;

/**
 * 计算线上面距离点起点一定距离的交点坐标
 */
public class LineAToBTest {

    public static void main(String[] args) throws ParseException {

        WKTReader wktReader = new WKTReader();
        Geometry l = wktReader.read("LINESTRING (240 230, 334 224, 380 240, 470 250, 470 210, 556 185, 620 220, 620 270, 620 350, 690 360, 760 350, 812 315, 817 305, 870 240, 881 237, 920 230)");

        System.out.println(l.getLength());

        LocationIndexedLine locationIndexedLine = new LocationIndexedLine(l);
        LinearLocation linearLocation = LengthLocationMap.getLocation(l, 100);
        Coordinate result = locationIndexedLine.extractPoint(linearLocation);
        System.out.println(result.toString());

    }
}
