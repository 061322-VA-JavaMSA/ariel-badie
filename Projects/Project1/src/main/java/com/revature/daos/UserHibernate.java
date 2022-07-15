package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserHibernate implements UserDAO {
	
	private static Logger log = LogManager.getLogger(UserHibernate.class);

	@Override
	public User insertUser(User u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			log.info("User: " + u + " was not inserted");
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(User.class, id);
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			// define entity to be searched
			Root<User> root = cq.from(User.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			user = (User) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}

	@Override
	public boolean updateUser(User u) {
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction trans = s.beginTransaction();

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<User> cu = cb.createCriteriaUpdate(User.class);
			Root<User> root  = cu.from(User.class);
			String passwordString = u.getPassword();
			
			cu.set(root.get("firstname"), u.getFirstName());
			cu.set(root.get("lastname"), u.getLastName());
			cu.set(root.get("email"), u.getEmail());
			
			if(passwordString != null && !passwordString.isEmpty()) {
				cu.set(root.get("password"), passwordString);
			}
			cu.where(cb.equal(root.get("id"),u.getId()));
 			rowsChanged =s.createQuery(cu).executeUpdate();
			if (rowsChanged < 1) {
				return false;
			}
		} catch(ConstraintViolationException e) {
			log.info("User: " + u + " was not updated");
		}
		return true;
	}

	@Override
	public User getUserbyRole(Role role) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(User.class, role);
		}
		
		return user;
	}

}
