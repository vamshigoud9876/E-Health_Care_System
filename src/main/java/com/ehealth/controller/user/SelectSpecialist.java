package com.ehealth.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ehealth.dao.DoctorDAO;
import com.ehealth.model.Doctor;

@WebServlet("/SelectSpecialist")
public class SelectSpecialist extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String specialist = request.getParameter("specialist");
		DoctorDAO dDao = new DoctorDAO();
		List<Doctor> doctors = dDao.getDoctorBySpecialization(specialist);
		request.setAttribute("doctors", doctors);
		request.setAttribute("specialist", specialist);
		RequestDispatcher rq = request.getRequestDispatcher("./view/ShowBookAppointment.jsp");
		rq.forward(request, response);
	}
}
