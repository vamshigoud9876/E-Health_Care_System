<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 
</head>

<style>

.my-container2{
	width : 30% ;
	text-align : center;
	margin-left : auto;
	margin-right : auto;
	margin-top : 3%;
	border : 1px solid black; 
	padding-left : 20px;
	padding-right : 20px;
	padding-top : 20px;
	padding-bottom : 20px;
	border-radius : 20px;
}
body{
	background-image : url("../images/login_background.jpg");
	background-repeat : no-repeat; 
	background-size : cover;
}
</style>
<body>
	<div class="my-container2" >
		<h3 align="center"><b>Register</b></h3>
		<form action="../UserRegistrationController" method="post">
		 <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="text" id="form6Example3" name="username" class="form-control" placeholder="username" required/>
		    <label class="form-label" for="form6Example3">Username</label>
		  </div>
		
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="password" id="form6Example3" name="password" class="form-control" placeholder="password" required />
		    <label class="form-label" for="form6Example3">password</label>
		  </div>
		
		  <!-- Number input -->
		  <div class="form-outline mb-4">
		    <input type="number" id="form6Example6" name="phoneNumber" class="form-control" placeholder="Phone number" required/>
		    <label class="form-label" for="form6Example6">Phone</label>
		  </div>
		  
		  <!-- Email input -->
		  <div class="form-outline mb-4">
		    <input type="email" id="form6Example5" name="email" class="form-control" placeholder="email" required/>
		    <label class="form-label" for="form6Example5">Email</label>
		  </div>
		  
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="text" id="form6Example4" name="userAddress" class="form-control" placeholder="Address" required/>
		    <label class="form-label" for="form6Example4">Address</label>
		  </div>
	
		  <!-- Submit button -->
		  <button type="submit" class="btn btn-primary btn-block mb-4">Register</button>
		</form>
	</div>
</body>
</html>