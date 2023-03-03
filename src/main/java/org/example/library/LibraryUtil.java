package org.example.library;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LibraryUtil {
    private static File jsonFile = new File("src/main/java/org/example/library/data/movies.json");

    public static MovieLibrary getMovieLibraryFromJson() throws IOException {
        return new MovieLibrary(new ObjectMapper().readValue(jsonFile, new TypeReference<>() {
        }));
    }
}
