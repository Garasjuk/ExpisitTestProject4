<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>


<link href="style.css" rel="stylesheet" type="text/css">
<link href="iecss.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>

	<c:url var="showUser" value="showUser" />

	<form:form method="GET" action="${showUser}" modelAttribute="user">
		
			<center>
				<div class="center_content">
				
				<div class="prod_box_big">
					<div class="top_prod_box_big"></div>
					<div class="center_prod_box_big">
						
							<c:if test="${not empty nameUser}">
								<c:if test="${roleUser == 1}">


									
									<table border="0" width="100%" style="font-size: 14px; "  >
										
										<c:forEach items="${allListUser}" var="allListUser">
												<tr bgcolor="#dcd9d9">										
												
													
													
													<td width="20%" style=" font-weight: bold; " >													
														<a href=" <c:url value="showUser"><c:param name="selectUser" value="${allListUser.id_user}"/></c:url>"><c:out value="${allListUser.name_user}" /></a>
													</td>
													<td width="10%" style="text-align: right;">
														<c:out value="${allListUser.money_user}" />
													</td>
													<td width="40%" style="text-align: left;">
														<c:out value="${allListUser.adres_user}" />
													</td>
													<td width="10%">	
														<c:out value="${allListUser.identif}" />
													</td>
													<td width="20%" style="text-align: left;  ">											
														<c:out value="${allListUser.email}" />
													</td>

												
											</tr>
											
										</c:forEach>
										</table>
										<h2>
											<a href="registration" >Add User</a>
											
										</h2>
										<br/>
										<br/>
										<hr/>
									<c:if test="${not empty editUser}">
										<table border="0" width="100%">
											<tr>
												<td width="30%" align="right">
													<div class="product_title">Name  : </div>
												</td>
												<td width="70%" align="left">	
														<input type="text" name="edit_name_user"  required value="${editUser.name_user}"  />
												</td>
											</tr>
											
											<tr>	
												<td align="right">	
													<div class="product_title">Adres : </div>
												</td>
												<td align="left">	
														<textarea name="edit_adres_user" required >${editUser.adres_user}</textarea>
												</td>
											</tr>
											<tr>
												<td align="right">		
													<div class="product_title">Email : </div> 
												</td>
												<td align="left">
													<input type="text" name="edit_email_user" required value="${editUser.email}">
												</td>
											</tr>
											<tr>
												<td align="right">	
													<div class="product_title">	Role  : </div>
												</td>
												<td align="left">	
															<select name="identif" required>
															   <option value="${editUser.identif}" ></option>
															   <option value="0" >User</option>
															   <option value="1" >Admin</option>
														</select>
												</td>
											</tr>
											<tr>
												<td align="right">	
													<div class="product_title">Pass  : </div>
												</td>
												<td align="left">	 
														<input type="text" name="edit_pass_user" required value="${editUser.pass_user}">
												</td>
											</tr>
											<tr>
												<td>
													<input type="hidden" name="edit_id_user" value="${editUser.id_user}">
													<input type="hidden" name="edit_money_user"  value="${editUser.money_user}"/>
												</td>											
												<td align="left">	
													<input type="submit" name="editUser" value="Edit User">
												</td>
											</tr>										
										</table>
									</c:if>
									
									
									
								</c:if>
							</c:if>


							
						</div>
					</div>
				</div>
			</center>
		
	</form:form>

</body>
</html>