package com.ehealth.model;

public class Doctor {
	private int doctorId;
	private String username;
	private String password;
	private long phoneNumber;
	private String email;
	private String specialist;
	
	public Doctor(int doctorId, String username, String password, long phoneNumber, String email, String specialist) {
		super();
		this.doctorId = doctorId;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.specialist = specialist;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", username=" + username + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
}
