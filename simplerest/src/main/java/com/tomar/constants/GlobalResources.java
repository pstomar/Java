package com.tomar.constants;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GlobalResources {
	public static String CONTEXT_NAME = "simple";
	private static SessionFactory hibernateSessionFactory;
	
	public static Session getHibernateSession() {
		Session session = null;
		try {
			if(hibernateSessionFactory==null){
				Configuration configuration = new Configuration().configure();
				hibernateSessionFactory = configuration.buildSessionFactory();
			}
            session = hibernateSessionFactory.openSession();
		}catch(Exception e){
			return null;
		}
		return session;
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thinkingmachines","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
}
