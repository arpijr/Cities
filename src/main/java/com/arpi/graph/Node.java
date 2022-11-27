package com.arpi.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arpi.model.Cost;

public class Node {

	private String name;

	private List<Node> shortestPath = new LinkedList<>();

	private Double distance = Double.MAX_VALUE;

	Map<Node, Cost> adjacentNodes = new HashMap<>();

	public void addDestination(Node destination, Cost cost) {
		adjacentNodes.put(destination, cost);
	}

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Map<Node, Cost> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Cost> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	@Override
	public String toString() {

		return "Node: [name=" + name + ", shortestPath=" + displayShortestPath(shortestPath) + ", distance=" + distance
				+ "]";
	}

	public String displayShortestPath(List<Node> shortestPath) {

		String shortestPathStr = "";

		if (shortestPath.isEmpty())
			shortestPathStr = "N/A";
		else {
			for (Node n : shortestPath) {
				shortestPathStr = shortestPathStr.concat(n.getName());
			}
		}

		return shortestPathStr;
	}

}
