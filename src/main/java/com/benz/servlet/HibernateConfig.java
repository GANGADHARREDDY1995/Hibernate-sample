package com.benz.servlet;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.benz.utils.Employee;

public class HibernateConfig {

	public static Session getHibernateconfig() {
		Configuration configuration = new Configuration()
				.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect")
				.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
				.setProperty("hibernate.connection.url", "jbdc:oracle:thin:@localhost:1521:xe")
				.setProperty("hibernate.connection.username", "practice")
				.setProperty("hibernate.connection.password", "varun").setProperty("hbm2ddl.auto", "update")
				.setProperty("show_sql", "true").addAnnotatedClass(Employee.class);

		Session session = configuration.configure().buildSessionFactory().openSession();
		System.out.println("Session: " + session);
		return session;
	}
}
