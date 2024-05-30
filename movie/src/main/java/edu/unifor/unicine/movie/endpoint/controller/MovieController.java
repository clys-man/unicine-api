package edu.unifor.unicine.movie.endpoint.controller;

import edu.unifor.unicine.core.model.dto.MovieDTO;
import edu.unifor.unicine.core.model.mapper.MovieMapper;
import edu.unifor.unicine.movie.endpoint.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<MovieDTO>> list(Pageable pageable) {
        Page<MovieDTO> movieDTOPage = movieService.list(pageable)
                .map(movieMapper::toDTO);
        return new ResponseEntity<>(movieDTOPage, HttpStatus.OK);
    }
}
