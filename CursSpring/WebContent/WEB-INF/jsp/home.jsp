<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!-- e diferit ce mi-a aparut mie fata cde ce in slide -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>
	<h1>HELLO WORLD!</h1>
	<P>THE TIME ON THE SERVER IS ${serverTime}.</P>
	<form action="user" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
	</form>

	<h2>HELLO VISITOR!</h2>
	<P>THE TIME ON THE SERVER IS ${serverTime}.</P>
	<form action="visitor" method="post">
		<input type="text" name="visitorName"><br> <input
			type="submit" value="YES">
	</form>
	<br>
	<h1>HELLO EMPLOYEE!</h1>
	<P>THE TIME ON THE SERVER IS ${serverTime}.</P>
	<form action="employee" method="post">
		<input type="text" name="name" placeholder="name"><br> 
		<input type="text" name="id" placeholder="id"><br> 
		<input type="text" name="contactNumber" placeholder="contactNumber"><br> 
		<input type="submit" value="*Insert*">
	</form>
	
		<h1>-- CALCULATOR --</h1>
	<P>THE TIME ON THE SERVER IS ${serverTime}.</P>
	<form action="calculator" method="post">
		<input type="text" name="f1" placeholder="f1"><br> 
		<input type="text" name="operation" placeholder="operation"><br> 
		<input type="text" name="f2" placeholder="f2"><br> 
		<input type="submit" value="calculate">
	</form>
</body>
</html>