package com.ehealth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehealth.connection.GetConnection;
import com.ehealth.model.Admin;

public class AdminDAO {

	Connection con;
	
	public AdminDAO() {
		con = GetConnection.getConnection();
	}
	
	public boolean insertAdmin(Admin admin) {
		String query="insert into Admin values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, admin.getAdminId());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			
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
	
	public boolean deleteAdmin(int adminId) {
		
		String sql =" delete from Admin where adminId = ? ";
		
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, adminId);
			
			return ps.executeUpdate()>0;
			//executeUpdate() returns the no.of rows effected
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateAdmin(String fieldName, String newValue, int adminId) {
		
		String query="update Admin set "+ fieldName +" = ? where adminId="+adminId;
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(query);
			if(fieldName.equals("adminId"))
				ps.setInt(1, Integer.parseInt(newValue));
			else 
				ps.setString(1, newValue);
			return ps.executeUpdate()>0;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Admin getAdmin(String username, String password) {
		String query = "select * from Admin where username = ? and password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				return admin;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Admin> getAllAdmin()
	{
		String query = "select * from Admin";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Admin> adminList = new ArrayList<>();
			while (rs.next()) {
				
				Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				adminList.add(admin); 
				
			}
			return adminList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int validateAdmin(String username, String password){

		String userName = "";
		String query = "select userName,adminId from Admin where password = "+password;
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
}
