package com.leokok.jts.learning.jts.core.geomgraph;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateArrays;
import org.locationtech.jts.geom.CoordinateList;
import org.locationtech.jts.geomgraph.*;

public class PlanarGraphTest {

    public static void main(String[] args) {

        //平面图
        PlanarGraph planarGraph = new PlanarGraph();

        DirectedEdgeStar directedEdgeStar = new DirectedEdgeStar();

        //定义平面图 node  边的各个顶点node
        planarGraph.addNode(new Node(new Coordinate(0.0,0.0), directedEdgeStar));
        planarGraph.addNode(new Node(new Coordinate(0.0,0.0), directedEdgeStar)); //A点
        planarGraph.addNode(new Node(new Coordinate(1.0,1.0), directedEdgeStar)); //B点
        planarGraph.addNode(new Node(new Coordinate(2.0,0.5), directedEdgeStar)); //C点
        planarGraph.addNode(new Node(new Coordinate(2.5,1.5), directedEdgeStar)); //D点

        //添加边 A-B的边
        //定义边  边可以由多个形状点构成
        CoordinateList coordinateListAB = new CoordinateList();
        coordinateListAB.add(new Coordinate(0.0,0.0));
        coordinateListAB.add(new Coordinate(0.5,0.5));
        coordinateListAB.add(new Coordinate(1.0,1.0));

        Edge edgeAB = new Edge(CoordinateArrays.toCoordinateArray(coordinateListAB),new Label(1));

        DirectedEdge edgeEndAB = new DirectedEdge(edgeAB, true);

        planarGraph.add(edgeEndAB);

        //添加边 B-D 的边
        //定义边  边可以由多个形状点构成
        CoordinateList coordinateListBD = new CoordinateList();
        coordinateListBD.add(new Coordinate(1.0,1.0));
        coordinateListBD.add(new Coordinate(2.5,1.5));
        Edge edgeBD = new Edge(CoordinateArrays.toCoordinateArray(coordinateListBD), new Label(1));
        //p0- p1 方向
        DirectedEdge edgeEndBD = new DirectedEdge(edgeBD, true);

        planarGraph.add(edgeEndBD);

        //添加边 D-C 的边
        //定义边  边可以由多个形状点构成
        CoordinateList coordinateListDC = new CoordinateList();
        coordinateListDC.add(new Coordinate(2.5,1.5));
        coordinateListDC.add(new Coordinate(2.0,0.5));
        Edge edgeDC = new Edge(CoordinateArrays.toCoordinateArray(coordinateListDC), new Label(1));
        //p0- p1 方向
        DirectedEdge edgeEndDC = new DirectedEdge(edgeDC,true);

        planarGraph.add(edgeEndDC);

        //添加边 C-A 的边
        //定义边  边可以由多个形状点构成
        CoordinateList coordinateListCA = new CoordinateList();
        coordinateListCA.add(new Coordinate(2.0,0.5));
        coordinateListCA.add(new Coordinate(0.0,0.0));
        Edge edgeCA = new Edge(CoordinateArrays.toCoordinateArray(coordinateListCA), new Label(1));
        //p0- p1 方向
        DirectedEdge edgeEndCA = new DirectedEdge(edgeCA, true);

        planarGraph.add(edgeEndCA);


       Edge edge = planarGraph.findEdge(new Coordinate(0.0,0.0), new Coordinate(2.0,0.5));

        System.out.println(edge.getCoordinates());
    }
}
