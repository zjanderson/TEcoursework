package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Movie create(Movie movie) {
        String sql = "" +
                "INSERT INTO movie " +
                "(title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING movie_id;";

        Integer newMovieId = jdbcTemplate.queryForObject(sql, Integer.class,
                movie.getTitle(),
                movie.getOverview(),
                movie.getTagline(),
                movie.getPosterPath(),
                movie.getHomePage(),
                movie.getReleaseDate(),
                movie.getLengthInMinutes(),
                movie.getDirectorId(),
                movie.getCollectionId());

        if (newMovieId == null) {
            return null;
        }

        return getById(newMovieId);
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movie ORDER BY movie_id;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            Movie movie = mapRowToMovie(rowSet);
            movies.add(movie);
        }

        return movies;
    }

    @Override
    public Movie getById(int movieId) {
        Movie movie = null;

        String sql = "SELECT * FROM movie WHERE movie_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, movieId);

        if (rowSet.next()) {
            movie = mapRowToMovie(rowSet);
        }

        return movie;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(int movieId) {

    }

    @Override
    public List<Movie> getMoviesWithRuntimeLessThan(int runtime) {
        return null;
    }

    @Override
    public List<Movie> getMoviesWithActor(int actorId) {
        return null;
    }

    @Override
    public List<Movie> searchForMovieByNameOrOverview(String searchString) {
        List<Movie> movies = new ArrayList<>();

        String sql = "" +
                "SELECT * " +
                "FROM movie " +
                "WHERE (title ILIKE ? OR overview ILIKE ?) " +
                "ORDER BY movie_id;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,
                "%" + searchString + "%",
                "%" + searchString + "%");

        while (rowSet.next()) {
            Movie movie = mapRowToMovie(rowSet);
            movies.add(movie);
        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesOfGenre(int genreId) {
        return null;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();

        int movieId = rowSet.getInt("movie_id");
        String title = rowSet.getString("title");
        String overview = rowSet.getString("overview");
        String tagline = rowSet.getString("tagline");
        String posterPath = rowSet.getString("poster_path");
        String homePage = rowSet.getString("home_page");
        Date releaseDate = rowSet.getDate("release_date");
        int lengthInMinutes = rowSet.getInt("length_minutes");
        int directorId = rowSet.getInt("director_id");
        int collectionId = rowSet.getInt("collection_id");

        movie.setMovieId(movieId);
        movie.setTitle(title);
        movie.setOverview(overview);
        movie.setTagline(tagline);
        movie.setPosterPath(posterPath);
        movie.setHomePage(homePage);

        if (releaseDate != null) {
            movie.setReleaseDate(releaseDate.toLocalDate());
        }

        movie.setLengthInMinutes(lengthInMinutes);
        movie.setDirectorId(directorId);
        movie.setCollectionId(collectionId);

        return movie;
    }

}
