package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.models.User;
import com.revature.services.ItemService;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;



public class OfferPostgres implements OfferDAO {

	private static Logger log = LogManager.getLogger(ItemPostgres.class);
	
	@Override
	public Offer makeOffer(Offer o) {
		String sql = "insert into offers (custID, itemID, amount, status) values (?,?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getCustID());
			ps.setInt(2, o.getItemID());
			ps.setFloat(3, o.getAmount());
			ps.setInt(4, o.getStatus());
		
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				o.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public boolean acceptOffer(int id) {
		String sql = "update offers set status = '2' where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;

	}

	@Override
	public boolean rejectOffer(int id) {
		String sql = "update offers set status = '1' where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
	

	@Override
	public List<Offer> retrieveOffer() {
		String sql = "select * from offers inner join items on offers.itemID = items.id;";
		List<Offer> offer = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			// no user input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				// extract each field from rs for each record, map them to a User object and add them to the users arrayliost
				Offer o = new Offer();
				o.setId(rs.getInt("id"));
				o.setCustID(rs.getInt("custID"));
				o.setItemID(rs.getInt("itemID"));
				o.setAmount(rs.getFloat("amount"));
				o.setStatus(rs.getInt("status"));
				
				offer.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offer;
	}

}
