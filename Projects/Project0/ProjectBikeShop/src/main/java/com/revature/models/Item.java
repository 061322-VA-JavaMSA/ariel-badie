package com.revature.models;

import java.util.Objects;

public class Item {
	

	private int id;
	private String itemName;
	private String itemDesc;
	private int itemOffer;
	private int status;
	private int ownedBy;

	
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
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getItemOffer() {
		return itemOffer;
	}
	public void setItemOffer(int itemOffer) {
		this.itemOffer = itemOffer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(int ownedBy) {
		this.ownedBy = ownedBy;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(itemName, itemDesc, id, status, itemOffer);
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
		return Objects.equals(itemDesc, other.itemDesc) && Objects.equals(itemName, other.itemName)
				&& id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(itemOffer, other.itemOffer);
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + itemName + ", description=" + itemDesc + ", Minoffer=" + itemOffer + ", status= " + status + "]";
	}
	
}
