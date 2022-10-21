<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<p align="center" style="color : red;"><%= exception.getMessage() %></p>
	<%if(exception.getMessage().equals("Already registered!")) %>
		<%@ include file="../index.jsp" %>
		<%else {
			%>
			<p align="center" style="color : red;"><%=exception.getStackTrace() %></p>
			<%
		} %>
</body>
</html>