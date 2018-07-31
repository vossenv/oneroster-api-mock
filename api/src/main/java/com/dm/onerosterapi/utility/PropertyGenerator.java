package com.dm.onerosterapi.utility;

import com.dm.onerosterapi.exceptions.FileIOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PropertyGenerator {

    public Map<String, String> generateProperties() {
        FileHandler fh = new FileHandler();
        try {
            return fh.readPropsFromFile("version.dat");
        } catch (Exception e){
           return new LinkedHashMap<>();
        }
    }
}

class FileHandler {
    Map<String, String> readPropsFromFile(String filename) throws FileIOException {

        try {
            Scanner scanner =
                    new Scanner(
                    new BufferedReader(
                    new FileReader(
                             getClass()
                            .getClassLoader()
                            .getResource(filename).getFile())));

            Map<String, String> propsMap = new LinkedHashMap<>();
            while (scanner.hasNextLine()) {

                String currentline = scanner.nextLine();
                try {
                    if (!currentline.trim().startsWith("//")) {
                        String[] currentTokens = currentline.split("=");
                        propsMap.put(currentTokens[0].trim(), currentTokens[1].trim());
                    }
                } catch (Exception e) { /* Skips line */ }

            }

            scanner.close();
            return propsMap;
        } catch (Exception e) {

            throw new FileIOException("Error reading file");
        }
    }
}