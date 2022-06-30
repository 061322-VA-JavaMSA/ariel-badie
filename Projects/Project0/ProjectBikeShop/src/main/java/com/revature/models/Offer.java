package com.revature.models;

import java.util.Objects;

public class Offer {
	
	private int id;
	private int custID;
	private int itemID;
	private float amount;
	private int status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(custID, itemID, id, status, amount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return Objects.equals(custID, other.custID) && Objects.equals(itemID, other.itemID)
				&& id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(amount, other.amount);
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", byCustomerID=" + custID + ", forItemID=" + itemID + ", offer=" + amount + ", status= " + status + "]";
	}

}
