package com.ehealth.controller.appointments;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ehealth.dao.AppointmentDAO;
import com.ehealth.model.Appointment;

@WebServlet("/DeleteAppointmentController")
public class DeleteAppointmentController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AppointmentDAO aDao = new AppointmentDAO();
		String appointmentId = request.getParameter("appointmentId");
		if(appointmentId!=null)
			aDao.deleteAppointment(Integer.parseInt(appointmentId));
		List<Appointment> appointmentList = aDao.getAllAppointments(); 
		request.setAttribute("appointmentList",appointmentList);
		RequestDispatcher rq = request.getRequestDispatcher("./view/ShowAppointments.jsp");
		rq.forward(request, response);
	}

}
