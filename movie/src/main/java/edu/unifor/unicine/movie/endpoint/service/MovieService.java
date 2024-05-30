package edu.unifor.unicine.movie.endpoint.service;

import edu.unifor.unicine.core.model.entity.Movie;
import edu.unifor.unicine.core.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Page<Movie> list(Pageable pageable) {
        log.info("pass here");
        return movieRepository.findAll(pageable);
    }

}
