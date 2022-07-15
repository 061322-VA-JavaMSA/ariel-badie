package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursmentDAO;
import com.revature.daos.ReimbursmentHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.ReimbursementStatusNotUpdatedException;
import com.revature.exceptions.ReimbursmentNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursment;
import com.revature.models.User;


public class ReimbursmentService {
	
	private ReimbursmentDAO rd = new ReimbursmentHibernate();
	private UserDAO ud = new UserHibernate();
	
	public Reimbursment createReimbursement(Reimbursment r) throws ReimbursmentNotCreatedException {
		
		Reimbursment newReimbursement = rd.addReimbursment(r);
		return newReimbursement;
		
	}
	public List<Reimbursment> getReimbursments() {
		List<Reimbursment> reimbursements = rd.getReimbursments();
		return reimbursements;
	}
	
	public Reimbursment getReimbursmentById(int id) throws UserNotFoundException {
		Reimbursment r = rd.getReimbursmentById(id);
		if (r == null) {
			throw new UserNotFoundException();
		}
			
		return r;
	}
	public Reimbursment getReimbursementStatusById(int id) {
		Reimbursment status = rd.getReimbursmentById(id);
		return status;
	}

	public boolean updateStatusByID(int id, int user_id, String status) throws ReimbursementStatusNotUpdatedException {
 		Reimbursment rs = rd.getReimbursementByStatus(status);
 		User user = ud.getUserById(user_id);
		boolean checkUpdate = rd.updateStatusByID(id, user, rs);
		if (checkUpdate == false) {
			throw new ReimbursementStatusNotUpdatedException();
		}		 
		return checkUpdate;
	}
	

}
