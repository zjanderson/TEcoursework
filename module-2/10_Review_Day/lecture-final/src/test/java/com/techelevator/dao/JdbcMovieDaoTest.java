package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcMovieDaoTest extends BaseDaoTests {
    private static final Movie MOVIE_1 = new Movie(1, "Star Wars", "Space Drama with starships. Lots of them. I've seen 2. Nobody likes Anakin.", null, null, null, null, 60, 1, 1);
    private static final Movie MOVIE_2 = new Movie(2, "Harry Potter", "Magic children vs. Inept Lizard Man.", null, null, null, null, 120, 1, 1);
    private static final Movie MOVIE_3 = new Movie(3, "Titanic", "World's largest metaphor sinks in the North Atlantic. Too long, didn't finish.", null, null, null, null, 360, 1, 1);

    private JdbcMovieDao jdbcMovieDao;

    @Before
    public void setup() {
        jdbcMovieDao = new JdbcMovieDao(dataSource);
    }

    @Test
    public void create_returns_movie_with_data() {
        // Arrange
        Movie createdMovie = new Movie(-1, "Movie 1", "Overview", "Tagline", "Poster Path", "Home Page", LocalDate.of(2022, 6, 24), 100, 1, 1);

        // Act
        Movie actualMovie = jdbcMovieDao.create(createdMovie);

        // Assert
        createdMovie.setMovieId(actualMovie.getMovieId());
        assertMoviesMatch(createdMovie, actualMovie);
    }

    @Test
    public void getAll_returns_all_movies() {
        // Arrange

        // Act
        List<Movie> allMovies = jdbcMovieDao.getAll();

        // Assert
        Assert.assertNotNull(allMovies);
        Assert.assertEquals(3, allMovies.size());
        assertMoviesMatch(MOVIE_1, allMovies.get(0));
        assertMoviesMatch(MOVIE_2, allMovies.get(1));
        assertMoviesMatch(MOVIE_3, allMovies.get(2));
    }

    @Test
    public void searchForMovieByNameOrOverview_returns_StarWars_and_Titanic_given_the() {
        // Arrange
        String searchString = "the";

        // Act
        List<Movie> moviesFound = jdbcMovieDao.searchForMovieByNameOrOverview(searchString);

        // Assert
        Assert.assertNotNull(moviesFound);
        Assert.assertEquals(2, moviesFound.size());
        assertMoviesMatch(MOVIE_1, moviesFound.get(0));
        assertMoviesMatch(MOVIE_3, moviesFound.get(1));
    }

    private void assertMoviesMatch(Movie createdMovie, Movie actualMovie) {
        Assert.assertEquals(createdMovie.getMovieId(), actualMovie.getMovieId());
        Assert.assertEquals(createdMovie.getTitle(), actualMovie.getTitle());
        Assert.assertEquals(createdMovie.getOverview(), actualMovie.getOverview());
        Assert.assertEquals(createdMovie.getTagline(), actualMovie.getTagline());
        Assert.assertEquals(createdMovie.getPosterPath(), actualMovie.getPosterPath());
        Assert.assertEquals(createdMovie.getHomePage(), actualMovie.getHomePage());
        Assert.assertEquals(createdMovie.getReleaseDate(), actualMovie.getReleaseDate());
        Assert.assertEquals(createdMovie.getLengthInMinutes(), actualMovie.getLengthInMinutes());
        Assert.assertEquals(createdMovie.getDirectorId(), actualMovie.getDirectorId());
        Assert.assertEquals(createdMovie.getCollectionId(), actualMovie.getCollectionId());
    }
}
