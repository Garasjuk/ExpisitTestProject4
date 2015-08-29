<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Order</title>

<link href="style.css" rel="stylesheet" type="text/css">
<link href="iecss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>

	<c:url var="orderUser" value="orderUser" />
	<form:form method="GET" action="${orderUser}" modelAttribute="ordersUser">
		<center>
			<div id="main_content">
				<center>
					<div class="center_content_orders">
						<div class="center_title_bar_orders"><spring:message code="main.form.you.order"/></div>
						<table border="0" width="100%" style="font-size: 14px;">
							<tr>
								<th>
									№	
								</th>
								<th>
									<spring:message code="main.form.name"/>
								</th>
								<th>
									<spring:message code="main.form.author"/>
								</th>
								<th>
									<spring:message code="main.form.publishing"/>
								</th>
								<th>
									<spring:message code="main.form.genre"/>
								</th>
								<th>
									<spring:message code="main.form.count"/>
								</th>
								<th>
									<spring:message code="main.form.adres"/>
								</th>
								<th>
									<spring:message code="main.form.status"/>
								</th>
							</tr>
							<c:forEach items="${ordersUser}" var="ordersUser">
								<c:if test="${ordersUser[13] !=1}">
									<tr bgcolor="#dcd9d9">
										<td width="3%" style="font-weight: bold;">
											<c:out value="${ordersUser[0]}" />
										</td>
										<td width="10%" style="text-align: right;">
											<c:out value="${ordersUser[1]}" />
										</td>
										<td width="15%" style="text-align: left;">
											<c:out value="${ordersUser[2]}" />
										</td>
										<td width="15%">
											<c:out value="${ordersUser[3]}" />
										</td>
										<td width="10%">
											<c:out value="${ordersUser[4]}" />
										</td>
										<td width="3%">
											<c:out value="${ordersUser[7]}" />
										</td>
										<td width="20%" style="text-align: left;">
											<c:out	value="${ordersUser[8]}" />
										</td>
										
										<td width="9%" style="text-align: left;">
											<c:out	value="${ordersUser[10]}" />
										</td>
										<td width="7%" style="text-align: left;">
											<c:out	value="${ordersUser[12]}" />
										</td>
										<td width="7%" style="text-align: left;">
											<c:if test="${ordersUser[10] =='delivered'}">
												<a href="<c:url value="returnOrder">
												
													<c:param name="nameBook" value="${ordersUser[1]}"/>
													<c:param name="idOrder" value="${ordersUser[0]}"/>
													<c:param name="countOrder" value="${ordersUser[7]}"/>
													<c:param name="priceBook" value="${ordersUser[14]}"/>
													<c:param name="dateDelivered" value="${ordersUser[12]}"/>
													
													<c:param name="idGenre" value="${ordersUser[15]}"/>
													<c:param name="idAuthor" value="${ordersUser[16]}"/>
													<c:param name="idPublishing" value="${ordersUser[17]}"/>
													
													</c:url>"><spring:message code="main.form.return"/></a>
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</center>
			</div>
		</center>
			
	</form:form>

</body>
</html>