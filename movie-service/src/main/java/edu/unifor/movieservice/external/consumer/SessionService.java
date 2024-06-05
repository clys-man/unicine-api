package edu.unifor.movieservice.external.consumer;

import edu.unifor.movieservice.external.Session;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "session-service")
public interface SessionService {

    @GetMapping("/api/v1/sessions/movie/{movieId}")
    List<Session> getSessionList(@PathVariable Integer movieId);

    @PutMapping("/api/v1/sessions/sessionDetails/{sessionId}")
    Session updateSessionDetails(
            @PathVariable("sessionId") Integer sessionId,
            @RequestParam("details") String details);

    @GetMapping("/{sessionId}")
    Session getSessionDetails(
            @PathVariable(value = "sessionId") Integer sessionId);

//    default void fallback(SessionNotFoundException a) {
//        throw new SessionNotFoundException(
//                "session service not accepting request",
//                HttpStatus.NOT_FOUND);
//    }
}