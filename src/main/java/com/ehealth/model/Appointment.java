package com.ehealth.model;

public class Appointment {

	private int appointmentId;
	
	private int patientId;
	private String patientName;
	private int doctorId;
	private String doctorName;
	private String date;
	public Appointment(int appointmentId, int patientId, String patientName, int doctorId ,String doctorName, String date) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.date = date;
		this.doctorName=doctorName;
		this.patientName=patientName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", patientName="
				+ patientName + ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", date=" + date + "]";
	}
	
		
}
