package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="ers_reimbursment_type")
public class ReimbursmentType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimb_type_id")
	private int id;
	@Column(name = "reimb_type")
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursmentType other = (ReimbursmentType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "ReimbursmentType [id=" + id + ", type=" + type + "]";
	}
	
	
	
}
