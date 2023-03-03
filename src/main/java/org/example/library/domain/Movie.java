package org.example.library.domain;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Movie {
    private String title;
    private Director director;
    private String genre;
    private int date;
    private List<Actor> actors;

    @Override
    public String toString() {
        return String.format("""
                        title: %s
                        director: %s
                        genre: %s
                        date: %d
                        actors: %s""", title, director.toString(), genre, date,
                actors.stream().map(Actor::toString).collect(Collectors.joining(", ")));
    }

    public final BiPredicate<Integer, Integer> isDateBetween = (startDate, endDate) -> date >= startDate && date <= endDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

}
