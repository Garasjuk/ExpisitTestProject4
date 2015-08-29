<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>


<link href="style.css" rel="stylesheet" type="text/css">

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
											<table>
												<tr>
													<td>											
														<div class="product_title"><spring:message code="main.form.name.user"/>  : </div>
													</td>
													<td>	
															<input type="text" name="add_name_user" required  onkeyup="return  validatorUserName(this)" >
													</td>
												</tr>	
												<tr>
													<td>		
														<div class="product_title"><spring:message code="main.form.adres"/> : </div>
													</td>
													<td>	 
															<textarea name="add_adres_user" required ></textarea>
													</td>	
												</tr>		
												<tr>
													<td>
														<div class="product_title"><spring:message code="main.form.email"/> :</div>
													</td>
													<td>	 
															<input type="text" name="add_email_user" required>
													</td>
												</tr>		
												<tr>
													<td>		
														<div class="product_title">
															<label><spring:message code="main.form.role"/>  :</label>
														</div>
													</td>
													<td>	
														<select name="identif" required>
														   <option></option>
														   <option value="0" >User</option>
														   <option value="1" >Admin</option>
														</select>
													</td>
												</tr>	
												<tr>
													<td>		
														<div class="product_title"><spring:message code="main.form.pass"/>  : </div>
													</td>
													<td>	 
														<input type="text" name="add_pass1_user" required >
													</td>
												</tr>
												<tr>
													<td>		
														<div class="product_title"><spring:message code="main.form.repeat"/>: </div>
													</td>
													<td>	 
														<input type="text" name="add_pass2_user" required >
													</td>
												</tr>	
												<tr>
													<td colspan="2">
														<div class="product_title">
														<h2><c:out value="${errorEmail}" /></h2>
														</div>
														<div class="product_title">
														<h2><c:out value="${errorPassword}" /></h2>
														</div>
														
													</td>
												</tr>	
												<tr>
													<td colspan="2">
														<input type="submit" name="Registration" value="Registration">
													</td>
												</tr>		
											</table>
										</div>
									</c:if>
							</c:if>	
							<c:if test="${empty nameUser}">		
								<div class="details_big_box">
									<table  border="0">
										<tr>
											<td>
												<div class="product_title"><spring:message code="main.form.name.user"/>: </div>
											</td>
											<td>
												<input type="text" name="add_name_user" required>
											</td>
										</tr>	
										<tr>
											<td>
												<div class="product_title"><spring:message code="main.form.adres"/> : </div>
											</td>
											<td>	
												<textarea name="add_adres_user" required ></textarea>
											</td>
										</tr>	
										<tr>
											<td>
												<div class="product_title"><spring:message code="main.form.email"/> : </div>
											</td>
											<td>
												<input type="text" name="add_email_user" required>
											</td>	
										</tr>	
										<tr>
											<td>
												<div class="product_title"><spring:message code="main.form.pass"/> : </div>
											</td>
											<td>	 
												<input type="text" name="add_pass1_user" required>
											</td>
										</tr>	
										<tr>
											<td>
												<div class="product_title"><spring:message code="main.form.repeat"/>: </div> 
											</td>
											<td>
												<input type="text" name="add_pass2_user" required >
											</td>
										</tr>	
										<tr>
											<td colspan="2" align="center">
												<div class="product_title">
												<h2><c:out value="${errorEmail}" /></h2>
												</div>
												<div class="product_title">
												<h2><c:out value="${errorPassword}" /></h2>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<input type="submit" name="Registration" value="Registration">
											</td>
										</tr>
										
									</table>
								</div>
							</c:if>
							
							
							
							
						</div>
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>