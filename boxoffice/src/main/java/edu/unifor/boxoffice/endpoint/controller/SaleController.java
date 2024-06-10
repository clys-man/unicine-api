package edu.unifor.boxoffice.endpoint.controller;

import edu.unifor.unicine.core.model.dto.SaleDTO;
import edu.unifor.unicine.core.model.mapper.SaleMapper;
import edu.unifor.boxoffice.endpoint.services.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final SaleMapper saleMapper;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> list(Pageable pageable) {
        try {
            Page<SaleDTO> saleDTOPage = saleService.list(pageable)
                    .map(saleMapper::toDTO);
            log.info(saleDTOPage.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // log.error("Error fetching sales list", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        try {
            SaleDTO saleDTO = saleMapper.toDTO(saleService.getById(id));
            return new ResponseEntity<>(saleDTO, HttpStatus.OK);
        } catch (Exception e) {
            // log.error("Error fetching sale", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody SaleDTO saleDTO) {
        try {
            SaleDTO savedSale = saleMapper.toDTO(saleService.create(saleMapper.toEntity(saleDTO)));
            return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
        } catch (Exception e) {
            // log.error("Error creating sale", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> update(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        try {
            SaleDTO updatedSale = saleMapper.toDTO(saleService.update(id, saleMapper.toEntity(saleDTO)));
            return new ResponseEntity<>(updatedSale, HttpStatus.OK);
        } catch (Exception e) {
            // log.error("Error updating sale", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            saleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // log.error("Error deleting sale", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
