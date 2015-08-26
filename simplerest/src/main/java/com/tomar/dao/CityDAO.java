package com.tomar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tomar.constants.GlobalResources;
import com.tomar.constants.Queries;
import com.tomar.hibernate.dto.CityInteface;
import com.tomar.hibernate.dto.impl.City;

public abstract class CityDAO {
	
	public static List<CityInteface> get(){
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery(Queries.City.get());
		List<CityInteface> cities = query.list();
		session.getTransaction().commit();
		session.close();
		return cities;
	}
	
	public static CityInteface get(Integer id) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		CityInteface city = (CityInteface) session.get(City.class, id);
		session.getTransaction().commit();
		session.close();
		return city;
	}
	
	public static  List<CityInteface> getByStateId(Integer stateId) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery("from City where state.id=?");
		query.setInteger(0, stateId);
		List<CityInteface> cities = query.list();
		session.getTransaction().commit();
		session.close();
		return cities;
	}

}
