package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor of the class AnalyticsCounter
	 * @param reader Class who read a file and return an ArrayList whith the lines of file
	 * @param writter Class who write a new file whith the Map<String, Integer> in parametre
	 */
	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writter) {
		this.reader = reader;
		this.writer = writter;
	}

	/**
	 * Get a ArrayList of lines in a file
	 * @return ArrayList of lines in a file
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Count occurences of symptoms
	 * @param symptoms ArrayList of symptoms
	 * @return Map<String, Integer> whith the sympyoms and their quantities
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();

		for (String symptom : getSymptoms()){
			if (mapSymptoms.containsKey(symptom)) {
				mapSymptoms.put(symptom, mapSymptoms.get(symptom) + 1);
			} else {
				mapSymptoms.put(symptom, 1);
			}
		}

		return mapSymptoms;
	}

	/**
	 * Reorder in ASC the Map of symptoms
	 * @param symptoms Map of symptoms
	 * @return Map reorder
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedMap = new TreeMap<>(symptoms);
		return sortedMap;
	}

	/**
	 * Write the symptoms and their quantities in a file
	 * @param symptoms Map of the symptoms
	 * @throws IOException
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}

}
