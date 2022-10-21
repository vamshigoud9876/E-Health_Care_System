package com.ehealth.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ExceptionHandler")

public class ExceptionHandler extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
			
		RequestDispatcher rd = request.getRequestDispatcher("./view/ErrorPage.jsp");
		rd.forward(request, response);
	}
}
