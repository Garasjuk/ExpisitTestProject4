<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
		<div id="main_content">
			<center>
				<div class="center_content">
					<div class="center_title_bar">
				
					<div class="details_big_box">
						
							<div class="product_title_big">
								<spring:message code="about.form.1"/>
							</div>
							<div class="specifications">
								<spring:message code="about.form.2"/>
								<br>
								<spring:message code="about.form.3"/>
								<br>
								<spring:message code="about.form.4"/>
								<br>
								<spring:message code="about.form.5"/>
								<br>
								<spring:message code="about.form.6"/>
								<br>
								<spring:message code="about.form.7"/>
								<br>
								<spring:message code="about.form.8"/>
							</div>
						</div>	
					</div>
				</div>
			</center>
		</div>
</body>
</html>