package com.revature.daos;

import java.util.List;

import com.revature.models.Item;
import com.revature.models.Offer;

public interface OfferDAO {
	
	Offer makeOffer(Offer o);
	boolean acceptOffer(int id);
	boolean rejectOffer(int id);
	public List<Offer> retrieveOffer();
	

}
