<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style type="text/css">

.my-container3{
	margin-top : 1%;
}
body{
	background-image : url("https://i.ibb.co/tQwzj2M/login-background.jpg");
	background-repeat : no-repeat; 	
	background-size : cover;
}	
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
 <a class="navbar-brand" href="#">E-Health Care</a>
<div class="my-container3">
	<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active text-white h3" aria-current="page" href="../ManageUser">Manage User</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-white h3" href="../ManageDoctors">Manage Doctors</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-white h3" href="../ManageAppointments">Appointments</a>
  </li>
</ul>
</div>
</nav>

<h1 align="center">Welcome <%=session.getAttribute("adminUsername") %></h1>
</body>
</html>