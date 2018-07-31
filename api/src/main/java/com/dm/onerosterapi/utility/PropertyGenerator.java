package com.dm.onerosterapi.utility;

import com.dm.onerosterapi.exceptions.FileIOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class PropertyGenerator {

    @Value("${property.file}")
    private String propsfile;

    public Map<String, String> generateProperties() {
        FileHandler fh = new FileHandler();
        try {
            return fh.readPropsFromFile(propsfile);
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
                    new InputStreamReader(
                    new ClassPathResource(filename).getInputStream())));

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