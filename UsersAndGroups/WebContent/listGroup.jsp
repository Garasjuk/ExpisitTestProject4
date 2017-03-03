<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups</title>
<link href='./css/bootstrap.css' rel="stylesheet" type="text/css"></link>
<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.3.0"
	src="./js/angular.js"></script>
<script data-require="angular-animate@*" data-semver="1.3.0"
	src="./js/angular-animate.js"></script>
<script type="text/javascript" src="./js/appg.js"></script>

</head>
</head>

<body ng-app="groupsAngular">
	<header> <jsp:include page="/tiles/header.jsp" /> </header>
	<div ng-controller="groupsController">
		<div id="task-panel" class="fadein fadeout showpanel panel"
			ng-show="toggle">
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i> <span
					class="panel-title">Groups</span>
			</div>
			<div class="panel-body">
				<center>
					<div id="content">
						<div class="group" ng-repeat="group in groups | startFrom: startingItem() | limitTo: itemsPerPage">
							<br>
							<div class="btn-group">
								<input type="button" class="btn btn-info" ng-click="choosGroup(group.id_group)" value="{{group.name_group}}" /> 
								<input type="button" class="btn btn-info" ng-click="deleteGroup(group.id_group);reset()" value="X" />
							</div>
						</div>
						<div id="pagination" class="row">
						    <button class="pull-left btn btn-primary btn-sm" ng-disabled="firstPage()" ng-click="pageBack()">Ago</button>
						    <span>{{currentPage+1}} из {{numberOfPages()}}</span>
						    <button class="pull-right  btn btn-primary btn-sm" ng-disabled="lastPage()" ng-click="pageForward()">Forward</button>
					    </div>
					</div>
				</center>
				<hr>
				<div class="form-group">
	 				<label for="group">Add new group:</label>
	 				<input type="text"  ng-model="name_new_group">
	 				<input type="button"ng-click="addNewGroup();reset()" class="btn btn-success" value="Add">
				</div>
			</div>
		</div>
		<div id="group-choos" class="fadein fadeout addpanel panel"
			ng-hide="groupChoos">
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-plus"></i> <span
					class="panel-title">Group</span>
				<div class="panel-heading-controls">
					<button ng-click="reset()" class="btn-panel">Show All
						group</button>
				</div>
			</div>

			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-body">
						<button ng-click="reset()" class="btn-panel"><<< Back
							Spase</button>
						<center>
							<div>
								<label>Name</label>
								<input type="text" ng-model="groupById.name_group">
									
							</div>
							<input type="button" class="btn btn-warning" ng-click="updateGroup(groupById.id_group); reset()" value="Save" />
						</center>
						<hr>

				<table >
					<tr>
						<th>
							<label for="group">Users in group:</label>
						</th>
						<th>
						</th>
						<th>
							<label for="group">User out group:</label>
						</th>
					</tr>
					<tr>
						<td>						
						<div ng-repeat="user in userGroup">
							<div class="btn-group">
								<input type="button" class="btn btn-info" ng-click="openUser(user.id_user)" value="{{user.login_user}}" />
								<input type="button" class="btn btn-info" ng-click="deleteGroupUser(groupById.id_group, user.id_user);choosGroup(groupById.id_group)" value="&gt;" />
							</div>	
						</div>
						<td width="70%"></td>
						<td>
						<div ng-repeat="userNo in userNoGroup">
							<div class="btn-group">
								<input type="button" class="btn btn-info" ng-click="addGroupUser(groupById.id_group, userNo.id_user);choosGroup(groupById.id_group)" value="&lt;" />
								<input type="button" class="btn btn-info" ng-click="openUser(userNo.id_user)" value="{{userNo.login_user}}" />
							</div>	
						</div>
						</td>
					</tr>
				</table>	
					</div>
				</div>
			</div>
		</div>
	</div>


	<footer> <jsp:include page="/tiles/footer.jsp" /> </footer>
</body>
</html>