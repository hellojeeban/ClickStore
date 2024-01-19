package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsp.entities.Product;

public class ProductDao {
	private EntityManagerFactory factory;

	public ProductDao(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public static void addProduct(Product d) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
	}

	public List<Product> getAllProduct() {
		Session session = ((SessionFactory) this.factory).openSession();
		Query<Product> q = session.createQuery("from Product");
		List<Product> li = q.getResultList();
		return li;
	}
}
