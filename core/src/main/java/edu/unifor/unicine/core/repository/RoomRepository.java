package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	public Room findByNumber(int numer);
	
	public List<Room> findByTypeContains(String type);
	
	public List<Room> findByLocationContains(String location);
}
