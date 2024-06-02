package edu.unifor.unicine.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifor.unicine.core.model.entity.Acent;

public interface AcentRepository extends JpaRepository<Acent, Long> {
	
	public Acent findByNumber(int number);
	
	
}
