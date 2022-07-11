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
@Table(name="ers_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ers_username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "ers_password")
	private String password;
	
	@Column(name = "user_first_name")
	private String firstname;
	
	@Column(name = "user_last_name")
	private String lastname;
	
	@Column(name="user_email", nullable = false, unique = true)
	private String useremail;
	
	@ManyToOne
	@JoinColumn (name = "user_role_id")
	private Role role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return useremail;
	}

	public void setEmail(String useremail) {
		this.useremail = useremail;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, firstname, lastname, useremail, role);
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
		return id == other.id && Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(username, other.username) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(useremail, other.useremail);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname= " + firstname + ", lastname= " + lastname + ", email= " + useremail + ", role=" + role + "]";
	}

}
