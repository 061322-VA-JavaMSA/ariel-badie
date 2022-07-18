package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserHibernate implements UserDAO {

	@Override
	public User insertUser(User u) {
		u.setId(-1);
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		} catch (ConstraintViolationException e) {
			// log it
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User u = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			u = s.get(User.class, id);
		}

		return u;
	}

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			
			Predicate pUname = cb.equal(root.get("username"), username);
			cq.select(root).where(pUname);
			
			u = (User) s.createQuery(cq).getSingleResult();
		}

		return u;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			users = s.createQuery("from User", User.class).list();
		}

		return users;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean updateUser(User u) {
		boolean validate = false;
 		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction trans = s.beginTransaction();
			String passwordString = u.getPassword();			
		      	User user = getUserById(u.getId());
		      	user.setFirstname(u.getFirstname());
		      	user.setLastname(u.getLastname());
		      	user.setEmail(u.getEmail());
				if(passwordString != null && !passwordString.isEmpty()) {
					user.setPassword(passwordString);
			    }		      	
		      	s.update(user);
		      	trans.commit();
 		        s.close();	
 		       validate =  true;
		}
 		return validate;
	}

	@Override
	public List<User> getByRole(Role role) {
		List<User> users = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Query  query = s.createQuery("from User u where role = :role", User.class);
			query.setParameter("role", role );

			users = query.getResultList();
		}

		return users;
	}


}
