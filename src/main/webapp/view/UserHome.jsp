<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image : url("../images/login_background.jpg");
background-repeat : no-repeat; 
	background-size : cover;
}
.grow:hover{
-webkit-transform: scale(1.2);
-ms-transform: scale(1.2);
transform: scale(1.2);
transistion-duration : 1.5s;
}
.btn{
	background-color: #00a2b2;
	color: #fff;
	border-radius: 30px;
	padding : 25px;
	font-weight: 600;
	font-size: 2em;
	margin : 20px;
	border-style : none;
}
.btn a{
	text-decoration : none;
	color : white;
}
.container {
	width : 100vw;
	height : 90vh;
	display : flex;
	justify-content : center;
	align-items : center
}
.container-wrapper{
	display : flex;
}
</style>
</head>
<body>
<div class="container">
	<div class="container-wrapper">
	<div class="grow">
	  <button  class="btn">
	   <a href="ShowBookAppointment.jsp" >Book Appointment</a>
	  </button>
	</div>
	<div class="grow" >
	  <button  class="btn">
	   <a href="../MyAppointments" >My Appointments</a>
	  </button>
	</div>
</div>
</div>
</body>
</html>