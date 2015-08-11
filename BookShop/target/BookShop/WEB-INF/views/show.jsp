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
	<c:url var="showBook" value="showBook.html" />
	<form:form method="POST" action="${showBook}"
		modelAttribute="showDetail">
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

				<c:forEach items="${showDetail}" var="showDetail">
					<tr>

						<td><c:out value="${showDetail.id_book}" /></td>
						<td><c:out value="${showDetail.name_book}" /></td>
						<td><c:out value="${showDetail.count_book}" /></td>
						<td><c:out value="${showDetail.price_book}" /></td>
						<td><c:out value="${showDetail.id_genre}" /></td>
						<td><c:out value="${showDetail.id_author}" /></td>
						<td><c:out value="${showDetail.new_book}" /></td>
						<td><c:out value="${showDetail.id_publishing}" /></td>
						<td><c:out value="${showDetail.name_publishing}" /></td>
						<td><c:out value="${showDetail.name_genre}" /></td>
						<td><c:out value="${showDetail.name_author}" /></td>

					</tr>
				</c:forEach>

			</table>



			<div class="center_content">
				
				<div class="prod_box_big">
					<div class="top_prod_box_big"></div>
					<div class="center_prod_box_big">
						<div class="product_img_big">
							<a href="javascript:popImage('images/big_pic.jpg','Some Title')"
								title="header=[Zoom] body=[&nbsp;] fade=[on]"><img
								src="images/laptop.gif" alt="" border="0" /></a>
							
						</div>
						<div class="details_big_box">
						<c:forEach items="${showDetail}" var="showDetail">
							<div class="product_title_big">
								<c:out value="${showDetail.name_book}" />
							</div>
							
							<div class="specifications">
								Price: <span class="blue"><c:out value="${showDetail.price_book}"/></span><br />
								Count: <span class="blue"><c:out value="${showDetail.count_book}" /></span><br /> 
								Author: <span class="blue"><c:out value="${showDetail.name_author}"/></span><br />
								Genre: <span class="blue"><c:out value="${showDetail.name_genre}"/></span><br />
								Publishing: <span class="blue"><c:out value="${showDetail.name_publishing}"/></span><br /> 
								
								<c:if test="${not empty nameUser}">
									<a href=" <c:url value="addLike"><c:param name="selectDetail" value="${showDetail.id_book}"/></c:url>"> <img src="images/like.gif" alt=""
											border="0" />Like:  </a><c:out value="${countLike}"/>
								</c:if>
								<c:if test="${empty nameUser}">
									Like: <span class="blue"><c:out value="${countLike}"/></span>
								</c:if>
								
								<br />
							</div>
							<div class="prod_price_big">
								<span class="reduce">350$</span> <span class="price">270$</span>
							</div>
							<a href="http://www.free-css.com/" class="addtocart">add to
								cart</a> <a href="http://www.free-css.com/" class="compare">compare</a>
						
						
						
						</c:forEach>
						</div>
						
					</div>
					<div class="bottom_prod_box_big"></div>
				</div>
			</div>
				<div id="main_content">

					<div class="center_content">
						<div class="center_title_bar">Comments</div>
						<div class="prod_box_big">
							<div class="top_prod_box_big"></div>
							<div class="center_prod_box_big">
								<div class="details_big_box">
									fdb bdsgersd;igmd shdf gkdjfgh kj
								</div>
							</div>
						</div>
					</div>
				</div>
		</center>
		</div>
	</form:form>

</body>
</html>