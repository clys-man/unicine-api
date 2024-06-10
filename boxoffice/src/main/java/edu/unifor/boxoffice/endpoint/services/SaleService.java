package edu.unifor.boxoffice.endpoint.services;

import edu.unifor.unicine.core.model.entity.Sale;
import edu.unifor.unicine.core.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public Page<Sale> list(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public Sale getById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    public Sale create(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale update(Long id, Sale sale) {
        Sale existingSale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        existingSale.setCode(sale.getCode());
        existingSale.setDateTime(sale.getDateTime());
        existingSale.setTotalPrice(sale.getTotalPrice());
        existingSale.setTickets(sale.getTickets());
        return saleRepository.save(existingSale);
    }

    public void delete(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        saleRepository.delete(sale);
    }
}
