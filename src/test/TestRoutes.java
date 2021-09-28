package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.classes.Graph;
import org.junit.Before;
import org.junit.Test;
import org.classes.Routes;

public class TestRoutes {
	
	private Routes routes;
	private Graph graph;
	
	@Before 
	public void setup() {
		List<String> towns = new ArrayList<String>();
		towns.add("AB5");
		towns.add("BC4");
		towns.add("CD8");
		towns.add("DC8");
		towns.add("DE6");
		towns.add("AD5");
		towns.add("CE2");
		towns.add("EB3");
		towns.add("AE7"); 
		graph = new Graph(towns);
		routes = new Routes(graph.getGraph());
	}

	@Test
	public void testStringedRoutes() {
		List<String> nodes = new LinkedList();
		nodes.add("A");
		String stringedNode = routes.stringedRoute(nodes);
		assertEquals("A", stringedNode);
	}

}
