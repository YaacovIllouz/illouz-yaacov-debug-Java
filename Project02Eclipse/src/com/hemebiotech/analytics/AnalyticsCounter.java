package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headCount = 0;
	private static int rashCount = 0;
	private static int dilatedPupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		// read each line of file symptom.txt and count of occurences symptomes
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dialated pupils")) {
				dilatedPupilCount++;
			}

			line = reader.readLine();
		}
		
		// generate a new output result.out file with list of occurences of symptomes
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + AnalyticsCounter.headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dilatedPupilCount + "\n");
		writer.close();
	}
}
