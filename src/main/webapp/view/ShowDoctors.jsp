<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,com.ehealth.model.Doctor" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style type="text/css">
.myTable2,table table-hover{
margin : 2% 4% 4% 4%;
}
body{
	background-image : url("https://i.ibb.co/tQwzj2M/login-background.jpg");
	background-repeat : no-repeat; 	
	background-size : cover;
}	
table, tr {
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
<nav class="navbar navbar-dark bg-dark">
 <a class="navbar-brand" href="#">E-Health Care</a>
</nav>
<div class="myTable2">
	
<table class="table table-hover">
  <thead style="background-color :black; color:white;">
    <tr>
      <th scope="col">Doctor Id</th>
      <th scope="col">Name</th>
      <th scope="col">phone</th>
      <th scope="col">email</th>
      <th scope="col">specialist</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <%
	List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
	for(Doctor doctor: doctors)
	{
%>	
	
    <tr>
      <th scope="row"><%= doctor.getDoctorId() %></th>
      <td><%= doctor.getUsername() %></td>
      <td><%= doctor.getPhoneNumber() %></td>
      <td><%= doctor.getEmail() %></td>
      <td><%= doctor.getSpecialist() %></td>
      <td>
	      <form action="DeleteDoctorController" method="post">
	      	<input type="submit" value="delete">
	      	<input type="hidden" name="doctorId" value=<%= doctor.getDoctorId() %>>
	      </form>
      </td>
    </tr>
<%	
	}
%>
  
  </tbody>
</table>
</div>
</body>
</html>