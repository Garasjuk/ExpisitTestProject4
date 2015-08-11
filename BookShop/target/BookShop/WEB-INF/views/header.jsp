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
							<div class="center_title_bar" style="text-align: right;">
							<c:if test="${not empty nameUser}">
								<c:out value="${nameUser}" /> <a href="logout" >Logout</a>
							</c:if>
							<c:if test="${empty nameUser}">
								<a href="login" >Login</a>
							</c:if>
							
							
							</div>
						</div>
					</center>
				</div>	
			
			</td>
		</tr>
	</table>
</div>