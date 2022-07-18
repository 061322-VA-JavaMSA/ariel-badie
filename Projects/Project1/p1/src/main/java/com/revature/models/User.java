package com.revature.models;

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
@Table (name = "ers_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ers_users_id")
	private int id;
	@Column (name = "ers_username")
	private String username;
	@Column (name = "ers_password")
	private String password;
	@Column (name = "user_first_name")
	private String first_name;
	@Column (name = "user_last_name")
	private String last_name;
	@Column (name = "user_email")
	private String email;
	@ManyToOne
	@JoinColumn (name = "user_role_id")
	private Role role;
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}
	public String getLastname() {
		return last_name;
	}
	public void setLastname(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, first_name, id, last_name, password, role, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(last_name, other.last_name) && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + first_name
				+ ", lastname=" + last_name + ", email=" + email + ", role=" + role + "]";
	}
	
	

}
