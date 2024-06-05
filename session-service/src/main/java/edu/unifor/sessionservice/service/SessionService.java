package edu.unifor.sessionservice.service;

import edu.unifor.sessionservice.entities.Session;
import edu.unifor.sessionservice.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SessionService {


    private final SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Session session) {
        Optional<Session> sessionInDB = sessionRepository.findById(session.getId());

        if (sessionInDB.isPresent()) {
            Session updatedSession = sessionInDB.get();
            updatedSession.setDateTime(session.getDateTime());
            updatedSession.setTicketPrice(session.getTicketPrice());
            return sessionRepository.save(updatedSession);
        } else {
            throw new RuntimeException("Session not found");
        }
    }

    public Session getSessionById(Integer sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public void deleteSession(Integer sessionId) {
        if (sessionRepository.existsById(sessionId)) {
            sessionRepository.deleteById(sessionId);
        } else {
            throw new RuntimeException("Session not found");
        }
    }
}
