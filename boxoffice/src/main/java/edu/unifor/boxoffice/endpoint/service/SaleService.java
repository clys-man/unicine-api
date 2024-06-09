package edu.unifor.boxoffice.endpoint.service;

import edu.unifor.unicine.core.model.dto.SaleDTO;
import edu.unifor.unicine.core.model.entity.Sale;
import edu.unifor.unicine.core.model.mapper.SaleMapper;
import edu.unifor.unicine.core.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = saleMapper.toEntity(saleDTO);
        Sale savedSale = saleRepository.save(sale);
        return saleMapper.toDTO(savedSale);
    }

    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(saleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow();
        return saleMapper.toDTO(sale);
    }

    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        Sale sale = saleMapper.toEntity(saleDTO);
        sale.setId(id);
        Sale updatedSale = saleRepository.save(sale);
        return saleMapper.toDTO(updatedSale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
