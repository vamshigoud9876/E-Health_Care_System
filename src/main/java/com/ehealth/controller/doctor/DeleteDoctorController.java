package com.ehealth.controller.doctor;

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

@WebServlet("/DeleteDoctorController")
public class DeleteDoctorController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDAO dDao = new DoctorDAO();
		String doctorId = request.getParameter("doctorId");
		if(doctorId!=null)
			dDao.deleteDoctor(Integer.parseInt(doctorId));
		List<Doctor> doctors = dDao.getAllDoctors();
		request.setAttribute("doctors",doctors);
		RequestDispatcher rq = request.getRequestDispatcher("./view/ShowDoctors.jsp");
		rq.forward(request, response);
	}

}
