package com.ehealth.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ehealth.connection.GetConnection;
import com.ehealth.model.Appointment;
import com.ehealth.model.Doctor;

public class DoctorDAO {

	Connection con;
	
	public DoctorDAO() {
		con=GetConnection.getConnection();
	}
	
	public boolean insertDoctor(Doctor doctor) {
		String query="insert into Doctor values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctor.getDoctorId());
			ps.setString(2, doctor.getUsername());
			ps.setString(3, doctor.getPassword());
			ps.setLong(4, doctor.getPhoneNumber());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getSpecialist());
			
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
	
	public boolean deleteDoctor(int doctorId) {
		
		String sql ="delete from Doctor where doctorId = ?";
		
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, doctorId);
			
			return ps.executeUpdate()>0;
			//executeUpdate() returns the no.of rows effected
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateDoctor(String fieldName, String newValue, int doctorId) {
		
		String query="update Doctor set "+ fieldName +" = ? where doctorId="+doctorId;
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(query);
			if(fieldName.equals("doctorId"))
				ps.setInt(1, Integer.parseInt(newValue));
			else if(fieldName.equals("phoneNumber"))
				ps.setLong(1, Long.parseLong(newValue));
			else 
				ps.setString(1, newValue);
			return ps.executeUpdate()>0;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Doctor getDoctor(String username, String password) {
		String query = "select * from Doctor where username = ? and password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Doctor doctor = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),rs.getString(5), rs.getString(6));
				
				return doctor;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Doctor> getAllDoctors()
	{
		String query = "select * from Doctor";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Doctor> doctors = new ArrayList<>();
			while (rs.next()) {
				
				Doctor doctor = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),rs.getString(5),rs.getString(6));
				doctors.add(doctor); 
				
			}
			return doctors;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int validateDoctor(String username, String password){

		String userName = "";
		String query = "select userName,doctorId from Doctor where password = "+password;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {	
				userName = rs.getString(1);
				if(username.equals(userName))
					return rs.getInt(2);
				else 
					return -1;
			}
			else 
				return -1;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Doctor> getDoctorBySpecialization(String specialist){

		String query = "select * from Doctor where specialist = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, specialist);
			ResultSet rs = ps.executeQuery();
			List<Doctor> doctors = new ArrayList<>();
			while (rs.next()) {
				
				Doctor doctor = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6));
				doctors.add(doctor);
			}
			return doctors;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
