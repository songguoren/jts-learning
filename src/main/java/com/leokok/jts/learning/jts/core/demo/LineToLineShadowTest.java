package com.leokok.jts.learning.jts.core.demo;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.linearref.LinearLocation;
import org.locationtech.jts.linearref.LocationIndexedLine;

/**
 * 线到线投影
 */
public class LineToLineShadowTest {

    /**
     * 方式:
     * 1.1 通过 LocationIndexedLine来实现,
     * 1.2 locationIndexedLine.indexOf
     *       l1上面的第一个形状点p1，投影到l2上面得到p11；
     *       l1上面生的最后一个形状点Pn，投影到l2上面得到Pnn；
     * 1.3 通过locationIndexedLine.extractLine(p2位置,Pn位置) 来截取生成投影对象 L11
     * @return
     */
    public static void method1() throws ParseException {

        WKTReader wktReader = new WKTReader();

        //创建基准线L1
        Geometry l1 = wktReader.read("LINESTRING (115.805946 39.2572185, 115.8059521 39.2572183, 115.8059566 39.2572192, 115.805962 39.2572191, 115.8059678 39.2572183, 115.8059764 39.2572184, 115.8059806 39.2572192, 115.8059855 39.2572193, 115.8059884 39.2572182, 115.8059937 39.2572182, 115.8060005 39.2572196, 115.8060042 39.2572216, 115.8060075 39.2572206, 115.8060137 39.2572209)");
        LocationIndexedLine locationIndexedLine = new LocationIndexedLine(l1);

        //需要投影的线 l2
        Geometry l2 = wktReader.read("LINESTRING (115.80595615 39.2572154, 115.80595925 39.25721525, 115.805963 39.257216, 115.80597005 39.2572147, 115.8059741 39.25721525, 115.80597955 39.2572156, 115.80598315 39.2572162, 115.8059867 39.25721525, 115.805989 39.257215, 115.80599165 39.25721505)");

        //截取l2上面的始终点
        Coordinate p1 = l2.getCoordinates()[0];
        Coordinate Pn = l2.getCoordinates()[l2.getCoordinates().length-1];

        LinearLocation indexOfStart = locationIndexedLine.indexOf(p1);
        LinearLocation indexOfEnd = locationIndexedLine.indexOf(Pn);

        //投影后的起点、终点坐标
        System.out.println("p1起点映射后的P11:"+l2.getCoordinates()[indexOfStart.getSegmentIndex()]);
        System.out.println("Pn终点映射后的Pnn:"+l2.getCoordinates()[indexOfEnd.getSegmentIndex()]);

        //截取线段
        Geometry L11 = locationIndexedLine.extractLine(indexOfStart, indexOfEnd);

        System.out.println("l2投影到l1对象l22:"+L11.toText());

        //p1起点映射后的P11:(115.80595925, 39.25721525, NaN)
        //Pn终点映射后的Pnn:(115.805989, 39.257215, NaN)
        //l2投影到l1对象l22:LINESTRING (115.80595543653845 39.25721896730769, 115.8059566 39.2572192, 115.805962 39.2572191, 115.8059678 39.2572183, 115.8059764 39.2572184, 115.8059806 39.2572192, 115.8059855 39.2572193, 115.8059884 39.2572182, 115.80599165 39.2572182)


    }

    public static void main(String[] args) throws ParseException {
        //通过 LocationIndexedLine来实现
        LineToLineShadowTest.method1();
    }
}
