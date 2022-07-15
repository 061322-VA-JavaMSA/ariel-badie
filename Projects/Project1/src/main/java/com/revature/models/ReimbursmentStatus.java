package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ers_reimburstment_status")
public class ReimbursmentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="reimb_status_id")
	private int id;
	@Column 
	private String reimb_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, reimb_status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursmentStatus other = (ReimbursmentStatus) obj;
		return id == other.id && Objects.equals(reimb_status, other.reimb_status);
	}
	@Override
	public String toString() {
		return "ReimbursmentStatus [id=" + id + ", reimb_status=" + reimb_status + "]";
	}
	
	
}
