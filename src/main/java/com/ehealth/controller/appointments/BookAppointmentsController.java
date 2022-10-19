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
import com.ehealth.model.Doctor;
import com.ehealth.model.User;


@WebServlet("/BookAppointmentsController")
public class BookAppointmentsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppointmentDAO aDao = new AppointmentDAO();
		
		HttpSession session=request.getSession(); 
        User user = (User)session.getAttribute("user"); 

		Appointment appointment =  new Appointment(0, user.getUserId(), user.getUsername(), Integer.parseInt(request.getParameter("dId")),
				request.getParameter("dName") , request.getParameter("date"));
//		response.getWriter().print("<h1 align=center >Booking Successful</h1>");
		aDao.insertAppointment(appointment);
		response.sendRedirect("./view/BookingSuccessPage.jsp");
		
		
	}

}
