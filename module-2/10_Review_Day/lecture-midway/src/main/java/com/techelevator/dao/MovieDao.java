package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {
    // Create
    Movie create(Movie movie);

    // Retrieve
    List<Movie> getAll();

    Movie getById(int movieId);

    // U
    void update(Movie movie);

    // D
    void delete(int movieId);

    // Extras
    List<Movie> getMoviesWithRuntimeLessThan(int runtime);

    List<Movie> getMoviesWithActor(int actorId);

    List<Movie> searchForMovieByNameOrOverview(String searchString);

    List<Movie> getMoviesOfGenre(int genreId);
}
