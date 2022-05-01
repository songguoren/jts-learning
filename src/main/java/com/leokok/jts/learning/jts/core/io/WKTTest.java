package com.leokok.jts.learning.jts.core.io;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTFileReader;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * WKT数据格式操作使用说明
 */
public class WKTTest {

    public static void main(String[] args) throws IOException, ParseException {
        //根据wkt string串读取
        WKTReader wktReader = new WKTReader();
        Geometry pointWkt = wktReader.read("POINT(6 10 2)");
        System.out.println(pointWkt);

        //根据文件读取WKT
        WKTFileReader wktFileReader = new WKTFileReader(new File(WKTTest.class.getResource("/").getPath()+"/wkt/wkt.wkt"), wktReader);
        List<Geometry> geometryList = wktFileReader.read();

        for(Geometry geometry : geometryList){
            System.out.println(geometry);
        }

        //输出
        WKTWriter wktWriter = new WKTWriter(3); //如果不输入3在输出的时候会忽略Z输出
        System.out.println(wktWriter.write(geometryList.get(0)));
        System.out.println(wktWriter.writeFormatted(geometryList.get(0))); //最后加 \n 换行符

    }
}
