package com.benz.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.benz.utils.Employee;

public class FetchingDataFromDatabase {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		Session session = configuration.configure().buildSessionFactory().openSession();
       		Connection connection=session.connection();
       		System.out.println("connecton    :"+connection);
       		try {
			PreparedStatement statement=connection.prepareStatement("select * from EMPLOYEEFORM");
			System.out.println("prepared statement   :"+statement);
			ResultSet set=statement.getResultSet();
			System.out.println("result set    :"+set);
			while(set.next()){
				System.out.println(set.getInt(1));
				System.out.println(set.getString(2));
				System.out.println(set.getString(3));
				System.out.println(set.getString(4));
				System.out.print(set.getLong(5));
				System.out.println(set.getString(6));
				System.out.println(set.getString(7));
				Employee employee = new  Employee(set.getString(2), set.getString(3), set.getString(4), set.getLong(5), set.getString(6), set.getString(7));
				System.out.println(employee.getName());
			}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       		try {
				connection.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
