<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Like list</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>

	<c:url var="likeList" value="likeList" />
	<form:form method="GET" action="${likeList}" modelAttribute="likeList">
		<center>

			<div id="main_content">
				<center>

					<div class="center_content_orders">

						<div class="center_title_bar_orders"><spring:message code="main.form.like"/></div>
						
						<table border="0" width="100%" style="font-size: 14px;">
								<tr>
									<th></th>
									<th><spring:message code="main.form.name"/></th>
									<th><spring:message code="main.form.count"/></th>
									<th><spring:message code="main.form.price"/></th>
									<th><spring:message code="main.form.genre"/></th>
									<th><spring:message code="main.form.author"/></th>
									<th><spring:message code="main.form.publishing"/></th>
									<th><spring:message code="main.form.condition"/></th>
									<th></th>
									<th></th>
									
								</tr>
							<c:forEach items="${likesList}" var="likesList">								
								<tr bgcolor="#dcd9d9">
									<td width="3%" style="font-weight: bold;">
										
									</td>
									<td width="21%" style="text-align: right;">
										<c:out value="${likesList[1]}" />
									</td>
									<td width="5%" >
										<c:out value="${likesList[2]}" />
									</td>
									<td width="5%">
										<c:out value="${likesList[3]}" />
									</td>
									<td width="13%">
										<c:out value="${likesList[10]}" />
									</td>
									<td width="13%">
										<c:out value="${likesList[8]}" />
									</td>
									<td width="18%" style="text-align: left;">
										<c:out	value="${likesList[9]}" />
									</td>
									<td width="10%" style="text-align: left;">
										<c:if test="${likesList[6] == 1 }">
											<spring:message code="main.form.book.new"/>
										</c:if>
										<c:if test="${likesList[6] == 0 }">
											<spring:message code="main.form.book.past.in.usage"/>
										</c:if>	
									</td>
									<td width="10%" style="text-align: left;">
										<a href="<c:url value="addToCart"><c:param name="selectDetail" value="${likesList[0]}"/><c:param name="pageContent" value="true"/></c:url> " class="addtocart"><spring:message code="main.form.addcart"/></a> 
									</td>
										<td width="	3%" style="text-align: left;">
										<a href="<c:url value="likeList"><c:param name="selectDetail" value="${likesList[0]}"/></c:url> " class="deletelike"></a> 
									</td>
									
									
										
										
									
								</tr>
							</c:forEach>							
						</table>
					</div>
				</center>
			</div>

			
	</form:form>

</body>
</html>