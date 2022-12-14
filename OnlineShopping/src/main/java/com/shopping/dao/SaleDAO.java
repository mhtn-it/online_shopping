package com.shopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.shopping.model.Sale;
import com.shopping.util.HibernateUtil;

@Component
@SuppressWarnings({ "unchecked", "deprecation" })
public class SaleDAO {
	SessionFactory sessionFactory;
	Criteria criteria = null;

	public SaleDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public List<Sale> findAll() {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(Sale.class);
			return criteria.list();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public void insert(Sale sale) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(sale);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public Sale find(Long id) {
		Sale sale = null;
		try {
			Session session = sessionFactory.openSession();
			sale = (Sale) session.get(Sale.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return sale;
	}

	public void update(Sale sale) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(sale);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public void delete(Sale sale) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(sale);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

}
