package com.form.model.repository;

import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.form.controller.FormController;
import com.form.model.FormMV;
import com.form.model.FormVM;

import java.sql.Connection;
import java.sql.Statement;

@Repository
public class FormRepository {
	Connection connection;
	Statement statement;
	
	private static final Logger log = LoggerFactory.getLogger(FormController.class);


	public ArrayList<FormMV> getData()  {
		FormMV formMV = null;
		ArrayList<FormMV> list = new ArrayList<>();
		try {
			log.info("in getData");
			String query = "select * from EmpTable";
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?verifyServerCertificate=false&useSSL=true&", "root", "Rohit@developer");
			log.info("connection created");

			statement = connection.createStatement();
			log.info("statement initialized");

			ResultSet resultset = statement.executeQuery(query);
			log.info("sdfsd", resultset);
			log.info("in resultset");
			
			while (resultset.next()) {
				log.info("in while");
				formMV = new FormMV();
				formMV.setFirstName(resultset.getString("firstName"));
				formMV.setLastName(resultset.getString("lastName"));
				formMV.setEmailId(resultset.getString("emailId"));
				formMV.setPhoneNo(resultset.getString("phoneNo"));
				formMV.setPass(resultset.getString("pass"));
				formMV.setGender(resultset.getString("gender"));
				formMV.setEmpId(resultset.getString("empId"));
			}
			log.info("after while");
//			resultset.close();
			log.info("resultset closed");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				log.info("in finally in try");
				statement.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.info("before return");
		return list;

	}

	public FormMV saveData(FormVM formVM)  {
		int value;
		try {
			String query = "INSERT INTO EmpTable VALUES ('"
					+ formVM.getFirstName() + "','" 
					+ formVM.getLastName() + "','"
					+ formVM.getEmailId() + "','"
					+ formVM.getPhoneNo() + "','" 
					+ formVM.getPass() + "','" 
					+ formVM.getGender()+"','"
					+ formVM.getEmpId() + "');";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?verifyServerCertificate=false&useSSL=true&", "root", "Rohit@developer");
			statement = connection.createStatement();
			value = statement.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		FormMV formMV = new FormMV();
		formMV.setFirstName(formVM.getFirstName());
		formMV.setLastName(formVM.getLastName());
		formMV.setEmailId(formVM.getEmailId());
		formMV.setPhoneNo(formVM.getPhoneNo());
		formMV.setPass(formVM.getPass());
		formMV.setGender(formVM.getGender());
		formMV.setEmpId(formVM.getEmpId());

		return formMV;
	}

}