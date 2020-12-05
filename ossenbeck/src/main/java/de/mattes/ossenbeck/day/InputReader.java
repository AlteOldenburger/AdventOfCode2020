package de.mattes.ossenbeck.day;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {

    private InputReader() {}

    public static List<String> read(String filename) {
        try {
            return Files.readAllLines(Paths.get(InputReader.class.getResource("/" + filename).toURI()));
        } catch (final Exception e) {
            throw new RuntimeException("There was an error while reading the file " + filename);
        }
    }
}