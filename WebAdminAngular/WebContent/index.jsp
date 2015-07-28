<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="webAdminAngular">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AngularJS Web Admin</title>
<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular.js"></script>
  <script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="./js/app.js"></script>



<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/bootstrap.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<script data-require="angular.js@*" data-semver="1.3.9" src="https://code.angularjs.org/1.3.9/angular.js"></script>
<script data-require="angular.js@*" data-semver="1.3.9" src="https://code.angularjs.org/1.3.9/angular-messages.js"></script>

<script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="./js/angular-messages.js"></script>

<script type="text/javascript" src="./js/ui-bootstrap-tpls-0.12.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

</head>
<body ng-app="mainAngular">
	<header>
	  	<jsp:include page="/tiles/header.jsp"/>
	</header>
<div ng-controller="mainController">
	<div id="task-panel" class="fadein fadeout showpanel panel"  ng-show="toggle">
		<div class="panel-heading">
			<i class="panel-title-icon fa fa-tasks"></i>
			<span class="panel-title">All</span>
			<div class="panel-heading-controls">
				<button ng-click="reset()" class="btn-panel">Main</button>
			</div>
		</div>
		<div class="user">
			<table border ="1" align="center">
				<tr>
					
					<td>
						<a href="./Users.jsp" class="button-red" style="text-align:center;width:70px;margin-left:45%;margin-right:40%">Users</a>
						
						
					</td>
					<td>	
						<a href="./Groups.jsp" class="button-red" style="text-align:center;width:70px;margin-left:45%;margin-right:40%">Groups</a>	
					</td>
				</tr>
			</table>
		</div>	
	</div>
	
	<footer>
		<jsp:include page="/tiles/footer.jsp"/>
	</footer>
</body>
</html>