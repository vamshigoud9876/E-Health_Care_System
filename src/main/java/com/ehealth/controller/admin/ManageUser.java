package com.ehealth.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ehealth.dao.UserDAO;
import com.ehealth.model.User;

@WebServlet("/ManageUser")
public class ManageUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO uDao = new UserDAO();
		List<User> users = uDao.getAllUsers();
		request.setAttribute("users",users);
		RequestDispatcher rq = request.getRequestDispatcher("./view/ShowUsers.jsp");
		rq.forward(request, response);
	}

}
