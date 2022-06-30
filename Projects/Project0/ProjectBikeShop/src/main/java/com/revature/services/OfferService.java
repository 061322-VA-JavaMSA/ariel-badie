package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ItemDAO;
import com.revature.daos.ItemPostgres;
import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.models.User;

public class OfferService {
	private OfferPostgres ofdao = new OfferPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);

	
	public Offer makeOffer(Offer o) {
		Offer offer = ofdao.makeOffer(o);
		log.info("Offer:" + offer + " was created.");
		return offer;
	}
	
	public boolean acceptOffer(int id) {
		return false;
		
	}
	
	public List<Offer> getOffer(){
		return ofdao.retrieveOffer();
	}
}
