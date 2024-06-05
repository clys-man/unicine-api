package edu.unifor.movieservice.service;

import edu.unifor.movieservice.entities.Movie;
import edu.unifor.movieservice.external.Session;
import edu.unifor.movieservice.external.consumer.SessionService;
import edu.unifor.movieservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final SessionService sessionService;

    public Iterable<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            movies.add(movie);
        }
        return movies;
    }

    public Movie saveMovie(Movie movie) {
        log.info("Saving movie details:: {}", movie);
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, Integer movieId) {
        Movie movieInDB = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movieInDB.setTitle(movie.getTitle());
        movieInDB.setSessions(movie.getSessions());
        movieRepository.save(movieInDB);
        log.info("Updating movie details:: {}", movie);
        return movie;
    }

    public Movie getMovieById(Integer movieId) {
        log.info("Retrieving movie details by ID: {}", movieId);
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie findMovieBySessionId(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("customer not found"));
        movie.setSessions(sessionService.getSessionList(movieId));
        log.info("Retrieving customers and account details:: {}", movie.getSessions());
        return movie;
    }

    public boolean deleteMovie(Integer movieId) {
        boolean isMovieExist = movieRepository.existsById(movieId);

        if (isMovieExist) {
            Movie movie = movieRepository.findById(movieId).get();
            movieRepository.delete(movie);
            log.info("Deleting movie by ID: {}", movieId);
            return true;
        }
        log.error("OH OH! Movie with ID {} can't be deleted", movieId);
        return false;
    }
}
