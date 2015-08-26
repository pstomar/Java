package com.tomar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tomar.constants.GlobalResources;
import com.tomar.hibernate.dto.CountryInterface;
import com.tomar.hibernate.dto.StateInterface;
import com.tomar.hibernate.dto.impl.Country;
import com.tomar.hibernate.dto.impl.State;;


public abstract class StateDAO {
	public static List<StateInterface> get() {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery("from State");
		List<StateInterface> states = query.list();
		session.getTransaction().commit();
		session.close();
		return states;
	}
	
	public static StateInterface get(Integer id) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		StateInterface state = (State) session.get(State.class, id);
		session.getTransaction().commit();
		session.close();
		return state;
	}
	public static List<StateInterface> getByCountryId(Integer countryId) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery("from State where country.id=?");
		query.setInteger(0, countryId);
		List<StateInterface> states = query.list();
		session.getTransaction().commit();
		return states;
	}
}
