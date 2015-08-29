<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="addBook" value="addBook" />
			
		<form:form method="GET" action="${addBook}"  modelAttribute="book">
			<div id="main_content">
				<center>	
					<div class="center_content_order">
						
							<div class="product_img_big">	
							</div>
							<table border="0" width="90%" >
								<c:if test="${not empty nameUser}">
									<c:if test="${roleUser == 1}">
										<tr bgcolor="#dcd9d9">
											<div class="details_big_box">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.name"/> :</div>
												</td>
												<td align="left">	
													<input type="text" name="add_name_book" required  onkeyup="return  validatorUserName(this)" >									
												</td>
										</tr>
										<tr bgcolor="#dcd9d9"> 	
												<td align="right">
													<div class="product_title"><spring:message code="main.form.genre"/> : </div> 
												</td>
												<td align="left">	
													<select name="add_genre_book" required>
													<c:forEach items="${genre}" var="genre">
													   	<option value ="${genre.id_genre}">${genre.name_genre}</option>
													</c:forEach>
													</select>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.author"/> : </div> 
												</td>	
												<td align="left">
													<select name="add_author_book" required>
														<c:forEach items="${author}" var="author">
													   		<option value ="${author.id_author}">${author.name_author}</option>
														</c:forEach>
													</select>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.publishing"/> : </div> 
												</td>	
												<td align="left">
													<select name="add_publishing_book" required>
														<c:forEach items="${publishing}" var="publishing">
													   		<option value ="${publishing.id_publishing}">${publishing.name_publishing}</option>
														</c:forEach>
													</select>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.price"/> : </div>
												</td>	
												<td align="left">
													<input type="text" name="add_price_book" required >
												</td>
										</tr>	
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">	<spring:message code="main.form.count"/> : </div>
												</td>
												<td align="left">
													<input type="text" name="add_count_book" required  >
												</td>
										</tr>
										<tr>
										<td>
										</td>
										<td>
											<input type="submit" name="addBook" value="Add Book">
										</td>
										</tr>
									</c:if>
								</c:if>	
							</table>
							
					
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>