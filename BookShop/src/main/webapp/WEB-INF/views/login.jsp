<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">

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
								<table>	
									<tr>
										<td>
											<div class="product_title" ><spring:message code="main.form.login"/>:
											</div>
										</td>
										<td>	
											<input type="text" name="name_user_login" required >
										</td>
									</tr>
									<tr>	
										<td>
											<div class="product_title"><spring:message code="main.form.pass"/> : 
											</div>
										</td>
										<td>
											<input type="password" name="pass_user_login" required >
										</td>
									</tr>
									<tr>
										<td colspan="2">		
											<div class="product_title">
												<c:out value="${errorLogin}" /> 
											</div>
										</td>
									</tr>	
								</table>			
							</div>
							
							<input type="submit" name="Login" value="Login">
						</div>
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>