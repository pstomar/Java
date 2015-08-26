package com.tomar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tomar.constants.GlobalResources;
import com.tomar.hibernate.dto.CountryInterface;
import com.tomar.hibernate.dto.impl.Country;

public abstract class CountryDAO {
	public static List<CountryInterface> get(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
				
		//Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery("from Country");
		List<CountryInterface> countries = query.list();
		session.getTransaction().commit();
		session.close();
		return countries;
	}
	
	public static CountryInterface get(Integer id){
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		CountryInterface country = (Country) session.get(Country.class,id); 
		session.getTransaction().commit();
		session.close();
		return country;
	}
	
}