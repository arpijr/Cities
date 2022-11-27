package com.arpi;

import com.arpi.control.RouteController;
import com.arpi.graph.Graph;
import com.arpi.graph.Node;
import com.arpi.model.Cost;

public class TestBase {

    protected RouteController routeController = new RouteController();
	
	protected Graph createTestGraph() {
		
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
	    
	    return graph;
	}
		
	
	
}
