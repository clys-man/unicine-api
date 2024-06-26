package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
