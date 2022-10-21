package com.ehealth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehealth.dao.AdminDAO;
import com.ehealth.dao.DoctorDAO;
import com.ehealth.dao.UserDAO;
import com.ehealth.dao.ValidateDAO;
import com.ehealth.model.Admin;
import com.ehealth.model.Doctor;
import com.ehealth.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname").toString();
		String password =  request.getParameter("pass").toString();
		HttpSession session = request.getSession();
		session.setAttribute("adminUsername", username);
		ValidateDAO val = new ValidateDAO(username, password);
		
		String person = val.validate();
		if(person!=null){
			
			if(person.equals("User")) {
				
				UserDAO uDao = new UserDAO();
				User user = uDao.getUser(username, password); 
		        session.setAttribute("user",user);
				response.sendRedirect("./view/UserHome.jsp");
			}
			
			else if(person.equals("Admin"))
			{
				AdminDAO aDao = new AdminDAO();
				Admin admin = aDao.getAdmin(username, password); 
		        session.setAttribute("admin",admin);
				response.sendRedirect("./view/AdminHome.jsp");
			}
			
			else if(person.equals("Doctor")) {
				DoctorDAO dDao = new DoctorDAO();
				Doctor doctor = dDao.getDoctor(username, password);
				System.out.print(doctor); 
		        session.setAttribute("doctor",doctor);
				response.sendRedirect("./view/DoctorHome.jsp");
			}
		}
		else 
			response.sendRedirect("index.jsp");
		
	}

}
