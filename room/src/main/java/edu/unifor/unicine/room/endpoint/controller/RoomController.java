package edu.unifor.unicine.room.endpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifor.unicine.core.model.dto.RoomDTO;
import edu.unifor.unicine.room.endpoint.service.RoomService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	 @GetMapping(path = "/all")
	    public ResponseEntity<Iterable<RoomDTO>> list(Pageable pageable) {
	        Page<RoomDTO> roomDTOPage = roomService.list(pageable);
	        return new ResponseEntity<>(roomDTOPage, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/get/{id}")
	    public ResponseEntity<RoomDTO> getById(@PathVariable Long id) {
		    RoomDTO result = roomService.getById(id);		 
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/number/{number}")
	    public ResponseEntity<RoomDTO> getByNumber(@PathVariable int number) {
		    RoomDTO result = roomService.getByNumber(number);		 
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/type/{type}")
	    public ResponseEntity<List<RoomDTO>> getByType(@PathVariable String type) {
		   List<RoomDTO> result = roomService.getByType(type);		 
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/location/{location}")
	    public ResponseEntity<List<RoomDTO>> getByLocation(@PathVariable String location) {
		   List<RoomDTO> result = roomService.getByLocation(location);		 
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 
	 @PostMapping(path = "/save")
	    public ResponseEntity<RoomDTO> save(@RequestBody RoomDTO room) {
		    RoomDTO result = roomService.save(room);	 
	        return new ResponseEntity<>(result, HttpStatus.CREATED);
	    }
}
