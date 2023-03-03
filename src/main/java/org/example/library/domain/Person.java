package org.example.library.domain;

import java.util.function.BiPredicate;

public abstract class Person {

    private String name;
    private String surname;

    public Person() {
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }

    public final BiPredicate<String, String> isMatch = (name, surname) -> name.equalsIgnoreCase(this.name) && surname.equalsIgnoreCase(this.surname);

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
