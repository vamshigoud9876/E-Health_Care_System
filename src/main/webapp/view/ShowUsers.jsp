<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,com.ehealth.model.User" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style>

.myTable1,table table-hover{
margin : 3% 4% 4% 4%;
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
<div class="myTable1">
<table class="table table-hover">
  <thead style="background-color :black; color:white;">
    <tr>
      <th scope="col">User Id</th>
      <th scope="col">Name</th>
      <th scope="col">email</th>
      <th scope="col">phone</th>
      <th scope="col">address</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <%
	List<User> users = (List<User>) request.getAttribute("users");
	for(User user: users)
	{
%>	
	
    <tr>
      <th scope="row"><%= user.getUserId() %></th>
      <td><%= user.getUsername() %></td>
      <td><%= user.getEmail() %></td>
      <td><%= user.getPhoneNumber() %></td>
      <td><%= user.getUserAddress() %></td>
      <td>
	      <form action="DeleteUserController">
	      	<input type="submit" value="delete">
	      	<input type="hidden" name="userId" value=<%= user.getUserId() %>>
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