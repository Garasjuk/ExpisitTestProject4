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

<script type="text/javascript">

 
function validatorUserName(input) { 
	if (!input)
		{
			
		}
	
} 




</script>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="addRegistration" value="addRegistration" />
			
		<form:form method="POST" action="${addRegistration}"  modelAttribute="user">
			<div id="main_content">
				<center>	
					<div class="center_content_login">
						<div class="center_prod_box_big_login">
							<div class="product_img_big">	
							</div>
							
							<c:if test="${not empty nameUser}">
									<c:if test="${roleUser == 1}">
										<div class="details_big_box">
											<div class="product_title">Name  :
												<input type="text" name="add_name_user" required  onkeyup="return  validatorUserName(this)" >
												
											</div>
											<div class="product_title">Adres : 
												<textarea name="add_adres_user" required ></textarea>
											</div>
											<div class="product_title">Email : 
												<input type="text" name="add_email_user" required>
											</div>
											<div class="product_title">
											<label>Role  :</label>
												<select name="identif" required>
												   <option></option>
												   <option value="0" >User</option>
												   <option value="1" >Admin</option>
												</select>
											</div>
											<div class="product_title">Pass  : 
												<input type="text" name="add_pass_user" required >
											</div>	
										</div>
									</c:if>
							</c:if>	
							<c:if test="${empty nameUser}">		
								<div class="details_big_box">
									<div class="product_title">Name:
										<input type="text" name="add_name_user" required>
									</div>
									<div class="product_title">Adres : 
										<input type="text" name="add_adres_user" required>
									</div>
									<div class="product_title">Email : 
										<input type="text" name="add_email_user" required>
									</div>
									<div class="product_title">Pass : 
										<input type="text" name="add_pass_user" required>
									</div>	
								</div>
							</c:if>
							
							
							
							<input type="submit" name="Registration" value="Registration">
						</div>
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>