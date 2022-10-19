<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/Login.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 </head>
<body>
<div class ="my-container1" >
	<form action="LoginController" method="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1"><b>Username</b></label>
	    <input type="text" class="form-control" aria-describedby="usernameHelp" name="uname" placeholder="username" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1"><b>Password</b></label>
	    <input type="password" class="form-control" name="pass" placeholder="Password" required>
	  </div>
	 
	  <button style="float:right;" type="submit" class="btn btn-primary">Submit</button>
	</form>
	<form action="./view/Registration.jsp" >
	  <div>
	  <button style="float:left;" class="btn btn-primary" type="submit">register</button>
	  </div>
	</form>
</div>
</body>
</html>