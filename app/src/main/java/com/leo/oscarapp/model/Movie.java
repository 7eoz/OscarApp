package com.leo.oscarapp.model;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int photo;

    public Movie(int id, String name, String genre, int photo) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
