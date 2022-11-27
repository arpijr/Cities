package com.arpi;

import com.arpi.control.RouteController;
import com.arpi.graph.Graph;
import com.arpi.graph.GraphUtils;
import com.arpi.graph.Node;
import com.arpi.model.Cost;
import com.arpi.model.Vehicle;

public class App {

    public static void main(String[] args) {
        System.out.println("RoutePathFinder App is running");
        
        RouteController routeController = new RouteController();
        
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D"); 
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
    
        nodeA.addDestination(nodeB, new Cost(3,0,0));
        nodeA.addDestination(nodeC, new Cost(15,0,0));

        nodeB.addDestination(nodeD, new Cost(12,0,0));
        nodeB.addDestination(nodeF, new Cost(15,0,0));
        nodeB.addDestination(nodeA, new Cost(7,0,0));

        nodeC.addDestination(nodeE, new Cost(10,0,0));

        nodeD.addDestination(nodeE, new Cost(2,0,0));
        nodeD.addDestination(nodeF, new Cost(1,0,0));

        nodeE.addDestination(nodeB, new Cost(3,0,0));
        nodeE.addDestination(nodeA, new Cost(9,0,0));
        


        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        GraphUtils.printGraph(graph);
        
        Graph result = routeController.calculateShortestPathFromSrcToDest(graph, "A", "E", Vehicle.CAR);
        
    }
    
    
}
