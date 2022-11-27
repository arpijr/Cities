
package com.arpi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.arpi.graph.Graph;
import com.arpi.graph.Node;
import com.arpi.model.Cost;
import com.arpi.model.Vehicle;

class RouteControllerTests extends TestBase {

	@Test
	void When_NoRouteBetweenNodes_Expect_EmptyShortestPathList() {
		
		//given:
			Graph g = createTestGraph();
			Graph result;

		//when:
			result = routeController.calculateShortestPathFromSrcToDest(g, "F", "A", Vehicle.CAR);
			Node node = result.getNodes().stream().filter(n -> n.getName().equals("A")).findAny().get();
			
		//then:
			Assertions.assertTrue(node.getShortestPath().isEmpty());
		
	}
	
	@Test
	void When_IsRouteBetweenNodes_Expect_NotEmptyShortestPathList() {
		
		//given:
			Graph g = createTestGraph();
			Graph result;

		//when:
			result = routeController.calculateShortestPathFromSrcToDest(g, "A", "E", Vehicle.CAR);
			Node node = result.getNodes().stream().filter(n -> n.getName().equals("E")).findAny().get();
			
		//then:
			Assertions.assertFalse(node.getShortestPath().isEmpty());
		
	}
	
	
	@Test
	void When_IsRouteBetweenNodes_Expect_CorrectShortestPathList() {
		
		//given:
			Graph g = createTestGraph();
			Graph result;

		//when:
			result = routeController.calculateShortestPathFromSrcToDest(g, "A", "E", Vehicle.CAR);
			Node node = result.getNodes().stream().filter(n -> n.getName().equals("E")).findAny().get();
			
			String city_first = node.getShortestPath().get(0).getName();
			String city_second = node.getShortestPath().get(1).getName();
			String city_third = node.getShortestPath().get(2).getName();
			
		//then:
			Assertions.assertEquals(city_first, "A");
			Assertions.assertEquals(city_second, "B");
			Assertions.assertEquals(city_third, "D");

	}
	
	@Test
	void When_IsRouteBetweenNodes_Expect_CorrectConsumptionValue() {
		
		//given:
			Graph g = createTestGraph();
			Graph result;

		//when:
			result = routeController.calculateShortestPathFromSrcToDest(g, "A", "E", Vehicle.CAR);
			Node node = result.getNodes().stream().filter(n -> n.getName().equals("E")).findAny().get();
			double totalConsumptionForRoute = node.getDistance();
			
		//then:
			Assertions.assertEquals(18.19, totalConsumptionForRoute);


	}
	
	@Test
	void When_calculateFinalCostForEdge_Expect_CorrectValues() {
		
		//given:
			Vehicle v1 = Vehicle.SCOOTER;
			Vehicle v2 = Vehicle.CAR;
			Vehicle v3 = Vehicle.TRUCK;
			
			Cost c1 = new Cost(10, 0, 0);
			Cost c2 = new Cost(10, 20, 0);
			Cost c3 = new Cost(10, 20, 30);
			
		//when:
			Double result1 = routeController.calculateFinalCostForEdge(c1, v1);
			Double result2 = routeController.calculateFinalCostForEdge(c2, v2);
			Double result3 = routeController.calculateFinalCostForEdge(c3, v3);

		//then:
			Assertions.assertEquals(10.1, result1);
			Assertions.assertEquals(30.7, result2 );
			Assertions.assertEquals(62.0, result3);
		
	}
	
	
}
