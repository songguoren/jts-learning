package com.leokok.jts.learning.jts.core.demo;

import org.locationtech.jts.algorithm.Angle;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.math.Vector2D;

/**
 * 向量角度计算
 */
public class Vector2DTest {

    public static void main(String[] args) {
        Vector2D l0 = new Vector2D(new Coordinate(764, 193),new Coordinate(758, 63));

        Vector2D l1 = new Vector2D(new Coordinate(764, 193), new Coordinate(747, 210));
        Vector2D l2 = new Vector2D(new Coordinate(764, 193), new Coordinate(771, 207));
        Vector2D l3 = new Vector2D(new Coordinate(764, 193), new Coordinate(782, 198));

        System.out.println("angle l0,l1=" + Angle.toDegrees(l0.angle(l1)));
        System.out.println("angle l0,l2=" + Angle.toDegrees(l0.angle(l2)));
        System.out.println("angle l0,l3=" + Angle.toDegrees(l0.angle(l3)));


        Double l0ToL1 = Angle.interiorAngle(new Coordinate(758, 63),new Coordinate(764, 193),new Coordinate(747, 210));
        Double l0ToL2 = Angle.interiorAngle(new Coordinate(758, 63),new Coordinate(764, 193),new Coordinate(771, 207));
        Double l0ToL3 = Angle.interiorAngle(new Coordinate(758, 63),new Coordinate(764, 193),new Coordinate(782, 198));

        System.out.println("angle l0,l1=" + Angle.toDegrees(l0ToL1));
        System.out.println("angle l0,l2=" + Angle.toDegrees(l0ToL2));
        System.out.println("angle l0,l3=" + Angle.toDegrees(l0ToL3));
    }
}
