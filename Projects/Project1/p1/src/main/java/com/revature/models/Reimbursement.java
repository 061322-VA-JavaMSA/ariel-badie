package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "ers_reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_id")
	private int id;
	@Column (name = "reimb_amount")
	private float amount;
	@Column (name = "reimb_sumbitted")
	private Timestamp submitted;
	@Column (name = "reimb_resolved")
	private Timestamp resolved;
	@Column (name = "reimb_description")
	private String description;
	@ManyToOne
	@JoinColumn (name = "reimb_author")
	private User author;
	@ManyToOne
	@JoinColumn (name = "reimb_resolver")
	private User resolver;
	@ManyToOne
	@JoinColumn (name = "reimb_status_id")
	private ReimbursementStatus reim_status;
	@ManyToOne
	@JoinColumn (name = "reimb_type_id")
	private ReimbursementType reim_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
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
	public ReimbursementStatus getReim_status() {
		return reim_status;
	}
	public void setReim_status(ReimbursementStatus reim_status) {
		this.reim_status = reim_status;
	}
	public ReimbursementType getReim_type() {
		return reim_type;
	}
	public void setReim_type(ReimbursementType reim_type) {
		this.reim_type = reim_type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, resolved, resolver, reim_status, submitted, reim_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount) && author == other.author
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(resolved, other.resolved) && resolver == other.resolver && reim_status == other.reim_status
				&& Objects.equals(submitted, other.submitted) && reim_type == other.reim_type;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + author + ", resolver=" + resolver + ", status="
				+ reim_status + ", type=" + reim_type + "]";
	}
	
	
	
	
	

}
