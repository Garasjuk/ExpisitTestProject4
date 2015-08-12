<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>

<link href="style.css" rel="stylesheet" type="text/css">
<link href="iecss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="cart" value="cart" />
	<form:form method="POST" action="${cart}" modelAttribute="cart">
		<center>
			
			<div id="main_content">
				<center>
					<div class="center_content">
						<div class="center_title_bar">Latest Products</div>
						<c:forEach items="${listCart}" var="listCart">
							<div class="prod_box">
								<div class="top_prod_box"></div>
								<div class="center_prod_box">
									<div class="product_title">
										<c:out value="${listCart.name_book}" />
									</div>
									<div class="product_img">
										<a href=" <c:url value="showDetail"><c:param name="selectDetail" value="${listCart.id_book}"/></c:url>"> <img src="images/book.png" alt=""
											border="0" /></a>
									</div>

									<div class="product_price">
										<span class="info"><c:out value="${listCart.price_book}" /></span>
									</div>
									<div class="prod_count">
										<span class="info"><c:out value="${listCart.count_book}" /></span>
									</div>
									<div class="prod_author">
										<span class="info"><c:out value="${listCart.count_cart}" /></span>
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