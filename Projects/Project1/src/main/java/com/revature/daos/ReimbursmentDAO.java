package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursment;
import com.revature.models.ReimbursmentStatus;
import com.revature.models.ReimbursmentType;
import com.revature.models.User;

public interface ReimbursmentDAO {
	
	Reimbursment addReimbursment(Reimbursment reim);
	List<Reimbursment> getReimbursments();
	List<Reimbursment>  getByAuthor(User u);
	List<Reimbursment>  getByStatus(ReimbursmentStatus rs);
	Reimbursment getReimbursmentById(int id);
	Reimbursment getReimbursementByStatus(String status);
	boolean updateStatusByID(int id, User user, Reimbursment rs);

}
