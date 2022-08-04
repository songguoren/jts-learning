package com.leokok.jts.learning;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.operation.buffer.BufferOp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BufferTest {

    public static void main(String[] args) throws ParseException, InterruptedException {
        GeometryFactory geometryFactory = new GeometryFactory();
        WKTReader wktReader = new WKTReader(geometryFactory);

        Geometry link = wktReader.read("LINESTRING(116.38916015 39.57247715,116.3889396 39.57249508)");

        // 6378137.0D
        double metersPerDegree = 6.283185307179586D * 6378137.0D / 360.0D;
        System.out.println(2D / metersPerDegree);
        System.out.println(metersPerDegree);

        Geometry linb =  BufferOp.bufferOp(link, 1D / metersPerDegree, 1);
        System.out.println(linb.toText());

        Geometry link2 = wktReader.read("LINESTRING (116.388974 39.572468 34, 116.388996 39.572488 56, 116.389 39.572492 23, 116.389011 39.572504 13)");

        Geometry in = linb.intersection(link2);
        System.out.println(in.toText());




    }
}
