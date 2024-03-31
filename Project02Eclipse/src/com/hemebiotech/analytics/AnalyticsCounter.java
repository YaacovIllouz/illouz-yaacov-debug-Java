package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public ISymptomReader reader;
	private ISymptomWriter writer;
	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writter) {
		this.reader = reader;
		this.writer = writter;
	}
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedMap = new TreeMap<>(symptoms);
		return sortedMap;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}

}
