package com.kodilla.completable.homework;

public class Book {

    private final String title;
    private final String author;
    private final int publicationYear;
    private String signature;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.signature = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return
                "Title: " + title +
                ", author: " + author +
                ", publication year: " + publicationYear +
                ", signature: " + signature;
    }
}
