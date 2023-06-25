package helpdesk.ticket.springboot.helpdeskrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import helpdesk.ticket.springboot.helpdeskmodel.Ticket;
@Repository

public interface TicketRepository extends JpaRepository<Ticket,Long>{
	public List<Ticket>findByStatus(String status);
	
}
