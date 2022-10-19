package com.ehealth.controller.appointments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehealth.dao.AppointmentDAO;
import com.ehealth.model.Appointment;
import com.ehealth.model.User;

@WebServlet("/MyAppointments")
public class MyAppointments extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AppointmentDAO aDao = new AppointmentDAO();
		User user = (User)request.getSession().getAttribute("user");
		Appointment appointment = aDao.getAppointment(user.getUserId());
		if(appointment==null)
			return;
		HttpSession session = request.getSession();
		session.setAttribute("appointment", appointment);
		response.sendRedirect("./view/ShowMyAppointments.jsp");
		
	}

}
