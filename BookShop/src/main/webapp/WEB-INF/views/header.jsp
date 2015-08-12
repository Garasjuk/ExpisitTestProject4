<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div style="padding: 16px;" align="center">
	<table align="center" width="800" background="" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td>
				
				<div id="main_content">
					<center>
						<div class="center_content">
							<div class="center_title_bar" style="text-align: right;" overflow:hidden>
								<div class="" style="float:left; font-size: large;">
									<a href="showBook" >Main</a>
									/
									<a href="logout" >About</a>
									/
									<a href="logout" >Books</a>
									
									
								</div>
							<c:if test="${not empty roleUser}">
								<c:out value="${nameUser}" /> <a href="logout" >Logout</a>
								<br/>
								<c:choose>
									<c:when test="${roleUser == 1}">
										<a href="logout" >Books</a>
										/
										<a href="showUser" >Users</a>
										/
										<a href="logout" >Order</a>
									</c:when>
									<c:otherwise>
										<a href="logout" >Profil</a>
										/
										<a href="cart" >Cart</a>
										/
										<a href="logout" >Orders</a>
									</c:otherwise>	
										
								</c:choose>
							</c:if>
							<c:if test="${empty roleUser}">
								<a href="login" >Login</a>
								/
								<a href="registration" >Registration</a>
								
							</c:if>
							
							
							</div>
						</div>
						
							
					</center>
				</div>	
			
			</td>
		</tr>
	</table>
	<h1>Book Shop</h1>
</div>