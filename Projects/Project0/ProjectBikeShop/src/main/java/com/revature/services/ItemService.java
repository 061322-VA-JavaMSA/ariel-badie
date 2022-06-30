package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ItemDAO;
import com.revature.daos.ItemPostgres;
import com.revature.models.Item;
import com.revature.models.User;

public class ItemService {
	private ItemDAO itdao = new ItemPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public List<Item> getItem(){
		return itdao.retrieveItem();
	}
	public List<Item> getItemOwned(int ownedBy) {
		return itdao.retrieveItemByOwnedId(ownedBy);
	}
	public Item createItem(Item i) {
		Item item = itdao.createItem(i);
		log.info("Item: " + item + " was created.");
		return item;
	}
	
public boolean deleteItemById(int id) {
		boolean itID = itdao.deleteItemById(id);
		log.info("Item ID: " + itID + " was deleted");
		return true;
	}
	

}
