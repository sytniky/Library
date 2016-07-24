package edu.hillel.library.model;

/**
 * Created by yuriy on 22.07.16.
 */
public class Author {
    private long id;
    private String firstName;
    private String secondName;

    public Author(long id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName();
    }
}
