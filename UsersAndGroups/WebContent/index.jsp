<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="webBasesAngular">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Web Base</title>
<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular.js"></script>
  <script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="./js/app.js"></script>
</head>
<body >
	<header>
	  	<jsp:include page="/tiles/header.jsp"/>
	</header>
<div ng-controller="managerController">

<a href="./listUser.jsp" class="button-red" style="text-align:center;width:80px;margin-left:45%;margin-right:40%">listUser</a>	
	
<a href="./listGroup.jsp" class="button-red" style="text-align:center;width:80px;margin-left:45%;margin-right:40%">listGroup</a>	
	
</div>
	<footer>
		<jsp:include page="/tiles/footer.jsp"/>
	</footer>
</body>
</html>