package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementHibernate implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			reimbursements = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsByAuthor(User u) {
		List<Reimbursement> reimbursements = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			// define entity to be searched
			Root<Reimbursement> root = cq.from(Reimbursement.class);

			// define conditions
			Predicate predicateForReimbursementname = cb.equal(root.get("author"), u);

			cq.select(root).where(predicateForReimbursementname);
			cq.orderBy(cb.asc(root.get("id")));

			reimbursements = (List<Reimbursement>) s.createQuery(cq).getResultList();
		}

		return reimbursements;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
		r.setId(-1);
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setId(id);
			tx.commit();
		} catch (ConstraintViolationException e) {
			// log it
		}
		return r;
	}

	@Override
	public Reimbursement getById(int id) {
		Reimbursement reimb = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			reimb = s.get(Reimbursement.class, id);
		}

		return reimb;
	}

	@Override
	public boolean setStatusById(int id, User resolver, ReimbursementStatus status) {
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction trans = s.beginTransaction();

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<Reimbursement> cu = cb.createCriteriaUpdate(Reimbursement.class);
			Root<Reimbursement> root = cu.from(Reimbursement.class);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			cu.set(root.get("reim_status"), status);
			cu.set(root.get("resolver"), resolver);
			cu.set(root.get("resolved"), ts);
			cu.where(cb.equal(root.get("id"), id));
			rowsChanged = s.createQuery(cu).executeUpdate();

			if (rowsChanged < 1) {
				return false;
			}
		}
		return true;
	}

}
