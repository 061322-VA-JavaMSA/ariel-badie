package com.revature.models;

import java.time.LocalDate;
import java.util.Objects;

public class Item {
	
	private int id;
	private String description;
	private LocalDate addDate;
	private String status;
	private User userAdded;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUserAdded() {
		return userAdded;
	}
	public void setUserAdded(User userAdded) {
		this.userAdded = userAdded;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, addDate, id, status, userAdded);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(description, other.description) && Objects.equals(addDate, other.addDate)
				&& id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(userAdded, other.userAdded);
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", addDate=" + addDate + ", status=" + status
				+ ", userAdedd=" + userAdded + "]";
	}

}
