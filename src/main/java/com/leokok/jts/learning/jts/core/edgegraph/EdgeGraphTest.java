package com.leokok.jts.learning.jts.core.edgegraph;

import org.locationtech.jts.edgegraph.EdgeGraph;
import org.locationtech.jts.edgegraph.HalfEdge;
import org.locationtech.jts.geom.Coordinate;


public class EdgeGraphTest {

    public static void main(String[] args) {


        Coordinate vertexA = new Coordinate(0.0,0.0);
        Coordinate vertexB = new Coordinate(1.0,0.0);
        Coordinate vertexC = new Coordinate(0.0,1.0);

        //构建图
        EdgeGraph edgeGraph = new EdgeGraph();
        edgeGraph.addEdge(vertexA, vertexC);
        edgeGraph.addEdge(vertexC, vertexB);

        //A,C
        HalfEdge halfEdge = edgeGraph.findEdge(vertexA, vertexC);

        //A->B 返回null 间接关系不支持
        HalfEdge halfEdgeAB = edgeGraph.findEdge(vertexA, vertexB);

    }
}
