package edu.hillel.library.model;

/**
 * Created by yuriy on 22.07.16.
 */
public class Book {
    private long id;
    private int coverId;
    private String name;
    private String annotation;

    public Book(long id, int coverId, String name, String annotation) {
        this.id = id;
        this.coverId = coverId;
        this.name = name;
        this.annotation = annotation;
    }

    public long getId() {
        return id;
    }

    public int getCoverId() {
        return coverId;
    }

    public String getName() {
        return name;
    }

    public String getAnnotation() {
        return annotation;
    }

    @Override
    public String toString() {
        return getName();
    }
}
