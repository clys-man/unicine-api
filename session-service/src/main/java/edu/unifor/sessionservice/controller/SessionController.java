package edu.unifor.sessionservice.controller;

import edu.unifor.sessionservice.entities.Session;
import edu.unifor.sessionservice.service.SessionService;
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
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
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
    public ResponseEntity<Iterable<Session>> getSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
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
    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable("sessionId") Integer sessionId) {
        return ResponseEntity.ok(sessionService.getSessionById(sessionId));
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
    @PostMapping("/saveSession")
    public ResponseEntity<Session> saveSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.saveSession(session));
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
    @PutMapping("/updateSession")
    public ResponseEntity<Session> updateSessionDetails(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.updateSession(session));
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
    @DeleteMapping("/deleteSession/{sessionId}")
    public ResponseEntity<Map<String, Boolean>> deleteSessionById(@PathVariable("sessionId") Integer sessionId) {
        sessionService.deleteSession(sessionId);
        Map<String, Boolean> sessionDelete = new HashMap<>();
        sessionDelete.put("Deleted", true);
        return ResponseEntity.ok(sessionDelete);
    }
}
