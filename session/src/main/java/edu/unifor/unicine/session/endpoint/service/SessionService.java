package edu.unifor.unicine.session.endpoint.service;

import edu.unifor.unicine.core.model.dto.SessionDTO;
import edu.unifor.unicine.core.model.entity.Session;
import edu.unifor.unicine.core.model.mapper.SessionMapper;
import edu.unifor.unicine.core.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public SessionService(SessionRepository sessionRepository, SessionMapper sessionMapper) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    public SessionDTO createSession(SessionDTO sessionDTO) {
        Session session = sessionMapper.toEntity(sessionDTO);
        Session savedSession = sessionRepository.save(session);
        return sessionMapper.toDTO(savedSession);
    }

    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll().stream()
                .map(sessionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SessionDTO getSessionById(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow();
        return sessionMapper.toDTO(session);
    }

    public SessionDTO updateSession(Long id, SessionDTO sessionDTO) {
        Session session = sessionMapper.toEntity(sessionDTO);
        session.setId(id);
        Session updatedSession = sessionRepository.save(session);
        return sessionMapper.toDTO(updatedSession);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}