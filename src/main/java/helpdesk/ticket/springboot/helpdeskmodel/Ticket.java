package helpdesk.ticket.springboot.helpdeskmodel; 





import java.sql.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Tickets")

public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long ticketId;
	@Column(name="emp_id")
	private long empId;
	@Column(name="emp_name")
	private String empName;
	@Column(name="ticket_cate")
	private String ticketCate;
	@Column(name="sub_cate")
	private String ticketSubCate;
	@Column(name="ticket_desc")
	private String ticketDesc;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private  Date endDate;
	@Column(name="priority")
	private String priority;
	@Column(name="status" )
	private String status="active";
	@Column(name="remarks")
	private String remark;

	public Ticket() {
		super();
	}
	public Ticket(long empId, String empName, String ticketCate, String ticketSubCate, String ticketDesc,
			Date startDate, Date endDate, String priority, String status, String remark) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.ticketCate = ticketCate;
		this.ticketSubCate = ticketSubCate;
		this.ticketDesc = ticketDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.remark = remark;
	}
	
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTicketCate() {
		return ticketCate;
	}
	public void setTicketCate(String ticketCate) {
		this.ticketCate = ticketCate;
	}
	public String getTicketSubCate() {
		return ticketSubCate;
	}
	public void setTicketSubCate(String ticketSubCate) {
		this.ticketSubCate = ticketSubCate;
	}
	public String getTicketDesc() {
		return ticketDesc;
	}
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public  Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}


