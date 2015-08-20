<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Money</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	
	<c:url var="addMoney" value="addMoney" />
			
		<form:form method="GET" action="${orderUser}" modelAttribute="ordersUser">
			<div id="main_content">
				<center>	
					<div class="center_content">
						<div class="center_title_bar">
							<a href="<c:url value="addMoney"><c:param name="choice_pay" value="SMS"/></c:url>">SMS</a>
							<a href="<c:url value="addMoney"><c:param name="choice_pay" value="Credit_card"/></c:url>">Credit card</a>
							<a href="<c:url value="addMoney"><c:param name="choice_pay" value="Pay_pal"/></c:url>">Pay Pal</a>
							</div>
							<div class="product_img_big">	
							</div>
							<div class="center_prod_box_big">
								<div class="details_big_box">
									<c:if test="${not empty nameUser}">
									
										<c:if test="${choice_pay == 'SMS'}">
											<div class="product_title_big">
													<input type="radio" name="money" value="5"> 5<Br>
													<input type="radio" name="money" value="10"> 10<Br>
												   	<input type="radio" name="money" value="15" checked="checked"> 15<Br>	
													<input type="radio" name="money" value="20"> 20<Br>	
													<input type="radio" name="money" value="25"> 25<Br>	
													<input type="radio" name="money" value="50"> 50<Br>	
											</div>
											
											<div class="specifications">
												<c:out value="You chooc number money" /><br>
												<c:out value=" and send SMS to number" /><br>
												<c:out value="+0 00 000-00-01" /><br>
												<c:out value="Enter SMS cod" />
												<input type="text" name="ansver_cod" required >
												<input type="submit" name="addNewMoney" value="Pay">
											</div>
										</c:if>
										<c:if test="${choice_pay == 'Credit_card'}">
											<div class="product_title_big">
													<input type="radio" name="money" value="5"> 5<Br>
													<input type="radio" name="money" value="10"> 10<Br>
												   	<input type="radio" name="money" value="15" checked="checked"> 15<Br>	
													<input type="radio" name="money" value="20"> 20<Br>	
													<input type="radio" name="money" value="25"> 25<Br>	
													<input type="radio" name="money" value="50"> 50<Br>	
											</div>
											
											<div class="specifications">
												<c:out value="You chooc number money and enter your credit card number" />
												<input type="text" name="ansver_cod" required >
												<input type="submit" name="addNewMoney" value="Pay">
											</div>
										</c:if>
										<c:if test="${choice_pay == 'Pay_pal'}">
											<div class="product_title_big">
													<input type="radio" name="money" value="5"> 5<Br>
													<input type="radio" name="money" value="10"> 10<Br>
												   	<input type="radio" name="money" value="15" checked="checked"> 15<Br>	
													<input type="radio" name="money" value="20"> 20<Br>	
													<input type="radio" name="money" value="25"> 25<Br>	
													<input type="radio" name="money" value="50"> 50<Br>	
											</div>
											
											<div class="specifications">
												<c:out value="You chooc number money and enter your PayPal code " />
												<input type="text" name="ansver_cod" required >
												<input type="submit" name="addNewMoney" value="Pay">
											</div>
										</c:if>
									</c:if>	
								</div>
							</div>
							
					
					</div>
				</center>
			</div>
	</form:form>
	
</body>
</html>