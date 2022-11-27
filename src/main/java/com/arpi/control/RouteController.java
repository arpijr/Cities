package com.arpi.control;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import com.arpi.graph.Graph;
import com.arpi.graph.Node;
import com.arpi.model.Cost;
import com.arpi.model.Vehicle;

public class RouteController {

	public Graph calculateShortestPathFromSrcToDest(Graph graph, String sourceCity, String destCity, Vehicle v) {

		Node src = graph.getNodes().stream().filter(node -> node.getName().equals(sourceCity)).findAny().get();
		Graph resultGraph = calculateShortestPathFromSource(graph, src, v);
		Node dest = resultGraph.getNodes().stream().filter(node -> node.getName().equals(destCity)).findAny().get();
		
		displayShortestPathAndConsumption(dest, sourceCity, destCity);

		return resultGraph;
		
	}
	
	private void displayShortestPathAndConsumption(Node destNode, String sourceCity, String destCity) {
		
		System.out.println("Cheapest path between cities: (" + sourceCity + "->" + destCity + "):");
		if(destNode.getShortestPath().isEmpty()) {
			System.out.println("There is no path between selected cities.");
		}else {
			System.out.print("\t|");
			destNode.getShortestPath().forEach(n -> System.out.print("-" + n.getName() + "-"));
			System.out.print("| -> " + destCity);
			System.out.print("\tConsumption: " + destNode.getDistance() + "\n");	
		}

	}

	private Graph calculateShortestPathFromSource(Graph graph, Node source, Vehicle v) {
		
		source.setDistance(0.0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();

		unsettledNodes.add(source);

		while (unsettledNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			for (Entry<Node, Cost> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Double edgeWeight =  calculateFinalCostForEdge(adjacencyPair.getValue(), v);
				if (!settledNodes.contains(adjacentNode)) {
					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		return graph;
	}

	private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		double lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			double nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	private void calculateMinimumDistance(Node evaluationNode, Double edgeWeigh, Node sourceNode) {
		Double sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}
	
	public double calculateFinalCostForEdge(Cost cost, Vehicle v) {
		
		Double gasConsumptionPerOneKm = v.value/100.0;
		
		return gasConsumptionPerOneKm*cost.getDistance() + cost.getDistance() +cost.getDuty() + cost.getHigwayFee();
	
	}

}
