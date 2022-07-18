package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "ers_user_roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ers_user_role_id")
	private int id;
	@Column (name = "user_role")
	private String user_role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return user_role;
	}
	public void setRole(String user_role) {
		this.user_role = user_role;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, user_role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return id == other.id && Objects.equals(user_role, other.user_role);
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + user_role + "]";
	}
	
	
	

}
