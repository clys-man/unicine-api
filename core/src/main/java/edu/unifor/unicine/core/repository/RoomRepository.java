package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	public Room findByNumber(int number);
	
	public List<Room> findByTypeContains(String type);
	
	public List<Room> findByLocationContains(String location);
}
