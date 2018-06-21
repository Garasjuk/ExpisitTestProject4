<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h2>E-mail</h2>



<a href="about" style="font-size: 36px;">Home</a> </br>


	<form:form method="GET" action="send" >
		
		<a style="font-size: 40px"> Create E-mail</a> </br>
		TO: <input type="email"	name="to" required/></br>
		Title: <input type="text"	name="title"required/></br>
		Text: <input type="text"	name="text" required/></br>
		
		<input type="submit" name="send" value="Send">
	</form:form>

</body>
</html>
