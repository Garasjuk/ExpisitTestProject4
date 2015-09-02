<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div style="padding: 16px;" align="center">
	<table align="center" width="800" background="" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td>
				
				<div id="main_content">
					<center>
					<div align="right">
	
						<c:set var="currentLocale">${pageContext.response.locale}</c:set>
						<c:set var="localeCode" value="${fn:toUpperCase(currentLocale)}" />
						
						<c:set var="availLanguages" value="EN,RU" />
						<c:if test="${!fn:contains(availLanguages, localeCode)}">
						  <c:set var="localeCode" value="EN" />
						</c:if>
						
					 	<c:forEach var="lang" items="${availLanguages}">
					 	    <c:set var="langHTML" value="${lang}" />
						 	<c:if test="${lang eq localeCode}">
							  <c:set var="langHTML" value="<b><u>${lang}</u></b>" />
							</c:if>
							
							
					    	<a href="${currentPage}?lang=${lang}">${langHTML}</a> &nbsp;
						</c:forEach>
					</div>

						<div class="center_content">
							<div class="center_title_bar" style="text-align: right;" overflow:hidden>
								<div class="" style="float:left; font-size: large;">
									<a href="showBook" ><spring:message code="header.main"/></a>
									/
									<a href="about" ><spring:message code="header.about"/></a>
									/
									<a href="aboutbook" ><spring:message code="header.books"/></a>
									
									
									
									
								</div>
							<c:if test="${not empty roleUser}">
								<c:out value="${nameUser}" /> <a href="logout" ><spring:message code="header.logout"/></a>
								<br/>
								<c:choose>
									<c:when test="${roleUser == 1}">
										<a href="addBook" ><spring:message code="header.addbooks"/></a>
										/
										<a href="showUser" ><spring:message code="header.showuser"/></a>
										/
										<a href="orders" ><spring:message code="header.orders"/></a>
										/
										<a href="editPassword"><spring:message code="header.editpassword"/></a>
									</c:when>
									<c:otherwise>
										<a href="profil" ><spring:message code="header.profil"/></a>
										/
										<a href="cart" ><spring:message code="header.cart"/></a>
										/
										<a href="orderUser" ><spring:message code="header.orderuser"/></a>
										/
										<a href="likeList" ><spring:message code="header.like.list"/></a>
										
									</c:otherwise>	
										
								</c:choose>
							</c:if>
							<c:if test="${empty roleUser}">
								<a href="login" ><spring:message code="header.login"/></a>
								/
								<a href="registration" ><spring:message code="header.registration"/></a>
								
							</c:if>
							
							
							</div>
						</div>
						
							
					</center>
				</div>	
			
			</td>
		</tr>
	</table>
	<br>
	<h1><spring:message code="header.title"/></h1>
</div>