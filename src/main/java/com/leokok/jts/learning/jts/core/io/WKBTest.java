package com.leokok.jts.learning.jts.core.io;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.locationtech.jts.io.WKTReader;

public class WKBTest {

    public static void main(String[] args) throws ParseException {

        WKTReader wktReader = new WKTReader();
        Geometry pointGeo = wktReader.read("POINT(6 10 2)");

        WKBWriter wkbWriter = new WKBWriter();
        byte[] wkb = wkbWriter.write(pointGeo);

        WKBReader wkbReader = new WKBReader();
        Geometry geometry = wkbReader.read(wkb);
        System.out.println(geometry.toText());


    }
}
