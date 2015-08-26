package com.tomar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tomar.constants.GlobalResources;
import com.tomar.hibernate.dto.UserInterface;
import com.tomar.hibernate.dto.impl.User;

public abstract class UserDAO {
	public static long addUser(UserInterface user) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		long id = (Long) session.save(user);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public static UserInterface authenticate(String username, String password) {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username=? and password=?");
		query.setString("username", username);
		query.setString("password", password);
		UserInterface user = (UserInterface) query.list().get(0);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	public static List<UserInterface> get() {
		Session session = GlobalResources.getHibernateSession();
		session.beginTransaction();
		List<UserInterface> users = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
}
