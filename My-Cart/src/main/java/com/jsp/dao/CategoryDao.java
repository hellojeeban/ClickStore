package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsp.entities.Category;
import com.jsp.entities.Merchant;

public class CategoryDao {
	private EntityManagerFactory factory;

	public CategoryDao(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public static void addCategory(Category c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeeban");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
	}

	public List<Category> getCategories() {
		Category category = null;
		try {
			String hql = "FROM Category";
			Session session = ((SessionFactory) this.factory).openSession();
			Query q = session.createQuery(hql);
			List<Category> resultList = q.list();
			return resultList;
		} catch (Exception e) {
			return null;
		}
	}

	public Category getCategoryById(int id) {
		Category c = null;
		try {
		Session session = ((SessionFactory) this.factory).openSession();
		c = session.get(Category.class, id);
		session.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
}
