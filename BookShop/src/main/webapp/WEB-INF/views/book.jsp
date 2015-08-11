<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/src/main/resources/theme/css/style.css"/>"
	rel="stylesheet">

<link href="style.css" rel="stylesheet" type="text/css">
<link href="iecss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="showDetail" value="showDetail" />
	<form:form method="POST" action="${showDetail}" modelAttribute="book">
		<center>
			
			<div id="main_content">
				<center>
					<div class="center_content">
						<div class="center_title_bar">Latest Products</div>
						<c:forEach items="${book}" var="book">
							<div class="prod_box">
								<div class="top_prod_box"></div>
								<div class="center_prod_box">
									<div class="product_title">
										<a href="showDetail"><c:out value="${book.name_book}" /></a>
									</div>
									<div class="product_img">
										<a href=" <c:url value="showDetail"><c:param name="selectDetail" value="${book.id_book}"/></c:url>"> <img src="images/laptop.gif" alt=""
											border="0" /></a>
									</div>

									<div class="product_price">
										<span class="info"><c:out value="${book.price_book}" /></span>
									</div>
									<div class="prod_count">
										<span class="info"><c:out value="${book.count_book}" /></span>
									</div>
									<div class="prod_author">
										<span class="info"><c:out value="${book.name_author}" /></span>
									</div>
									<div class="prod_genre">
										<span class="info"><c:out value="${book.name_genre}" /></span>
									</div>
									<div class="prod_publishing">
										<span class="info"><c:out
												value="${book.name_publishing}" /></span>
									</div>
										
									

								</div>
								<div class="bottom_prod_box"></div>
								<div class="prod_details_tab">
									<a href="http://www.free-css.com/" title="header=[Add to cart] body=[&nbsp;] fade=[on]">
										<img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> 
										
									<a href="http://www.free-css.com/" title="header=[Specials] body=[&nbsp;] fade=[on]">
										<img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> 
										
									<a href="http://www.free-css.com/" title="header=[Gifts] body=[&nbsp;] fade=[on]">
										
										
									<a href="details.html" class="prod_details">Like</a>
								</div>
							</div>
						</c:forEach>

					</div>
				</center>
			</div>
	</form:form>
	
</body>
</html>