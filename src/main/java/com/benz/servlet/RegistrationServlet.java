package com.benz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.benz.utils.Employee;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Calling Registration Servelt...........");
		String name = request.getParameter("name");
		String father = request.getParameter("fathe");
		String mother = request.getParameter("mother");
		long phoneNumber = Long.parseLong(request.getParameter("number"));
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		Employee employee = new Employee(name, father, mother, phoneNumber, address, gender);
		System.out.println("Employee: " + employee);
		Session session = HibernateConfig.getHibernateconfig();
		Transaction transaction = session.beginTransaction();
		System.out.println("Transaction: " + transaction);
		transaction.begin();
		session.save(employee);
		System.out.println("Employee saved...............");
		transaction.commit();
	}

}
