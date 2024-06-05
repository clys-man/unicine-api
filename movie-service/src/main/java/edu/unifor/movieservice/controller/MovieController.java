package edu.unifor.movieservice.controller;

import edu.unifor.movieservice.entities.Movie;
import edu.unifor.movieservice.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Tag(name = "Restful APIs for managing movies",
        description = "GET, CREATE, UPDATE and DELETE movies information")
@Validated
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(
            method = "GET",
            summary = "API for requesting all customers",
            description = "This is a GET request for retrieving all the customers in DB"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status code for successfully retrieving customer details"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })

    @GetMapping("/")
    public ResponseEntity<Iterable<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }


    @Operation(
            method = "GET",
            summary = "API for requesting a single customer details",
            description = "This is a GET request for retrieving all the customers in DB"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status code for successfully retrieving a customer details"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") Integer movieId) {
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }


    @Operation(
            method = "POST",
            summary = "API for requesting creating new customer in DB",
            description = "This is a POST request saving customer details in DB"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP status code for successfully creating a customer details"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping("/saveMovie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }


    @Operation(
            method = "GET",
            summary = "API for requesting all customers based on accounts",
            description = "This is a GET request for retrieving all the accounts associated with customers in DB"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status code for successfully retrieving customer based on account details"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @GetMapping("/account/{sessionId}")
    public ResponseEntity<Movie> getMovieBySessionId(
            @PathVariable("sessionId") Integer sessionId) {
        return ResponseEntity.ok(movieService.findMovieBySessionId(sessionId));
    }



    @Operation(
            method = "PUT",
            summary = "API for updating customers details",
            description = "This is a PUT request for updating customers details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status code for successfully updating customers details"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PutMapping("/updateMovie")
    public ResponseEntity<Movie> updateMovieDetails(@RequestBody Movie movie, @RequestParam(value = "movieId") Integer movieId) {
        return ResponseEntity.ok(movieService.updateMovie(movie, movieId));
    }


    @Operation(
            method = "DELETE",
            summary = "API for deleting a customer details",
            description = "This is a GET request for deleting a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status code for successfully deleting a customer"
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Invalid HTTP Status for Method Not Allowed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Customer ID not found"
            )
    })
    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<Map<String, Boolean>> deleteMovieById(@PathVariable("movieId") Integer movieId) {
        boolean isDeleted = movieService.deleteMovie(movieId);
        Map<String, Boolean> movieDelete = new HashMap<>();
        movieDelete.put("Deleted", isDeleted);
        return ResponseEntity.ok(movieDelete);
    }
}
