package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Role;
import com.revature.models.User;

public class UserDTO {
	
	private int id;
	private String username;
	private Role role;
	private String firstname;
	private String lastname;
	private String email;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(User u) {
		id = u.getId();
		username = u.getUsername();
		firstname = u.getFirstName();
		lastname = u.getLastName();
		email = u.getEmail();
		role = u.getRole();
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
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		return Objects.hash(id, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return id == other.id && role == other.role && Objects.equals(username, other.username)
				&& Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(email, other.email);
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", firstname= " + firstname + ", lastname= " + lastname + ", email= " + email + ", role=" + role + "]";
	}
	
}
