package org.io;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Reader {
	
	public static ArrayList<String> loadTowns(String textPath) {
		ArrayList<String> towns = new ArrayList<String>();
		try {
			Path path = Paths.get(textPath);
			Files.lines(path, StandardCharsets.UTF_8).forEach(town -> {	
				towns.add(town);
			});
		} catch (IOException e) {
			System.err.println("Problem in reading the file input.txt");
		}
		return towns;
	}
}
