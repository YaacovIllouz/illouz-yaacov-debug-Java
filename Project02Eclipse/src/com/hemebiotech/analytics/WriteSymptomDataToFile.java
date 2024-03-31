package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        final String FILEOUTPUT = "result.out";

        try {
            FileWriter writer = new FileWriter(FILEOUTPUT);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                writer.write(key + ": " + value);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
