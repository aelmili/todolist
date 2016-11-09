package com.cs.todolist.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cs.todolist.entities.User;

/**
 * @author admformation
 * @version 1.0
 * @created 08-nov.-2016 15:23:46
 */

@Repository
public class UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void createUser(User user){
		entityManager.persist(user);
	}

	public User findUserByCredentials(String email, String password) {
		Query query = entityManager.createNamedQuery("findByCredentials");
		query.setParameter("email", email);
		query.setParameter("password", password);
		return (User) query.getSingleResult();
	}

	public User findUserById(int id) {
		Query query = entityManager.createNamedQuery("findById");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	public List<User> findAll(){
		Query query = entityManager.createNamedQuery("findAll");
		return query.getResultList();
	}
}//end UserDAO