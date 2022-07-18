package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "ers_reimbursement_type")
public class ReimbursementType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_type_id")
	private int id;
	@Column (name = "reimb_type")
	private String reimb_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return reimb_type;
	}
	public void setType(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, reimb_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		return id == other.id && Objects.equals(reimb_type, other.reimb_type);
	}
	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", type=" + reimb_type + "]";
	}
	
	
	

}
