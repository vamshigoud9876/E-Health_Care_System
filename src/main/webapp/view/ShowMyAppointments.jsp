<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,com.ehealth.model.Appointment" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style>
body{
	background-image : url("../images/login_background.jpg");
	background-repeat : no-repeat; 	
	background-size : cover;
}	
table, tr ,td	 {
    border: 1px inset black;
    border-collapse: collapse;
    border-spacing: 0;
}

td:hover {
    border: 1px solid red;
}	
</style>
</head>
<body>
<%
	Appointment appointment = (Appointment)session.getAttribute("appointment");
%>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Appointment Id</th>
      <th scope="col">Patient Name</th>
      <th scope="col">Doctor Name</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"><%= appointment.getAppointmentId() %></th>
      <td><%= appointment.getPatientName() %></td>
      <td><%= appointment.getDoctorName() %></td>
      <td><%= appointment.getDate() %></td>
    </tr>
  </tbody>
</table>
</body>
</html>