<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book shop</title>



<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="showBook" value="showBook" />
	<form:form method="POST" action="${showBook}" modelAttribute="book">
		<center>
			
			<div id="main_content">
				<center>
					<div class="center_content">
						<div class="center_title_bar">
						<table border="0" width="500">
							<tr>
								<td width="30%">
								</td>
								<td width="40%" align="center">
									<spring:message code="main.form.title"/>	
								</td>
								<td width="30%">
									<input type="text">	
								</td>
							</tr>
						</table>
							 </div>
						<div class="center_title_bar_filter">
							<table border="0" width="100%">
								<tr>
									<td>
										<spring:message code="main.form.genre"/>
									</td>
									<td>
										<spring:message code="main.form.author"/>
									</td>
									<td>
										<spring:message code="main.form.publishing"/>
									</td>
									<td>
										<spring:message code="main.form.condition"/>
									</td>
								</tr>
								<tr>
									<td>
										<select name="genre_book_filter"  onchange="location.href = '<c:url value="showBook"><c:param name="genre_book_filter" value=""/></c:url>' + this.options[this.selectedIndex].value">
											<option value=""></option>
											<c:forEach items="${genre}" var="genre">
											   	<option value ="${genre.id_genre}">${genre.name_genre}</option>
											</c:forEach>
										</select>
									</td>
									<td>	
										<select name="author_book_filter"  onchange="location.href = '<c:url value="showBook"><c:param name="author_book_filter" value=""/></c:url>' + this.options[this.selectedIndex].value">
											<option value=""></option>
											<c:forEach items="${author}" var="author">
												<option value ="${author.id_author}">${author.name_author}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<select name="publishing_book_filter"  onchange="location.href = '<c:url value="showBook"><c:param name="publishing_book_filter" value=""/></c:url>' + this.options[this.selectedIndex].value">
											<option value=""></option>
											<c:forEach items="${publishing}" var="publishing">
										   		<option value ="${publishing.id_publishing}">${publishing.name_publishing}</option>
											</c:forEach>
										</select>
									</td>	
									<td>
										<select name="new_book_filter"  onchange="location.href = '<c:url value="showBook"><c:param name="new_book_filter" value=""/></c:url>' + this.options[this.selectedIndex].value">
											<option value=""></option>
											<option value ="1"><spring:message code="main.form.book.new"/></option>
											<option value ="0"><spring:message code="main.form.book.past.in.usage"/> </option>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<c:if test="${listSize !=null}">
											<input type="hidden" name="idfilter" value="${idfilter}">
											
											<input type="submit" name="Last" value="Last">
											<c:out value="${begin +1}" /> -
											<c:out value="${end +1}" />/
											<c:out value="${listSize}"/>
											<input type="submit" name="Next" value="Next">	
											
											<input type="hidden" name="begin" value="${begin}">
											<input type="hidden" name="end" value="${end}">
										</c:if>
									</td>
								</tr>
								
							</table>
							
						</div>
						<c:forEach items="${book}" var="book" begin="${begin}" end="${end}">
							<div class="prod_box">
								<div class="top_prod_box"></div>
								<div class="center_prod_box">
									<div class="product_title">
									<span class="info"><spring:message code="main.form.name"/>: </span>
										<a href="showDetail"><c:out value="${book[1]}" /></a>
									</div>
									<div class="product_img">
										<a href=" <c:url value="showDetail"><c:param name="selectDetail" value="${book[0]}"/></c:url>"> <img src="images/book.png" alt=""
											border="0" /></a>
									</div>

									<div class="product_price">
										<span class="info"><spring:message code="main.form.price"/>: </span>
										<span class="blue"><c:out value="${book[3]}" /></span>
									</div>
									<div class="prod_count">
										<span class="info"><spring:message code="main.form.count"/>: </span> 
										<span class="blue"><c:out value="${book[2]}" /></span>
									</div>
									<div class="prod_author">
										<span class="info"><spring:message code="main.form.author"/>:</span>
										<span class="blue"><c:out value="${book[8]}" /></span>
									</div>
									<div class="prod_genre">
										<span class="info"><spring:message code="main.form.genre"/>:</span>
										<span class="blue"><c:out value="${book[10]}" /></span>
									</div>
									<div class="prod_publishing">
										<span class="info"><spring:message code="main.form.publishing"/>:</span>
										<span class="blue"><c:out value="${book[9]}" /></span>
									</div>
									<div class="prod_new">
										<span class="info"><spring:message code="main.form.condition"/>:</span>
										
											<c:if test="${book[6] == 1 }">
												<spring:message code="main.form.book.new"/>
											</c:if>
											<c:if test="${book[6] == 0 }">
												<spring:message code="main.form.book.past.in.usage"/>
											</c:if>																				
									</div>																	
								</div>
								<div class="bottom_prod_box"></div>							
							</div>
						</c:forEach>
						
					</div>
					
				</center>
			</div>
	</form:form>
	
</body>
</html>