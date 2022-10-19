package com.ehealth.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ehealth.dao.UserDAO;
import com.ehealth.model.User;


@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO uDao = new UserDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		long phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String email = request.getParameter("email");
		String userAddress = request.getParameter("userAddress");
		User user = new User(0, username, password, phoneNumber, email, userAddress);
		if(!uDao.insertUser(user))
			System.out.print("Not Inserted..");
		response.sendRedirect("index.jsp");
	}

}
