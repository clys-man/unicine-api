package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s JOIN s.tickets t WHERE t.id = :ticketId")
    public Sale findByTicketId(@Param("ticketId") Long ticketId);

}
