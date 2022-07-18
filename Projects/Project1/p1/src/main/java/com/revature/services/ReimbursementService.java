package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.daos.ReimbursementStatusDAO;
import com.revature.daos.ReimbursementStatusHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.ReimbursementStatusNotUpdatedException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;

public class ReimbursementService {
	
	private ReimbursementDAO rd = new ReimbursementHibernate();
	private ReimbursementStatusDAO rsh = new ReimbursementStatusHibernate();
	private UserDAO ud = new UserHibernate();

	public List<Reimbursement> getReimburse() {
		List<Reimbursement> reimburse = rd.getReimbursements();
		return reimburse;
	}
	
	public List<Reimbursement>  getByAuthor(User u) throws ReimbursementNotFoundException {
		List<Reimbursement> reimburse = rd.getReimbursementsByAuthor(u);
		return reimburse;
	}
	
	public Reimbursement insertReimbursement(Reimbursement r) throws ReimbursementNotCreatedException {
		Reimbursement reimburse =  rd.addReimbursement(r);
		return reimburse;
	}
	
	public Reimbursement getByID(int id) throws ReimbursementNotFoundException {
		Reimbursement reimburse =  rd.getById(id);
		if (reimburse == null) {
			throw new ReimbursementNotFoundException();
		}		
		return reimburse;
	}
	
	public boolean setStatusByID(int id, int user_id, String status_txt) throws ReimbursementStatusNotUpdatedException {
		ReimbursementStatus rs = rsh.getByName(status_txt);
		User user = ud.getUserById(user_id);
		 boolean checkUpdate = rd.setStatusById(id, user, rs);
		if (checkUpdate == false) {
			throw new ReimbursementStatusNotUpdatedException();
		}		 
		return checkUpdate;
	}
}
