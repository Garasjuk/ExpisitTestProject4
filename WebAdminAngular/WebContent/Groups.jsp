<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Groups</title>
<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/bootstrap.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<script data-require="angular.js@*" data-semver="1.3.9" src="https://code.angularjs.org/1.3.9/angular.js"></script>
<script data-require="angular.js@*" data-semver="1.3.9" src="https://code.angularjs.org/1.3.9/angular-messages.js"></script>

<script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="./js/angular-messages.js"></script>

<script type="text/javascript" src="./js/appg.js"></script>
<script type="text/javascript" src="./js/ui-bootstrap-tpls-0.12.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
function check_telephone(){
	
	reg = /[\0-9\-\+\(\)]/;
	if(!document.editGroupForm.newGroup_name.value.match(reg)){
	//	alert("BGraf");
		return false;
	}
}

 
function validatorGroupName(input) { 
	input.value = input.value.replace(/[^\d,a-z,A-Z,\.,\,,\-]/g, '');
} 

function validatorFirstName(input) { 
	input.value = input.value.replace(/[^а-я,А-Я,\s,\-]/g, '');
} 

function validatorLastName(input) { 
	input.value = input.value.replace(/[^а-я,А-Я]/g, '');
} 


</script>

</head>
<body ng-app="groupsAngular">
	<header>
	  	<jsp:include page="/tiles/header.jsp"/>
	</header>
<div ng-controller="groupsController">
		<div id="task-panel" class="fadein fadeout showpanel panel"  ng-show="toggle">	
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i>
				<span class="panel-title">All groups</span>
				<div class="panel-heading-controls">
					<button ng-click="mainz()" class="btn-panel">Main</button>
				</div>
			</div>
			<div class="user">
				
				<button class="btn  btn-danger" ng-click="addGroupsForms()" ><span class="glyphicon glyphicon-plus"></span> Add </button>
				<div class="group" ng-repeat="group in groupList">					
						<button class="btn  btn-danger" ng-click="deleteGroup(group.id_group); reset()" ><span class="glyphicon glyphicon-minus"></span> Del </button>
					<button class="btn btn-primary btn-lg" ng-mouseenter="Show(group.id_group, group.name_group)"  ng-click="getGroupByName()">{{group.id_group}}  {{group.name_group}} </button>					
				</div>	
				<div class="pagination-wrap">
				    <ul class="pagination pagination-centered">
				        <li class="mypointer" ng-repeat="page in paginationList" ng-click="showPage(page.link)" ng-class="{'active':currentPageNum()==page.link}">
				          <a ng-bind-html="page.name"></a>
				        </li>
				    </ul>
				  </div>
					
			</div>
		</div>
		<div id="task-panel" class="fadein fadeout showpanel panel"  ng-hide="editGroupView">	
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i>
				<span class="panel-title">All users</span>
				<div class="panel-heading-controls">
					<button ng-click="mainz()" class="btn-panel">Main</button>
				</div>
			</div>
			<div class="user">
				<button class="btn  btn-success" ng-click="editGroupName(getGroupByName.id_group, getGroupByName.name_group); start()">Save group name</button>
				<form name="editGroupForm" >
					<table border="0" align="center">
						<tr>
							<td width="100">
							</td>
							<td width="300" align="center">
								<h3>
									<span class="label label-invers">Group name</span>
								</h3>
							</td>
							<td width="400">
								<input type="text" class="form-control" style="font-size: 16pt; height: 30pt;" ng-minlength="4" ng-maxlength="20" name="newGroup_name" ng-model="getGroupByName.name_group" required onkeyup="return validatorGroupName(this)"/>
								<div class="alert alert-danger well-sm" ng-show="editGroupForm.newGroup_name.$error.required">Поле не может быть пустым!</div>
								<div class="alert alert-danger well-sm" ng-show="editGroupForm.newGroup_name.$error.maxlength">Поле не может быть больше 20 символов!</div>
								<div class="alert alert-danger well-sm" ng-show="editGroupForm.newGroup_name.$error.minlength">Поле не может быть меньше 4 символов!</div>
							</td>
						</tr>
						
						
							<tr>
							<td>
							</td>
							<td>
								<h2><span class="label label-warning">Users in group</span></h2>
								<br/>
							</td>
							<td>
								<h2><span class="label label-warning">Other users</span></h2>
								<br/>
							
							</td>

						</tr>
						<tr>	
							<td>	
								      
							</td>
							<td>
								<div style="display: inline-block;" class="GroupUserByID" ng-repeat="GroupUserByID in getGroupUserByID">
									 
									<button class="btn btn-primary btn-lg"  ng-mousedown="deleteGroupUser(GroupUserByID.id_user,getGroupByName.id_group); start()"><b>{{GroupUserByID.id_user}} </b> {{GroupUserByID.user_name}} </button>
									<!--
									<button ng-click="Show(1,'ere')"><b>{{UserGroupByID.id_group}} </b> {{UserGroupByID.name_group}} </button>
									
									-->
								</div>
							</td>
							<td width="300" align="center">
								<div style="display: inline-block;" class="NoGroupUserByID" ng-repeat="NoGroupUserByID in getNoGroupUserByID">
									<div class="panel panel-default">
										<input type="radio" ng-change="choosTask(NoGroupUserByID.id_user)" ng-model="id_user" name="id_user" ng-value="{{NoGroupUserByID.id_user}}" />{{NoGroupUserByID.user_name}}
										<button class="btn-lg" ng-mousedown="addGroupUser(NoGroupUserByID.id_user,getGroupByName.id_group); start()" ng-mouseup="getUserByName()"><b>{{NoGroupUserByID.id_user}} </b> {{NoGroupUserByID.user_name}} </button>
										<br/>
										<button class="btn-warning" ng-click="editUser(NoGroupUserByID.user_name)">Edit</button>
										<button class="btn-danger" ng-click="deleteUser(NoGroupUserByID.id_user) ">Delete </button>
									</div>
								
								</div>
							</td>
							
						</tr>
						
					</table>
					
				</form>	
					
			</div>
		</div>
		<div id="task-panel" class="fadein fadeout showpanel panel"  ng-hide="editUserView">	
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i>
				<span class="panel-title">All users</span>
				<div class="panel-heading-controls">
					<button ng-click="mainz()" class="btn-panel">Main</button>
				</div>
			</div>
			<div class="user">
				<button class="btn  btn-success" ng-click="editUserName(getUserByName.user_name, getUserByName.first_name, getUserByName.last_name, getUserByName.email, getUserByName.id_user); start()">Save user name</button>
				<form name="editUserForm"  >
					<table border="0" align="center">
						<tr>
							<td width="100">
							</td>
							<td width="300" align="center">
								<h3>
									<span class="label label-invers">User name</span>
								</h3>
							</td>
							<td width="400">
							
    						
									<input type="text" class="form-control" style="font-size: 16pt; height: 30pt;"  ng-minlength="4" ng-maxlength="20" name="newUser_name" ng-model="getUserByName.user_name" required onkeyup="return validatorUserName(this)"/>
									<div class="alert alert-danger well-sm" ng-show="editUserForm.newUser_name.$error.required">Поле не может быть пустым!</div>
									<div class="alert alert-danger well-sm" ng-show="editUserForm.newUser_name.$error.maxlength">Поле не может быть больше 20 символов!</div>
									<div class="alert alert-danger well-sm" ng-show="editUserForm.newUser_name.$error.minlength">Поле не может быть меньше 4 символов!</div>
								
								
							</td>
						</tr>
						<tr>	
							<td>
							</td>
							<td align="center">
								<h3>
									<span class="label label-invers">First Name</span>
								</h3>
							</td>
							<td>
								<input type="text" class="form-control" name="newFirst_name" style="font-size: 16pt; height: 30pt;" ng-minlength="2" ng-maxlength="20" placeholder="First Name" ng_model="getUserByName.first_name" required onkeyup="return validatorFirstName(this)"/>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newFirst_name.$error.required">Поле не может быть пустым!</div>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newFirst_name.$error.maxlength">Поле не может быть больше 20 символов!</div>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newFirst_name.$error.minlength">Поле не может быть меньше 2 символов!</div>
							</td>
						</tr>
						<tr>	
							<td>
							</td>
							<td align="center">
								<h3>
									<span class="label label-invers">Last name</span>
								</h3>  
							</td>
							<td>
								<input type="text" class="form-control" name="newLast_name" style="font-size: 16pt; height: 30pt;" ng-minlength="2" ng-maxlength="20" ng_model="getUserByName.last_name" onkeyup="return validatorLastName(this)"/>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newLast_name.$error.required">Поле не может быть пустым!</div>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newLast_name.$error.maxlength">Поле не может быть больше 20 символов!</div>
								<div class="alert alert-danger well-sm" ng-show="editUserForm.newLast_name.$error.minlength">Поле не может быть меньше 2 символов!</div>
							</td>
						</tr>
						<tr>	
							<td>
							</td>
							<td align="center">
								<h3>	
									<span class="label label-invers">Email</span>
								</h3>      
							</td>
							<td>
								<h3>
									<input type="email" class="form-control" name="newEmail" style="font-size: 16pt; height: 30pt;" ng-minlength="3" ng-maxlength="30" ng_model="getUserByName.email" ng-pattern="/^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/" required/>
									<div class="alert alert-danger well-sm" ng-show="editUserForm.newEmail.$error.required">почтовый ящик не может быть пустым!</div>
						   			<div class="alert alert-danger well-sm" ng-show="editUserForm.newEmail.$error.email">почтовый ящик не правильный формат!</div>
						   			<div class="alert alert-danger well-sm" ng-show="editUserForm.newEmail.$error.maxlength">Поле не может быть больше 30 символов!</div>
									<div class="alert alert-danger well-sm" ng-show="editUserForm.newEmail.$error.minlength">Поле не может быть меньше 3 символов!</div>
								</h3>
							</td>
						</tr>
					
					</table>
				</form>	
			</div>
		</div>
		<div id="task-panel" class="fadein fadeout showpanel panel"  ng-hide="addGroupView">	
			<div class="panel-heading">
				<i class="panel-title-icon fa fa-tasks"></i>
				<span class="panel-title">Add group</span>
				<div class="panel-heading-controls">
					<button ng-click="mainz()" class="btn-panel">Main</button>
				</div>
			</div>
			<div class="user">
				<button class="btn  btn-success" ng-click="addGroups(); reset()">Save group name</button>
				<form name="addGroupForms" >
					<table border="0" align="center">
						<tr>
							<td width="100">
							</td>
							<td width="300" align="center">
								<h3>
									<span class="label label-invers">Group name</span>
								</h3>
							</td>
							<td width="400">
								<input type="text" class="form-control" style="font-size: 16pt; height: 30pt;" ng-minlength="4" ng-maxlength="20" name="newGroup_name" placeholder="Group Name" ng-model="addGroup.name_group" required onkeyup="return validatorGroupName(this)"/>
								<div class="alert alert-danger well-sm" ng-show="addGroupForms.newGroup_name.$error.required">Поле не может быть пустым!</div>
								<div class="alert alert-danger well-sm" ng-show="addGroupForms.newGroup_name.$error.maxlength">Поле не может быть больше 20 символов!</div>
								<div class="alert alert-danger well-sm" ng-show="addGroupForms.newGroup_name.$error.minlength">Поле не может быть меньше 4 символов!</div>
							</td>
						</tr>
						
					</table>
					
				</form>	
					
			</div>
		</div>

</div>
	<footer>
		<jsp:include page="/tiles/footer.jsp"/>
	</footer>
</body>
</html>