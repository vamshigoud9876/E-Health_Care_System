package com.ehealth.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehealth.connection.GetConnection;
import com.ehealth.model.User;

public class UserDAO {
	
	Connection con;
	
	public UserDAO() {
		con=GetConnection.getConnection();
	}
	
	public boolean insertUser(User user) {
		String query="insert into User values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setLong(4, user.getPhoneNumber());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getUserAddress());
			
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
	
	public boolean deleteUser(int userId) {
		
		String sql ="delete from User where userId = ?";
		
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			
			return ps.executeUpdate()>0;
			//executeUpdate() returns the no.of rows effected
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUser(String fieldName, String newValue, int userId) {
		
		String query="update User set "+ fieldName +" = ? where userId="+userId;
		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement(query);
			if(fieldName.equals("userId"))
				ps.setInt(1, Integer.parseInt(newValue));
			else if(fieldName.equals("phoneNumber"))
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
	
	public User getUser(String username, String password) {
		String query = "select * from User where username = ? and password = ?" ;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6));
				
				return user;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
		
	public List<User> getAllUsers()
	{
		String query = "select * from User";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<>();
			while (rs.next()) {
				
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),rs.getString(5), rs.getString(6));
				users.add(user); 
				
			}
			return users;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}	

	public int validateUser(String username, String password){

		String userName = "";
		String query = "select userId from User where password = ? and username = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,password);
			ps.setString(2,username);
			ResultSet rs = ps.executeQuery();
              
			if(rs.next()) 
				return rs.getInt(1);
			else 
				return -1;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
}
