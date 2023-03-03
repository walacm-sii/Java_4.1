package org.example;

import org.example.library.MovieLibrary;
import org.example.library.domain.Movie;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private MovieLibrary library;

    private Scanner scanner;

    private final String MENU = """
            1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami
            2. Wyświetl wszystkie informacje o losowym filmie
            3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał""";

    public Controller(MovieLibrary library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        outerloop:
        while (true) {
            System.out.println(MENU);
            switch (scanner.nextLine()) {
                case "1" -> printMoviesBetweenDates();
                case "2" -> printRandomMovieDetails();
                case "3" -> printActorMovies();
                default -> {
                    break outerloop;
                }
            }
        }
    }

    private void printMoviesBetweenDates() {
        System.out.println("Podaj pierwsza date");
        int startDate = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj druga date");
        int endDate = Integer.parseInt(scanner.nextLine());
        printListIfNotEmpty(library.getMoviesBetweenDates(startDate, endDate));
    }

    private void printRandomMovieDetails() {
        System.out.println(library.getRandomMovie().toString());
    }

    private void printActorMovies() {
        System.out.println("Podaj imie aktora");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko aktora");
        String surname = scanner.nextLine();
        printListIfNotEmpty(library.getActorMovies(name, surname));
    }

    private void printListIfNotEmpty(List<Movie> movies) {
        if (!movies.isEmpty()) {
            movies.forEach(movie -> System.out.println(movie.getTitle()));
        } else {
            System.out.println("Nie znaleziono pasujacych wyników");
        }
    }

}
