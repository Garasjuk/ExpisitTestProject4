<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Password</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>

	<c:url var="editPassword" value="editPassword" />

	<form:form method="GET" action="${editPassword}" modelAttribute="User">
		<div id="main_content">
			<center>
				<div class="center_content">
					<div class="product_img_big"></div>
					<div class="center_prod_box_big">
						<div class="details_big_box">
							<div class="product_title_big">
							
							
							</div>
							<div class="specifications">
								<table align="center" width="500" border="0">
								<tr>
									<td width="50%" align="right">
										<spring:message code="main.form.pass"/>:
									</td>
									<td width="50%">
										<input type="password" name="pass1" required><Br>
									</td>
								</tr>
								<tr>
									<td align="right">	
										<spring:message code="main.form.repeat"/>:
									</td>
									<td>
										<input type="password" name="pass2" required><Br>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div class="product_title" align="center"  >
											<c:out	value="${errorPassword} " />
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" name="editPassword" value="Edit Password">
									</td>
								</tr>
								 
								</table>
							
							</div>
						</div>
					</div>
				</div>
			</center>
		</div>
	</form:form>

</body>
</html>