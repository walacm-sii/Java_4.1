package org.example.library;

import org.example.library.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MovieLibrary {

    private List<Movie> movies;

    public MovieLibrary(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getRandomMovie() {
        return movies.get(new Random().nextInt(movies.size()));
    }

    public List<Movie> getMoviesBetweenDates(int startDate, int endDate) {
        return movies.stream()
                .filter(movie -> movie.isDateBetween.test(startDate, endDate))
                .collect(Collectors.toList());
    }

    public List<Movie> getActorMovies(String name, String surname) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream().anyMatch(actor -> actor.isMatch.test(name, surname)))
                .collect(Collectors.toList());
    }

}
