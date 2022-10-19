<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, com.ehealth.model.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>


<div class="dropdown" align="center" style="margin-top:2%">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Select Specialist
  </button>
  <%if(request.getAttribute("doctors")==null){%>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="../SelectSpecialist?specialist=ENT">ENT</a></li>
    <li><a class="dropdown-item" href="../SelectSpecialist?specialist=cardiologist">cardiologist</a></li>
    <li><a class="dropdown-item" href="../SelectSpecialist?specialist=dermatologist">dermatologist</a></li>
    <li><a class="dropdown-item" href="../SelectSpecialist?specialist=neurologist">neurologist</a></li>
    <li><a class="dropdown-item" href="../SelectSpecialist?specialist=psychiatrist">psychiatrist</a></li>
  </ul>
  <%}
  else{
	  %>
	  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="./SelectSpecialist?specialist=ENT">ENT</a></li>
    <li><a class="dropdown-item" href="./SelectSpecialist?specialist=cardiologist">cardiologist</a></li>
    <li><a class="dropdown-item" href="./SelectSpecialist?specialist=dermatologist">dermatologist</a></li>
    <li><a class="dropdown-item" href="./SelectSpecialist?specialist=neurologist">neurologist</a></li>
    <li><a class="dropdown-item" href="./SelectSpecialist?specialist=psychiatrist">psychiatrist</a></li>
  </ul>
  <% } %>
</div 	>
<%
if(request.getAttribute("doctors")!=null){
%>
<table class="table table-hover" style="margin-top:2%;" >
  <thead style="background-color :black; color:white;">
    <tr>
      <th scope="col">Doctor Name</th>
      <th scope="col">Specialist</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
  <%
	List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
  
	for(Doctor doctor : doctors)
	{
	%>	
	
    <tr>
      <td><%= doctor.getUsername() %></td>
      <td><%= request.getAttribute("specialist").toString() %></td>
      <td>
	      <form action="BookAppointmentsController">
	      	<input type="date" name="date" required>
	      	<input type="hidden" name="dId" value="<%= doctor.getDoctorId() %>" >
	      	<input type="hidden" name="dName" value="<%= doctor.getUsername()%>" >
	      	<input  type="submit" value="select" >
	      </form>
      </td>
    </tr>

<%
	}
	}
%>
  </tbody>
</table>

</body>
</html>