<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="profil" value="profil" />
			
		<form:form method="GET" action="${profil}"  modelAttribute="user">
			<div id="main_content">
				<center>	
					<div class="center_content_order">
						
							<div class="product_img_big">	
							</div>
							<table border="0" width="90%" >
								<c:if test="${not empty nameUser}">
									
										<tr bgcolor="#dcd9d9">
											<div class="details_big_box">
												<td align="right">
													<div class="product_title">Name User :</div>
												</td>
												<td align="left">	
													<input type="text" name="edit_name_user" required value="${listProfil.name_user}" >									
												</td>
										</tr>
										<tr bgcolor="#dcd9d9"> 	
												<td align="right">
													<div class="product_title">Money : </div> 
												</td>
												<td align="left">
													<label style="font-size: 18px; font-weight:bold; color: blue;">	
														<c:out value="${listProfil.money_user}"  />
													</label>	
													<a href="addMoney">Add money</a>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9"> 	
												<td align="right">
													<div class="product_title">Spend money : </div> 
												</td>
												<td align="left">
													<label style="font-size: 18px; font-weight:bold; color:olive;">	
														<c:out value="${listProfil.spend_money}"  />
													</label>	
													
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">Address : </div> 
												</td>	
												<td align="left">
													<textarea name="edit_adres_user" required >${listProfil.adres_user}</textarea>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">Password : </div> 
												</td>	
												<td align="left">
													<input type="text" name="edit_pass_user" required value="${listProfil.pass_user}" disabled="disabled">
													<a href="editPassword">Edit password</a>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">Role : </div>
												</td>	
												<td align="left">
													<input type="text" name="edit_role_user" required value="${listProfil.identif}" disabled="disabled" >
												</td>
										</tr>	
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">E-mail : </div>
												</td>
												<td align="left">
													<input type="text" name="edit_email_user" required value="${listProfil.email}" disabled="disabled" >
												</td>
										</tr>
										<tr>
										<td>
										</td>
										<td>
											<input type="submit" name="editUser" value="Edit User">
										</td>
										</tr>
									
								</c:if>	
							</table>
							
					
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>