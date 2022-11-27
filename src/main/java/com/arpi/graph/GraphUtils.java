package com.arpi.graph;

public class GraphUtils {

	public static void printGraph(Graph g) {
		System.out.println("##############");
		System.out.println("# Graph state:");
		System.out.println("##############");

		for (Node n : g.getNodes()) {
			System.out.println(n.toString());
			System.out.println("\tAdjacents: ");
			n.getAdjacentNodes().entrySet().forEach(entry -> {
				System.out.println("\t " + entry.getKey().toString() + " dist : " + entry.getValue().getDistance());
			});
		}

	}

}
