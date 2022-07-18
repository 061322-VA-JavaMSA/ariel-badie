package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;

public interface ReimbursementDAO {
	
	List<Reimbursement> getReimbursements();
	List<Reimbursement> getReimbursementsByAuthor(User u);
	Reimbursement addReimbursement (Reimbursement r);
	Reimbursement getById(int id);
	boolean setStatusById (int id, User resolver, ReimbursementStatus rs);
	
}
