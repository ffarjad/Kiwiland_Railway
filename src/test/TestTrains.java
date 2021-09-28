package test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.classes.*;
import org.junit.Before;
import org.junit.Test;

public class TestTrains {
	
	private List<String> towns;
	private Graph graph;
	private Routes routes;
	private Trains train;
	
	@Before
	public void setup() {
		towns = new ArrayList<String>();
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
		train = new Trains(graph, routes);
		
	}
	
	@Test
	public void testGetDistancesFromDataGraph() {
		int distanceAB = train.getGraph().getGraph().get("A").get("B");
		int distanceBC = train.getGraph().getGraph().get("B").get("C");
		int distanceCD = train.getGraph().getGraph().get("C").get("D");
		int distanceDC = train.getGraph().getGraph().get("D").get("C");
		int distanceDE = train.getGraph().getGraph().get("D").get("E");
		int distanceAD = train.getGraph().getGraph().get("A").get("D");
		int distanceCE = train.getGraph().getGraph().get("C").get("E");
		int distanceEB = train.getGraph().getGraph().get("E").get("B");
		int distanceAE = train.getGraph().getGraph().get("A").get("E");
		assertEquals(distanceAB, 5);
		assertEquals(distanceBC, 4);
		assertEquals(distanceCD, 8);
		assertEquals(distanceDC, 8);
		assertEquals(distanceDE, 6);
		assertEquals(distanceAD, 5);
		assertEquals(distanceCE, 2);
		assertEquals(distanceEB, 3);
		assertEquals(distanceAE, 7);
	}
	
	@Test
	public void testDistancesOfRoute() {
		String sumABC = train.distanceOfRoute("ABC");
		String sumAD = train.distanceOfRoute("AD");
		String sumADC = train.distanceOfRoute("ADC");
		String sumAEBCD = train.distanceOfRoute("AEBCD");
		String sumAED = train.distanceOfRoute("AED");
		assertEquals("9", sumABC);
		assertEquals("5", sumAD);
		assertEquals("13", sumADC);
		assertEquals("22", sumAEBCD);
		assertEquals("NO SUCH ROUTE", sumAED);
	}
	
	@Test
	public void testNumberOfTripsStops(){
		int tripsCC = train.numberOfTripsMaxStops("C", "C", 3);
		int tripsAC = train.numberOfTripsExactStops("A", "C", 4);
		assertEquals(tripsCC, 2);
		assertEquals(tripsAC, 3);
	}
	
	@Test
	public void testShortestRoute(){
		int tripsAC = train.shortestRoute("A", "C");
		int tripsBB = train.shortestRoute("B", "B");
		assertEquals(tripsAC, 9);
		assertEquals(tripsBB, 9);
	}
	
	@Test
	public void testAmountOfTripsWithinDistance(){
		int tripsCC = train.amountOfTripsWithinDistance("C", "C", 30);
		assertEquals(tripsCC, 7);
	}
}
