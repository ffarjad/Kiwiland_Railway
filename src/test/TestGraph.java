package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedList;
import org.classes.Graph;
import org.junit.Test;


public class TestGraph {
	
	public ArrayList<String> createTownsArray(){
		ArrayList<String> towns = new ArrayList<String>();
		towns.add("AB5");
		towns.add("BC4");
		towns.add("CD8");
		towns.add("DC8");
		towns.add("DE6");
		towns.add("AD5");
		towns.add("CE2");
		towns.add("EB3");
		towns.add("AE7");
		return towns;
	}

	@Test
	public void testAdjacentNodes() {
		ArrayList<String> towns = createTownsArray(); 
		Graph graph = new Graph(towns);
		LinkedList<String> neighbors = graph.adjacentNodes("C");
		LinkedList<String> expected = new LinkedList<String>();
		expected.add("D");
		expected.add("E");
		assertEquals(neighbors, expected);
		
	}
	
	@Test
	public void testGetParents() {
		ArrayList<String> towns = createTownsArray(); 
		Graph graph = new Graph(towns);
		graph.createParents("C", "A");
		assertEquals("Unknown", graph.getParents().get("A"));
	}
	
	@Test
	public void testGetCosts() {
		ArrayList<String> towns = createTownsArray(); 
		Graph graph = new Graph(towns);
		graph.createCosts("A", "C");
		int costC = graph.getCosts().get("C");
		int costB = graph.getCosts().get("B");
		int costD = graph.getCosts().get("D");
		int costE = graph.getCosts().get("E");
		assertEquals(costC, Integer.MAX_VALUE);
		assertEquals(costB, 5);
		assertEquals(costD, 5);
		assertEquals(costE, 7);
	}


}
