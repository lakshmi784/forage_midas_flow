package com.jpmc.midascore;

import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FileLoader {

    public String[] loadStrings(String path) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(path);

            if (inputStream == null) {
                return null;
            }

            String fileText = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            // Split correctly for both Windows and Linux line endings
            return fileText.split("\\r?\\n");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}