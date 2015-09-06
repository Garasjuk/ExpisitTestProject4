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
							<c:if test="${not empty errorAddBook}"> 
								<h2 style="color: red;"> <spring:message code="main.form.errorAddBook"/> </h2>
							</c:if>							
							<table border="0" width="90%" >
								<c:if test="${not empty nameUser}">
									<c:if test="${roleUser == 1}">
										<tr bgcolor="#dcd9d9">
											<div class="details_big_box">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.name"/> :</div>
												</td>
												<td align="left">	
													<input type="text" name="add_name_book"   onkeyup="return  validatorUserName(this)" >									
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
												<td>
													<a href=" <c:url value="addBook"><c:param name="genre" value="true"/></c:url>">Add Genre</a>
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
												<td>
												
													<a href=" <c:url value="addBook"><c:param name="author" value="true"/></c:url>">Add Author</a>
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
												<td>
													<a href=" <c:url value="addBook"><c:param name="publishing" value="true"/></c:url>">Add Publishing</a>
												</td>
										</tr>
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title"><spring:message code="main.form.price"/> : </div>
												</td>	
												<td align="left">
													<input type="text" name="add_price_book"  >
												</td>
										</tr>	
										<tr bgcolor="#dcd9d9">
												<td align="right">
													<div class="product_title">	<spring:message code="main.form.count"/> : </div>
												</td>
												<td align="left">
													<input type="text" name="add_count_book"   >
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
							
							<c:if test="${not empty addGenre}">
								<table border="0" width="100%">
									<tr>
										<td width="30%" align="right">
											<div class="product_title">	<spring:message code="main.form.genre"/></div>
										</td>
										<td width="70%" align="left">	
											<input type="text" name="add_genre"  required  />
										</td>
									</tr>
									<tr>	
										<td align="center" colspan="2">	
											<input type="submit" name="addGenre" value="Add Genre">
										</td>
									</tr>
								</table>
							</c:if>
							<c:if test="${not empty addAuthor}">
								<table border="0" width="100%">
									<tr>
										<td width="30%" align="right">
											<div class="product_title"><spring:message code="main.form.author"/></div>
										</td>
										<td width="70%" align="left">	
											<input type="text" name="add_author"  required  />
										</td>
									</tr>
									<tr>	
										<td align="center" colspan="2">	
											<input type="submit" name="addAuthor" value="Add Author">
										</td>
									</tr>
								</table>
							</c:if>
							<c:if test="${not empty addPublishing}">
								<table border="0" width="100%">
									<tr>
										<td width="30%" align="right">
											<div class="product_title"><spring:message code="main.form.publishing"/></div>
										</td>
										<td width="70%" align="left">	
											<input type="text" name="add_publishing"  required  />
										</td>
									</tr>
									<tr>	
										<td align="center" colspan="2">	
										
											<input type="submit" name="addPublishing" value="Add Publishing">
										</td>
									</tr>
								</table>
							</c:if>
							
							
							
					
					</div>
				</center>
			</div>
		</form:form>
	
</body>
</html>