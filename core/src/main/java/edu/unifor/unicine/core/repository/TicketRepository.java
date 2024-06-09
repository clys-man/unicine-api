package edu.unifor.unicine.core.repository;

import edu.unifor.unicine.core.model.entity.Sale;
import edu.unifor.unicine.core.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.session.id = :sessionId AND t.acent.id = :acentId")
    public Ticket findBySession_IdAndAcent_Id(@Param("sessionId") Long sessionId, @Param("acentId") Long acentId);

    @Query("SELECT t.sale FROM Ticket t WHERE t.id = :ticketId")
    public Sale findSaleByTicketId(@Param("ticketId") Long ticketId);
}
