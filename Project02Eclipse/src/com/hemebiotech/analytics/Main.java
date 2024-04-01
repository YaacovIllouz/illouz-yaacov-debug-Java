package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        ISymptomReader isSymptomReader = new ReadSymptomDataFromFile(".../symptoms.txt");
        ISymptomWriter isSymptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(isSymptomReader, isSymptomWriter);

        List<String> getSymptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> mapSymptoms =  analyticsCounter.countSymptoms(getSymptoms);
        Map<String, Integer> sortedSymptoms =  analyticsCounter.sortSymptoms(mapSymptoms);
        analyticsCounter.writeSymptoms(sortedSymptoms);

    }
}
