package com.revature.daos;

import java.util.List;
import com.revature.models.Item;

public interface ItemDAO {

	Item createItem(Item i);
	List<Item> retrieveItem();
	Item retrieveItemById(int id);
	List<Item> retrieveItemByUserId(int id);
	boolean updateItem(Item t);
	boolean deleteItemById(int id);
}
