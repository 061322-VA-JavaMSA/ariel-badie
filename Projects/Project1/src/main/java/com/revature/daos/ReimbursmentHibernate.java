package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import com.revature.models.Reimbursment;
import com.revature.models.ReimbursmentStatus;
import com.revature.models.ReimbursmentType;
import com.revature.models.User;

import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class ReimbursmentHibernate implements ReimbursmentDAO{

	@Override
	public Reimbursment addReimbursment(Reimbursment reim) {
		reim.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(reim);
			reim.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//LOG THIS
		}
		return reim;
	}

	@Override
	public List<Reimbursment> getReimbursments() {
		List<Reimbursment> reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursement = s.createQuery("from Reimbursement ", Reimbursment.class).list();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursment> getByAuthor(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursment> getByStatus(ReimbursmentStatus rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursment getReimbursmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursment getReimbursementByStatus(String status) {
	
		return null;
	}

	@Override
	public boolean updateStatusByID(int id, User user, Reimbursment rs) {
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			System.out.println(id);
			System.out.println(user.toString());
			System.out.println(rs.toString());
			Transaction trans = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<Reimbursment> cu = cb.createCriteriaUpdate(Reimbursment.class);
			Root<Reimbursment> root  = cu.from(Reimbursment.class);
			
			String sql = "update reimbursement set resolver_id = :resolver_id, reimbursement_status_id = :reimbursement_status_id  where id = :id ;";
			NativeQuery<User> nq = s.createNativeQuery(sql, User.class);
			nq.setParameter("id", id);
			nq.setParameter("resolver_id", user.getId());
			nq.setParameter("reimbursement_status_id", rs.getId());
			rowsChanged = nq.executeUpdate();
			
			if (rowsChanged < 1) {
				return false;
			}
		}
		return true;	
	
	}
	

}
