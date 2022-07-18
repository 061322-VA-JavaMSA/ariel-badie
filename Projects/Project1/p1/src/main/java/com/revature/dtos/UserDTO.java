package com.revature.dtos;

import com.revature.models.Role;
import com.revature.models.User;

public class UserDTO {
	
	private int id;
	private String username;
	private String first_name;
	private String last_name;
	private Role role;
	
	public UserDTO(User u) {
		id = u.getId();
		username = u.getUsername();
		first_name =u.getFirstname();
		last_name = u.getLastname();
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}
