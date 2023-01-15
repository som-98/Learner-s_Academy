package com.cisco.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.cisco.entity.Classes;
import com.cisco.entity.LAStudents;

import com.cisco.entity.Subjects;
import com.cisco.entity.Teachers;


public class Hibernate2 {
private static SessionFactory sFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sFactory == null) {
			try {
				Configuration cfg = new Configuration();
				
				//hibernate setting equivalent to hibernate.cfg.xml file
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/somnath_server?useSSL=false");
				settings.put(Environment.USER, "root");
				
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				//set the above properties as configuration
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(Classes.class);
				cfg.addAnnotatedClass(LAStudents.class);
				cfg.addAnnotatedClass(Teachers.class);
				cfg.addAnnotatedClass(Subjects.class);
				
				ServiceRegistry servReg = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();
				sFactory = cfg.buildSessionFactory(servReg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sFactory;
	}

}
