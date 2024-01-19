package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsp.entities.UserEntity;


public class UserDao {
	private EntityManagerFactory factory;

	public UserDao(EntityManagerFactory factory) {
		this.factory = factory;
	}
// get user and Password
	public UserEntity getUserByEmailAndPassword(String email, String password) {
		UserEntity user = null;
		try {
			//hql
			String query = "from UserEntity where userEmail =:e and userPassword =: p";
			Session session =((SessionFactory) this.factory).openSession();
			 Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			
			user = (UserEntity)q.uniqueResult();
			
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	//add user
	public static void addEntity(UserEntity ue){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(ue);
		et.commit();
	}
}