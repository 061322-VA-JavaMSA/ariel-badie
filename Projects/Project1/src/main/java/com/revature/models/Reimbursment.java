package com.revature.models;

import java.util.Objects;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.revature.models.ReimbursmentStatus;
import com.revature.models.ReimbursmentType;
import com.revature.models.User;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_id")
	private int id;
	@Column (name = "reimb_amount")
	private int amount;
	@Column (name = "reimb_submitted")
	private Timestamp  submitted;
	@Column (name = "reimb_resolved")
 	private Timestamp  resolved;
	@Column (name = "reimb_description")
	private String description;
	@ManyToOne 
    @JoinColumn(name = "reimb_author")
	private User author;
	@ManyToOne
    @JoinColumn(name = "reimb_resolver")
	private User resolver;
	@ManyToOne 
	@JoinColumn(name = "reimb_status_id")	
	private ReimbursmentStatus  reimbursementStatus;
	@ManyToOne 
	@JoinColumn(name = "reim_type_id")
	private ReimbursmentType reimbursementType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public ReimbursmentStatus getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(ReimbursmentStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public ReimbursmentType getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(ReimbursmentType reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, reimbursementStatus, reimbursementType, resolved, resolver,
				submitted);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursment other = (Reimbursment) obj;
		return amount == other.amount && Objects.equals(author, other.author)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(reimbursementStatus, other.reimbursementStatus)
				&& Objects.equals(reimbursementType, other.reimbursementType)
				&& Objects.equals(resolved, other.resolved) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(submitted, other.submitted);
	}
	@Override
	public String toString() {
		return "Reimbursment [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", reimbursementStatus=" + reimbursementStatus + ", reimbursementType=" + reimbursementType + "]";
	}
	

}
