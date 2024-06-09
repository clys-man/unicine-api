package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Acent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcentRepository extends JpaRepository<Acent, Long> {
    Acent findByNumber(int seatNumber);
}
