package com.techelevator.model;

import java.time.LocalDate;

public class Movie {
    private int movieId;
    private String title;
    private String overview;
    private String tagline;
    private String posterPath;
    private String homePage;
    private LocalDate releaseDate;
    private int lengthInMinutes;
    private int directorId;
    private int collectionId;

    public Movie() {

    }

    public Movie(int movieId, String title, String overview, String tagline, String posterPath, String homePage, LocalDate releaseDate, int lengthInMinutes, int directorId, int collectionId) {
        this.movieId = movieId;
        this.title = title;
        this.overview = overview;
        this.tagline = tagline;
        this.posterPath = posterPath;
        this.homePage = homePage;
        this.releaseDate = releaseDate;
        this.lengthInMinutes = lengthInMinutes;
        this.directorId = directorId;
        this.collectionId = collectionId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }
}
