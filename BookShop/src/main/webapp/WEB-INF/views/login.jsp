<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/src/main/resources/theme/css/style.css"/>"
	rel="stylesheet">

<link href="style.css" rel="stylesheet" type="text/css">
<link href="iecss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="listUser" value="listUser" />
		
			
		<form:form method="POST" action="${listUser}" modelAttribute="listUser">
			<div id="main_content">
				<center>	
					<div class="center_content_login">
						<div class="center_prod_box_big_login">
							<div class="product_img_big">	
							</div>
							<div class="details_big_box">
								<div class="product_title" >Login:
									<input type="text" name="name_user_login" required >
								</div>
								<div class="product_title">Pass : 
									<input type="text" name="pass_user_login" required >
								</div>
								<div class="product_title">
									<c:out value="${errorLogin}" /> 
								</div>
									
							</div>
							
							<input type="submit" name="Login" value="Login">
						</div>
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>