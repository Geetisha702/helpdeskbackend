package helpdesk.ticket.springboot.helpdeskcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import helpdesk.ticket.springboot.helpdeskexception.ResourceNotFoundException;
import helpdesk.ticket.springboot.helpdeskmodel.Ticket;
import helpdesk.ticket.springboot.helpdeskrepository.TicketRepository;
import jakarta.validation.Valid;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	//get Ticket active
	@GetMapping("Tickets")

	public List<Ticket>getAllTickets()
	{return this.ticketRepository.findByStatus("active");}
	
	//get ticket inactive
	@GetMapping("Ticketss")
	public List<Ticket>getAllTicketss()
	{return this.ticketRepository.findByStatus("inactive");}
	
	//get Ticket by id
	@GetMapping("Tickets/{id}")
	public ResponseEntity<Ticket>getTicketById(@PathVariable(value="id")Long ticketId)
	throws ResourceNotFoundException
	{
		Ticket ticket= ticketRepository.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("ticket not found for this id::"+ticketId));
return ResponseEntity.ok().body(ticket);}
	
	//save Ticket or insert
	@PostMapping("/Tickets")
	public Ticket createTicket( @RequestBody Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}
	
	
	//update Ticket
	@PutMapping("Tickets/{id}")
	public ResponseEntity<Ticket>updateTicket(@PathVariable(value="id")Long ticketId, 
			@Valid @RequestBody Ticket ticketDetails)throws ResourceNotFoundException
	{
	Ticket ticket=ticketRepository.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("ticket not found for this id::"+ticketId));
	ticket.setEmpId(ticketDetails.getEmpId());
	ticket.setEmpName(ticketDetails.getEmpName());
	ticket.setTicketCate(ticket.getTicketCate());
	ticket.setTicketSubCate(ticket.getTicketSubCate());
	
	ticket.setTicketDesc(ticket.getTicketDesc());
	ticket.setStartDate(ticket.getStartDate());
	ticket.setEndDate(ticket.getEndDate());
	ticket.setPriority(ticket.getPriority());
	

	ticket.setStatus(ticket.getStatus());
	ticket.setRemark(ticket.getRemark());

	return ResponseEntity.ok(this.ticketRepository.save(ticket));
	
	}

}
