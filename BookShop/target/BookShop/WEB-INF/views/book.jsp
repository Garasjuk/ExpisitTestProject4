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
	<center>
		<h2>Hello World</h2>
		<h2>${message}${name}</h2>
	</center>
	<c:url var="showDetail" value="showDetail" />
	<form:form method="POST" action="${showDetail}" modelAttribute="book">
		<center>
			<table border="1">
				<tr>
					<th>Book ID</th>
					<th>Book Name</th>
					<th>Book Count</th>
					<th>Book Price</th>
					<th>Book Genre</th>
					<th>Book Author</th>
					<th>Book New</th>
					<th>Book Publishing</th>
					<th>Book Publishing</th>
					<th>Book Genre</th>
					<th>Book Author</th>


				</tr>

				<c:forEach items="${book}" var="book">
					<tr>

						<td><c:out value="${book.id_book}" /></td>
						<td><c:out value="${book.name_book}" /></td>
						<td><c:out value="${book.count_book}" /></td>
						<td><c:out value="${book.price_book}" /></td>
						<td><c:out value="${book.id_genre}" /></td>
						<td><c:out value="${book.id_author}" /></td>
						<td><c:out value="${book.new_book}" /></td>
						<td><c:out value="${book.id_publishing}" /></td>
						<td><c:out value="${book.name_publishing}" /></td>
						<td><c:out value="${book.name_genre}" /></td>
						<td><c:out value="${book.name_author}" /></td>

					</tr>
				</c:forEach>

			</table>


			<input type="submit" value="Edit" name="Edit"> <input
				type="submit" value="Delete" name="Delete" /> <input type="submit"
				value="Book" name="Book"> <br /> <input type="submit"
				value="Last" name="Last"> <input type="submit" value="Next"
				name="Next"> <input type="hidden" name="begin"
				value="${begin}"> <input type="hidden" name="end"
				value="${end}">
		
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