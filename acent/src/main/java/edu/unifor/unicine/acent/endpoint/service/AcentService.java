package edu.unifor.unicine.acent.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unifor.unicine.core.model.dto.AcentDTO;
import edu.unifor.unicine.core.model.dto.AcentDTO;
import edu.unifor.unicine.core.model.entity.Acent;
import edu.unifor.unicine.core.model.entity.Acent;
import edu.unifor.unicine.core.model.mapper.AcentMapper;
import edu.unifor.unicine.core.repository.AcentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class AcentService {

	@Autowired
	private AcentRepository acentRepository;
	private AcentMapper mapper;
	
	public Page<AcentDTO> list(Pageable pageable){
		Page<AcentDTO> result = null;
		Page<Acent> list = acentRepository.findAll(pageable);
		
		list.forEach(x -> { 
			result.toList().add(mapper.toDTO(x));
		});
		
		return result;
	}
	
	public AcentDTO findByNumber(int number) {
		Acent acent = acentRepository.findByNumber(number);
		
		if(acent != null)
			return mapper.toDTO(acent);
		return null;
	}
	
	public String getStatus(int number) {
		Acent acent = acentRepository.findByNumber(number);
		
		if(acent != null)
			return acent.getStatus();
		return null;
	}
	
	public void reserv(int number) {
		// seria mudar o status , porem não sei quais os status e colocar provavel o id do usuario que ocupa, por hora voudeixar assim
		Acent acent = acentRepository.findByNumber(number);
		acent.setStatus("reserv");
		acentRepository.save(acent);
		
	}

	public void vacate(int number) {
		// seria mudar o status , porem não sei quais os status
		Acent acent = acentRepository.findByNumber(number);
		acent.setStatus("vacate");
		acentRepository.save(acent);
	}	
}
