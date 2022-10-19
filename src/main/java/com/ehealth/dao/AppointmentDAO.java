package com.ehealth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehealth.connection.GetConnection;
import com.ehealth.model.Appointment;

public class AppointmentDAO {

	Connection con;
	
	public AppointmentDAO() {
		con = GetConnection.getConnection();
	}
	
	public boolean insertAppointment(Appointment appointment) {
		String query="insert into Appointment values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, appointment.getPatientId());
			ps.setInt(3, appointment.getDoctorId());
			ps.setString(4, appointment.getDate());
			
			return ps.executeUpdate()>0;
		   //executeUpdate() returns the no.of rows effected
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAppointment(int appointmentId) {
		
		String sql =" delete from Appointment where appointmentId = ? ";
		
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, appointmentId);
			
			return ps.executeUpdate()>0;
			//executeUpdate() returns the no.of rows effected
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Appointment getAppointment(int userId) {
		
		String query = "select * from Appointment where userId = "+userId;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int appointmentId = rs.getInt(1);
				 int patientId =  rs.getInt(2);
				 String patientName = getPatientName(patientId);
				 int doctorId = rs.getInt(3);
				 String doctorName = getDoctorName(doctorId);
				 String date = rs.getString(4); 
				 
				Appointment appointment = new Appointment(appointmentId, patientId, patientName, doctorId, doctorName, date);
				return appointment;
			}
		}
		catch(SQLException e){
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPatientName(int patientId){
		String query = "select username from User where userId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String patientName = rs.getString(1);
				return patientName;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}
	
	public String getDoctorName(int doctorId){
		String query = "select username from Doctor where doctorId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String doctorName = rs.getString(1);
				return doctorName;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}
	
	public List<Appointment> getAllAppointments()
	{
		String query = "select * from Appointment";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Appointment> appointmentList = new ArrayList<>();
			while (rs.next()) {
				
				 int appointmentId = rs.getInt(1);
				 int patientId =  rs.getInt(2);
				 String patientName = getPatientName(patientId);
				 int doctorId = rs.getInt(3);
				 String doctorName = getDoctorName(doctorId);
				 String date = rs.getString(4); 
				Appointment appointment = new Appointment(appointmentId, patientId, patientName, doctorId, doctorName, date);
				appointmentList.add(appointment); 
		
				
			}
			return appointmentList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Appointment> getAppointmentsById(int doctorId)
	{
		String query = "select * from Appointment where doctorId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			List<Appointment> appointmentList = new ArrayList<>();
			while (rs.next()) {
				
				int appointmentId = rs.getInt(1);
				int patientId =  rs.getInt(2);
				String patientName = getPatientName(patientId);
				int doctorID = rs.getInt(3);
				String doctorName = getDoctorName(doctorID);
				String date = rs.getString(4); 
				Appointment appointment = new Appointment(appointmentId, patientId, patientName, doctorID, doctorName, date);
				appointmentList.add(appointment); 
			}
			return appointmentList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
