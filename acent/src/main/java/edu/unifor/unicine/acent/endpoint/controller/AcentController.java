package edu.unifor.unicine.acent.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifor.unicine.acent.endpoint.service.AcentService;
import edu.unifor.unicine.core.model.dto.AcentDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("acents")
@RequiredArgsConstructor
public class AcentController {

	@Autowired
	private AcentService acentService;
	
	 @GetMapping(path = "/all")
	    public ResponseEntity<Iterable<AcentDTO>> list(Pageable pageable) {
	        Page<AcentDTO> acentDTOPage = acentService.list(pageable);
	        return new ResponseEntity<>(acentDTOPage, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/number/{number}")
	    public ResponseEntity<AcentDTO> getByNumber(@PathVariable int number) {
		 	AcentDTO result = acentService.findByNumber(number);		 
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/status/{number}")
	    public ResponseEntity<String> getStatus(@PathVariable int number) {
		 	String status= acentService.getStatus(number);		 
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }
	 
	 @PutMapping(path = "/reserv/{number}")
	    public ResponseEntity<?> reservAcent(@PathVariable int number) {
		 	acentService.reserv(number);		 
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 @PutMapping(path = "/vacate/{number}")
	    public ResponseEntity<?> vacateAcent(@PathVariable int number) {
		 	acentService.vacate(number);		 
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
