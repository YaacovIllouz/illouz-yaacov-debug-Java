package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    /**
     * Write the symptoms and their quantities in a file
     * @param symptoms Map of the symptoms
     * @throws IOException
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        final String FILEOUTPUT = "result.out";

        try {
            FileWriter writer = new FileWriter(FILEOUTPUT);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                writer.write(key + ": " + value+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
