package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


public class Main {
    /**
     * Read a file symptoms, count the number of occurences, write the result in a file.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ISymptomReader isSymptomReader = new ReadSymptomDataFromFile("C:/Users/bensi/IdeaProjects/illouz-yaacov-debug-Java/Project02Eclipse/symptoms.txt");
        ISymptomWriter isSymptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(isSymptomReader, isSymptomWriter);

        List<String> getSymptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> mapSymptoms =  analyticsCounter.countSymptoms(getSymptoms);
        Map<String, Integer> sortedSymptoms =  analyticsCounter.sortSymptoms(mapSymptoms);
        analyticsCounter.writeSymptoms(sortedSymptoms);

    }
}
