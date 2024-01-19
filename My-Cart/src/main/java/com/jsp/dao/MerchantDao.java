package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsp.entities.Merchant;

public class MerchantDao {
	private EntityManagerFactory factory;

	public MerchantDao(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public static void addMerchant(Merchant m) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(m);
		et.commit();
	}

	public Merchant getUserByEmailAndPassword(String email, String password) {
		Merchant merchant = null;
		try {
			// hql
			String query = "from Merchant where email =:e and password =: p";
			Session session = ((SessionFactory) this.factory).openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);

			merchant = (Merchant) q.uniqueResult();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchant;
	}
	// view

	public List<Merchant> data() {
		Merchant merchant = null;
		try {
			String hql = "FROM Merchant";
			Session session = ((SessionFactory) this.factory).openSession();
			Query q = session.createQuery(hql);
			List<Merchant> resultList = q.list();
			return resultList;
		} catch (Exception e) {
			return null;
		}
	}

	public static void updateStatus(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Merchant m = em.find(Merchant.class, id);
		m.setStatus("merchant");
		em.merge(m);
		et.commit();
	}
}
