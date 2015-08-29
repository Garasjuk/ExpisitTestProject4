<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>

	<c:url var="cart" value="cart" />
	<form:form method="POST" action="${cart}" modelAttribute="cart">
		<center>

			<div id="main_content">
				<center>
				<div class="product_title">
						<c:out value="${Error_stock}" />
				</div>	
					<div class="center_content">
				
						<div class="center_title_bar"><spring:message code="main.form.cart"/></div>
						
						<c:forEach items="${listCart}" var="listCart">
							<div class="prod_box">
								<div class="top_prod_box"></div>
								<div class="center_prod_box">
									<div class="delete_button">
										<a
											href="<c:url value="deleteFromCart"><c:param name="id_cart" value="${listCart.id_cart}"/></c:url>">X</a>
										
									</div>
									<div class="product_title">
										<span class="info"><spring:message code="main.form.name"/>:</span>
										<c:out value="${listCart.name_book}" />
									
									</div>
									<div class="product_img">
										<a
											href=" <c:url value="showDetail"><c:param name="selectDetail" value="${listCart.id_book}"/></c:url>">
											<img src="images/book.png" alt="" border="0" />
										</a> <input type="hidden" name="id_book"
											value="${listCart.id_book}" size="1px">
									</div>

									<div class="product_price">
										<span class="info"><spring:message code="main.form.cena"/>:</span> 
										<span class="blue">
										<input type="hidden" name="priceBook" value="${listCart.price_book}" size="1px">
										<c:out value="${listCart.price_book}" /></span>
									</div>
									<div class="prod_count">
										<span class="info"><spring:message code="main.form.count.in.stock"/>:</span> 
										<span class="blue"><c:out value="${listCart.count_book}" /></span> 
										<input type="hidden" name="count_in_stock" value="${listCart.count_book}" size="1px">
									</div>
									<div class="prod_count">
										<span class="info"><spring:message code="main.form.count.order"/>:</span> <span class="blue">
											 
											<c:out 	value="${listCart.count_cart}" />
										</span>
									</div>
									<div class="prod_button">
										<a href="<c:url value="cart"><c:param name="id_cart" value="${listCart.id_cart}"/></c:url>"><spring:message code="main.form.make.order"/></a>							
									</div>
								</div>
								</div>	
						</c:forEach>						
					</div>					
				</center>			
			</div>

			<c:if test="${not empty madeOrder}">
			<div class="center_content">
			<div class="prod_box_big">
			<div class="top_prod_box_big"></div>
			<div class="center_prod_box_big">
				<c:forEach items="${madeOrder}" var="madeOrder">
					<table border="0" width="100%">
						<tr>
							<td width="30%" align="right">
								<div class="product_title"><spring:message code="main.form.name"/> :</div>
							</td>
							<td width="70%" align="left"><c:out
									value="${madeOrder.name_book}" /></td>
						</tr>
						<tr>
							<td width="30%" align="right">
								<div class="product_title"><spring:message code="main.form.count"/> :</div>
							</td>
							<td width="70%" align="left">
									<input type="text" name="order_count_cart" required value="${madeOrder.count_cart}" size="1px"></td>
						</tr>
						<tr>
							<td align="right">
								<div class="product_title"><spring:message code="main.form.adres"/> :</div>
							</td>
							<td align="left"><textarea name="order_adres_user" required>${adresUser}</textarea>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="product_title"><spring:message code="main.form.other"/> :</div>
							</td>
							<td align="left"><textarea name="order_other" required></textarea>
							</td>
						</tr>
						<tr>
							<td>
							</td>
							<td align="left">
								<input type="hidden" name="select_id_cart" value="${id_cart}" size="1px"></td>
								<input type="submit" name="addOrder" value="Add Order">
							</td>
						</tr>
					</table>
				</c:forEach>
			</div>
			</div>
			</div>	
			</c:if>
	</form:form>

</body>
</html>