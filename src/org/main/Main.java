package org.main;

import java.util.ArrayList;

import org.classes.Graph;
import org.io.Formatter;
import org.io.Reader;
import org.io.Writer;
import org.classes.Routes;
import org.classes.Trains;

public class Main {
	
	// This is the main function that will be calling the functions to write the outputs to a new text file called ouput.txt
	// Functions are as below
	// distanceOfRoute(String) =  find distance from a specific route
	// numberOfTripsMaxStops(String route start, String route end, Integer maximum number of trips) = find number of trips with a maximum of stops
	// numberOfTripsExactStops(String route start, String route end, Integer exact number of trips) = find number of trips with exactly stops
	// shortestRoute(String start of route, String end of route) = find length of the shortest route between two towns
	// amountOfTripsWithinDistance(String start of route, String end of route, Integer maximum distance allowed) = find all routes from start to end with a distance of less than a specific number
	
	public static void main(String[] args) {
		ArrayList<String> towns = Reader.loadTowns("input.txt");
		Graph graph = new Graph(towns);
		Routes routes = new Routes(graph.getGraph());
		Trains train = new Trains(graph, routes);
		
		// find distance, we should insert or edit the route argument for distanceOfRoute as below
		String output1 = train.distanceOfRoute("ABC");
		String output2 = train.distanceOfRoute("AD");
		String output3 = train.distanceOfRoute("ADC");
		String output4 = train.distanceOfRoute("AEBCD");
		String output5 = train.distanceOfRoute("AED");
		
		// find number of trips within maximum amount of stops, we should start first, then end, and finally max number of trips
		int output6    = train.numberOfTripsMaxStops("C", "C", 3);
		
		// find number of trips with an exact amount of stops, we should put start first, then end, and finally exact number of trips
		int output7    = train.numberOfTripsExactStops("A", "C", 4);
		
		// find shortest route between two towns, we should name start, then end
		int output8    = train.shortestRoute("A", "C");
		int output9    = train.shortestRoute("B", "B");
		
		// find amount of trips within a specific distance, we should name start, then end, and finally maximum distance
		int output10   = train.amountOfTripsWithinDistance("C", "C", 30);
		
		// formatting the output
		String formmatedData =  Formatter.formatOutput(output1, output2, output3, output4, output5, output6, output7, output8, output9, output10);
		// output.txt in the root directory.
		Writer.writeOutputs(formmatedData);
	}

}
