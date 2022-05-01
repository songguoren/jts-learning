package com.leokok.jts.learning.jts.core.algorithm;

import org.locationtech.jts.algorithm.Angle;
import org.locationtech.jts.geom.Coordinate;

/**
 * 角度计算
 */
public class AngleTest {

    public static void main(String[] args) {

        //计算p0到p1的弧度 Angle.angle(p0,p1)已x轴为参考向量，通过p0到p1向量的角度值(返回弧度)
        Coordinate p0 = new Coordinate(1,1);
        Coordinate p1 = new Coordinate(2,3);

        double radiansP0ToP1 = Angle.angle(p0,p1);
        System.out.println("弧度Angle.angle(p0,p1)="+radiansP0ToP1+";角度Angle.toDegrees(radiansP0ToP1)="+Angle.toDegrees(radiansP0ToP1));

        double radiansP1ToP0 = Angle.angle(p1,p0);
        System.out.println("弧度Angle.angle(p1,p0)="+radiansP1ToP0+";角度Angle.toDegrees(radiansP1ToP0)="+Angle.toDegrees(radiansP1ToP0));


        //计算p0到p1的弧度 Angle.angle(p0,p1)已x轴为参考向量，通过p0到p1向量的角度值(返回弧度)
        Coordinate p2 = new Coordinate(1,3);
        Coordinate p3 = new Coordinate(3,1);

        double radiansP2ToP3 = Angle.angle(p2,p3);
        System.out.println("弧度Angle.angle(p2,p3)="+radiansP2ToP3+";角度Angle.toDegrees(radiansP2ToP3)="+Angle.toDegrees(radiansP2ToP3));

        //计算是否是锐角
        Coordinate B = new Coordinate(0,2);
        Coordinate A = new Coordinate(1,1);
        Coordinate C = new Coordinate(1,3);

        System.out.println("是否是锐角:boolean="+Angle.isAcute(B,A,C));


        //返回两个向量之间无方向的最小夹角
        double bac = Angle.angleBetween(B,A,C);
        System.out.println("bac夹角Angle.angleBetween(B,A,C)="+bac+";角度Angle.toDegrees(bac)="+Angle.toDegrees(bac));


        //返回两个向量之间方向的最小夹角
        //顺时针 (CW) rotation
        double bacOriented = Angle.angleBetweenOriented(B,A,C);
        System.out.println("bacOriented顺时针夹角Angle.angleBetweenOriented(B,A,C)="+bacOriented+";顺时针角度Angle.toDegrees(bacOriented)="+Angle.toDegrees(bacOriented));
        //bacOriented顺时针夹角Angle.angleBetweenOriented(B,A,C)=-0.7853981633974483;顺时针角度Angle.toDegrees(bacOriented)=-45.0

        //逆时针(CCW) rotation
        double bacOrientedCCW = Angle.angleBetweenOriented(C,A,B);
        System.out.println("bacOrientedCCW逆时针夹角Angle.angleBetweenOriented(C,A,B)="+bacOrientedCCW+";逆时针角度Angle.toDegrees(bacOrientedCCW)="+Angle.toDegrees(bacOrientedCCW));
        //bacOrientedCCW逆时针夹角Angle.angleBetweenOriented(C,A,B)=0.7853981633974483;逆时针角度Angle.toDegrees(bacOrientedCCW)=45.0

        //找对应的顺时针角度,例如 -45°=>315°
        System.out.println(Angle.toDegrees(Angle.normalizePositive(bacOriented)));
        //315.0

        //找对应的位置 0到180(逆时针)之间返回正数，180-360(顺时针)之前返回负数
        System.out.println(Angle.toDegrees(Angle.normalize(Angle.toRadians(50))));
        //50.0
        System.out.println(Angle.toDegrees(Angle.normalize(Angle.toRadians(181))));
        //-179.0
        System.out.println(Angle.toDegrees(Angle.normalize(Angle.toRadians(369))));
        //9.0
        System.out.println(Angle.toDegrees(Angle.normalize(Angle.toRadians(-10))));
        //-10.0

        //差值计算
        double ang01 = Angle.normalize(Angle.toRadians(10));
        double ang02 = Angle.normalize(Angle.toRadians(369)); //0.9999999999999999
//        double ang02 = Angle.normalize(Angle.toRadians(-10)); //20
        System.out.println(Angle.toDegrees(Angle.diff(ang01,ang02)));

        //10.Angle.interiorAngle(Coordinate p0, Coordinate p1, Coordinate p2) 计算内角(最小角)
        Coordinate Bi = new Coordinate(0,2);
        Coordinate Ai = new Coordinate(1,1);
        Coordinate Ci = new Coordinate(1,3);
        //延Ai-Bi边逆时针转到Ai-CI边的角度值
        System.out.println("Angle.interiorAngle(Bi,Ai,Ci)角度="+Angle.toDegrees(Angle.interiorAngle(Bi,Ai,Ci)));
        //Angle.interiorAngle(Bi,Ai,Ci)角度=315.0

        //延Ci-Ai边逆时针转到Ai-BI边的角度值
        System.out.println("Angle.interiorAngle(Ci,Ai,Bi)角度="+Angle.toDegrees(Angle.interiorAngle(Ci,Ai,Bi)));
        //Angle.interiorAngle(Ci,Ai,Bi)角度=45.0

    }
}
