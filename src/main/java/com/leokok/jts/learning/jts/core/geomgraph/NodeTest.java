package com.leokok.jts.learning.jts.core.geomgraph;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geomgraph.Node;
import org.locationtech.jts.geomgraph.NodeFactory;
import org.locationtech.jts.geomgraph.NodeMap;
import org.locationtech.jts.geomgraph.PlanarGraph;

public class NodeTest {

    public static void main(String[] args) {
        NodeFactory nodeFactory = new NodeFactory();

      //  Node node = nodeFactory.createNode(new Coordinate(0.0,0.0));

        NodeMap nodeMap = new NodeMap(nodeFactory);

        nodeMap.addNode(new Coordinate(0.0,0.0));
        nodeMap.addNode(new Coordinate(1.0,1.0));
        nodeMap.addNode(new Coordinate(2.0,0.5));
        nodeMap.addNode(new Coordinate(2.5,1.5));






    }
}
