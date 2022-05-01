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

        Geometry link = wktReader.read("LINESTRING Z (116.38916015 39.57247715 21.412,116.3889396 39.57249508 21.646)");

        // 6378137.0D
        double metersPerDegree = 6.283185307179586D * 6378137.0D / 360.0D;
        System.out.println(2D / metersPerDegree);
        System.out.println(metersPerDegree);

        Geometry linb =  BufferOp.bufferOp(link, 1D / metersPerDegree, 3);
        System.out.println(linb.toText());

        List<String> a = new ArrayList<>();
        for(int i=0;i<100000000;i++){
            a.add(Math.random()+"");
        }


        Thread.sleep(TimeUnit.SECONDS.toSeconds(100000));


       Geometry linkBuffer = link.buffer(1D / metersPerDegree);
        System.out.println(linkBuffer.toText());


        System.out.println( 2.0 * Math.PI * 6378137.0D / 360.0);




    }
}
