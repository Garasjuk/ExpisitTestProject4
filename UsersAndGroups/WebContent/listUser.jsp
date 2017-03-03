<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Web Base</title>
<link href='./css/bootstrap.css' rel="stylesheet" type="text/css"></link>
<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.3.0"
	src="./js/angular.js"></script>
<script data-require="angular-animate@*" data-semver="1.3.0"
	src="./js/angular-animate.js"></script>
<script type="text/javascript" src="./js/app.js"></script>

<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>


  <script>
  
</script>
</head>
</head>

<body ng-app="usersAngular">
	<header> <jsp:include page="/tiles/header.jsp" /> </header>
	<div ng-controller="usersController">
		<div id="mainn-panel" class="fadein fadeout showpanel panel"
			ng-show="toggle">
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i> <span
					class="panel-title">Users List</span>
			</div>
			<div class="panel-body">
				<center>
				
					<div id="content">
						<div class="users" ng-repeat="user in users | startFrom: startingItem() | limitTo: itemsPerPage">
							<br>
							<div class="btn-group">
								<input type="button" class="btn btn-info" ng-click="choosUser(user.id_user)" value="{{user.login_user}}" />
								<input type="button" class="btn btn-info" ng-click="deleteUser(user.id_user);reset()" onclick="return confirm('Delte ?')" value="X" />
							</div>
						</div>
						
	    				<div id="pagination" class="row">
						    <button class="pull-left btn btn-primary btn-sm" ng-disabled="firstPage()" ng-click="pageBack()">Ago</button>
						    <span>{{currentPage+1}} from {{numberOfPages()}}</span>
						    <button class="pull-right  btn btn-primary btn-sm" ng-disabled="lastPage()" ng-click="pageForward()">Forward</button>
					    </div>
					</div>
				</center>
				<hr>
				<center>
				<div class="form-user">
					<label for="user">Add new user:</label>
					<form action="newUserForm">
						<input type="text" required id="new_login_user" ng-model="new_login_user" placeholder="Login"  />
						<br>	
						<input type="password" required id="new_pass_user" ng-model="new_pass_user" placeholder="Password" /> 
						<br>
						<input type="text" required id="new_last_name" ng-model="new_last_name" placeholder="Last name"  /> 
						<br>
						<input type="text" required id="new_first_name" ng-model="new_first_name" placeholder="First name"  /> 
						<br>
						<input type="date" ng-model="new_date_birthday"  placeholder="YYYY-MM-DD"/>
						<br>
						<input type="button" id="submit" ng-click="addNewUser()" class="btn btn-success" value="Add">
					</form>
				</div>
				</center>
			</div>
		</div>
		<div id="user-choos" class="fadein fadeout addpanel panel" ng-hide="userChoos">
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-plus"></i> <span
					class="panel-title">User Choosed</span>
				<div class="panel-heading-controls">
					<button ng-click="reset()" class="btn-panel">Show All
						Users</button>
				</div>
			</div>
			<div class="panel-body">
				<button ng-click="reset()" class="btn-panel"><<< Back Spase</button>
				<center>
				<table>
					<tr>
						<td>
							<label>Login</label>
						</td>
						<td>
								<input type="text" ng-model="userById.login_user"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>Last name</label>
						</td>
						<td>
								<input type="text" ng-model="userById.last_name"/>
						</td>
					</tr>
					<tr>
						<td>	
							<label>First name</label>
						</td>
						<td>
							<input type="text" ng-model="userById.first_name"/>
						</td>
					</tr>
					<tr>	
						<td>
							<label>Date birthday</label>
						</td>
						<td>
							<input type="text" id="date_birthday" ng-model="userById.date_birthday"/>
						</td>
					</tr>	
					
				</table>
				<br>
					<input type="button" class="btn btn-primary" ng-click="editPass(userById.id_user)" value="Edit Password" />
					<br>
					<input type="button" class="btn btn-warning" ng-click="updateUser(userById.id_user)" value="Save" />
				</center>
				<hr>
				
				<table align="center"  >
					<tr >
						<th >
							<label for="group">Yoyr groups:</label>
						</th>
						<th width="30%"></th>
						<th >
							<label for="group">Other groups:</label>					
						</th>						
					</tr>
					<tr>
						<td >
							<div ng-repeat="group in groupUser">
								<div class="btn-group">
										<input type="button" class="btn btn-info" ng-click="openGroup(group.id_group)" value="{{group.name_group}}" />
										<input type="button" class="btn btn-info" ng-click="deleteGroupUser(group.id_group, userById.id_user); choosUser(userById.id_user)" value="&gt;" />
								</div>
							</div>
						</td>
						<td >
						</td>
						<td >
							<div ng-repeat="groupNo in groupNoUser">
								<div class="btn-group" >
										<input type="button" class="btn btn-info" ng-click="addGroupUser(groupNo.id_group, userById.id_user); choosUser(userById.id_user)" value="&lt;" />
										<input type="button" class="btn btn-info" ng-click="openGroup(groupNo.id_group)" value="{{groupNo.name_group}}" />
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="pass-user" class="fadein fadeout addpanel panel" ng-hide="FormEditPass">
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-plus"></i> <span class="panel-title">Edit Password User</span>
				<div class="panel-heading-controls">
					<button ng-click="reset()" class="btn-panel">Show All Users</button>
				</div>
			</div>
			<div class="panel-body">
				<button ng-click="reset()" class="btn-panel"> <<< Back Spase</button>
				<center>
				<table>
					<tr>
						<td>
							<label>New pass</label>
						</td>
						<td>
							<input type="password" ng-model="pass_1"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>Repeat</label>
						</td>
						<td>
								<input type="password" ng-model="pass_2"/>
						</td>
					</tr>
				</table>
				<br>
					<input type="button" class="btn btn-warning" ng-click="updatePass()" value="Save Password" />
				</center>
				<hr>
				
				
			</div>
		</div>
	</div>
	<footer> <jsp:include page="/tiles/footer.jsp" /> </footer>
</body>
</html>