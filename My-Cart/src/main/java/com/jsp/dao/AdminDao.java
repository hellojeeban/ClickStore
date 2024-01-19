package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsp.entities.Admin;


public class AdminDao {
	private EntityManagerFactory factory;

	public AdminDao(EntityManagerFactory factory) {
		this.factory = factory;
	}
// get user and Password
	public Admin getUserByEmailAndPassword(String email, String password) {
		Admin admin = null;
		try {
			//hql
			String query = "from Admin where userEmail =:e and userPassword =: p";
			Session session =((SessionFactory) this.factory).openSession();
			 Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			
			admin = (Admin)q.uniqueResult();
			
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	//add user
	public static void addAdmin(Admin a){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
	}
}
