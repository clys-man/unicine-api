package edu.unifor.unicine.room.endpoint.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unifor.unicine.core.model.dto.RoomDTO;
import edu.unifor.unicine.core.model.entity.Room;
import edu.unifor.unicine.core.model.mapper.RoomMapper;
import edu.unifor.unicine.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

	private RoomRepository roomRepository;
	private RoomMapper mapper;
	
	public Page<RoomDTO> list(Pageable pageable){
		Page<RoomDTO> result = null;
		Page<Room> list = roomRepository.findAll(pageable);
		
		list.forEach(x -> { 
			result.toList().add(mapper.toDTO(x));
		});
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public RoomDTO getById(Long id) {
		Room entity = roomRepository.getById(id);
		
		if(entity != null)
			return mapper.toDTO(entity);
		
		return null;
	}
	
	public RoomDTO getByNumber(int number) {		
		Room entity = roomRepository.findByNumber(number);
		
		if(entity != null)
			return mapper.toDTO(entity);
		
		return null;
	}
	
	public List<RoomDTO> getByType(String type) {
		List<RoomDTO> result = null;
		List<Room> list = roomRepository.findByTypeContains(type);
		
		if(list.size() > 0) {
			list.forEach(x -> { result.add(mapper.toDTO(x)); });
		}		
		
		return result;
	}
	
	public List<RoomDTO> getByLocation(String location){
		List<RoomDTO> result = null;
		List<Room> list = roomRepository.findByLocationContains(location);
		
		if(list.size() > 0) {
			list.forEach(x -> { result.add(mapper.toDTO(x)); });
		}		
		
		return result;
	}
	
	public RoomDTO save(RoomDTO roomDTO) {
		Room room = mapper.toEntity(roomDTO);
		Room roomSaved = roomRepository.save(room);
		return mapper.toDTO(roomSaved);	
	}
}
