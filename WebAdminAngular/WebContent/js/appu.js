
var id_choos_project=null;

var id_choos_Dev = null;
var editUser = "";
var id_choos_task = null;
var id_choos_comment = null;

var user_choos_name=null;
var id_choos_user = null;
var original = [];




angular.module('usersAngular', ['ngAnimate'])

	.factory('pagination', function($sce){
		var currentPage = 0;
		var itemsPerPage = 10	;
		var users = [];
		
		return {
			setUser:function(newUser) {
				users = newUser;
			},
			getPageUser:function(num) {
				var num= angular.isUndefined(num)?0:num;
				var first = itemsPerPage*num;
				var last = first + itemsPerPage;
				currentPage = num;
				last = last >users.length?(users.length -1):last;
				return users.slice(first, last);	
			},
			getTotalPagesNum: function() {
				return Math.ceil( users.length / itemsPerPage );
			}, /* END of getTotalPagesNum */

			getPaginationList: function() {
				var pagesNum = this.getTotalPagesNum();
				var paginationList = [];
				paginationList.push({
					name: $sce.trustAsHtml('&laquo;'),
					link: 'prev'
				});
				for (var i = 0; i < pagesNum; i++) {
					var name = i + 1;
					paginationList.push({
						name: $sce.trustAsHtml( String(name) ),
						link: i
					});
				};
				paginationList.push({
					name: $sce.trustAsHtml('&raquo;'),
					link: 'next'
				});
				if (pagesNum > 2) {
					return paginationList;
				} else {
					return null;
				}
			}, /* END of getPaginationList */

			getPrevPageUser: function() {
				var prevPageNum = currentPage - 1;
				if ( prevPageNum < 0 ) prevPageNum = 0;
				return this.getPageUser( prevPageNum );
			}, /* END of getPrevPageUser */

			getNextPageUser: function() {
				var nextPageNum = currentPage + 1;
				var pagesNum = this.getTotalPagesNum();
				if ( nextPageNum >= pagesNum ) nextPageNum = pagesNum - 1;
				return this.getPageUser( nextPageNum );
			}, /* END of getNextPageUser */

			getCurrentPageNum: function() {
				return currentPage;
			}, /* END of getCurrentPageNum */
		}
	})
	
	
	
.controller('usersController', function ($scope,$http, pagination) {
	var urlBase="http://localhost:8080/WebAdminAngular";
	$scope.toggle=true;
	$scope.editUserView=true;
	$scope.groupView=true;
	$scope.editGroupView=true;
	$scope.addUserView=true;
	
		
/*	
	$scope.getGet = function (name) {
	    var s = window.location.search;
	    s = s.match(new RegExp(name + '=([^&=]+)'));
	    return s ? s[1] : false;
	}
	 
*/

	
	$http.get(urlBase+'/users').
	success(function(data) {
        $scope.users1 = data;
        pagination.setUser(data);
        $scope.users = pagination.getPageUser();
        $scope.paginationList = pagination.getPaginationList();
	});
	
	$scope.showPage = function(page) {
		if ( page == 'prev' ) {
			$scope.users = pagination.getPrevPageUser();
		} else if ( page == 'next' ) {
			$scope.users = pagination.getNextPageUser();
		} else {
			$scope.users = pagination.getPageUser( page );
		}	
	}

	$scope.currentPageNum = function() {
		return pagination.getCurrentPageNum();
	}
	
	
	$scope.showGroup = function showGroup() {
	$http.get(urlBase+'/groups').
	success(function(data) {
		
		
        $scope.groups1 = data;
        pagination.setUser(data);
        $scope.groupList = pagination.getPageUser();
        $scope.paginationList = pagination.getPaginationList();
        
        $scope.toggle=false;
    	$scope.groupView=false;
		});
	};
	
	$scope.showPageG = function(page) {
		if ( page == 'prev' ) {
			$scope.groupList = pagination.getPrevPageUser();
		} else if ( page == 'next' ) {
			$scope.groupList = pagination.getNextPageUser();
		} else {
			$scope.groupList = pagination.getPageUser( page );
		}	
	}
	
	// Main
	$scope.mainz = function mainz() {
		window.location='index.jsp';
	};
	
	// Reset
	$scope.reset = function reset() {
		window.location='Users.jsp';
	};
	
	//SHow user
	$scope.Show = function Show(id_user, user_name) {
	
		user_choos_name = user_name; 
		id_choos_user = id_user;
		
	};
	
	
	
	//Start
	
	$scope.start = function start() {
	
		$http.get(urlBase+'/user/getByName/' + user_choos_name).
		success(function(data) {
	        $scope.getUserByName = data;
	        $scope.original = data;
	        
		});
		
		$http.get(urlBase+'/userGroup/getByID/' + id_choos_user).
		success(function(data) {
	        $scope.getUserGroupByID = data;	    
		});
		
		$http.get(urlBase+'/noUserGroup/getByID/' + id_choos_user).
		success(function(data) {
	        $scope.getNoUserGroupByID = data;	    
		}); 
		
	};
	
	//Check User Name
	$scope.checkUserName = function checkUserName(){
		
		$http.get(urlBase+'/user/getByName/' + $scope.addUser.user_name).
		success(function(data) {
			
	       if ( data.user_name != null ){
	    	   alert("Name is not correct!");
	    	   document.getElementById("newUser_name").focus();
	       }    
		});
	}
	
	
	// getUserByName
	$scope.getUserByName = function getUserByName() {
		
			
			$scope.toggle=false;
			$scope.editUserView=false;
			
			$http.get(urlBase+'/user/getByName/' + user_choos_name).
			success(function(data) {
		        $scope.getUserByName = data;    
			});
			
			$http.get(urlBase+'/userGroup/getByID/' + id_choos_user).
			success(function(data) {
		        $scope.getUserGroupByID = data;	    
			});
			
			$http.get(urlBase+'/noUserGroup/getByID/' + id_choos_user).
			success(function(data) {
		        $scope.getNoUserGroupByID = data;	    
			}); 
		
	};
	
	//deleteGroup
	$scope.deleteGroup = function deleteGroup(id_group) {
		
		$http.get(urlBase+'/group/delete/' + id_group).
		success(function(data) {
		});
	
};
	
	
	// delete UserGroup
	$scope.deleteUserGroup = function deleteUserGroup(id_group, id_user) {
			$http.get(urlBase+'/user/deleteGroup/' + id_group + '/' + id_user).
			success(function(data) {
			});
	};
	
	
	
	// delete User
	$scope.deleteUser = function deleteUser(id_user) {
			
			$http.get(urlBase+'/user/delete/' + id_user).
			success(function(data) {
			});
		
	};
	
	//Edit user
	$scope.editUser = function editUser(user_name, first_name, last_name, email, id_user) {
			
			$http.post(urlBase+'/user/edit/' + user_name + '/' + first_name + '/' + last_name + '/' + email + '/' + id_user).
			success(function(data) {

			});      
	};

	//Edit group
	$scope.editGroup = function editGroup(name_group) {
		
		$http.get(urlBase+'/group/getByName/' + name_group).
		success(function(data) {
	        $scope.getGroupByName = data;    
		});
		$scope.editUserView=true;
		$scope.editGroupView=false;
	};
	
	
	//Edit group name
	$scope.editGroupName = function editGroupName(id_group, name_group) {
		
			
			$http.post(urlBase+'/group/edit/name/' + id_group + '/' + name_group).
			success(function(data) {
			
			$scope.editUserView=false;
			$scope.editGroupView=true;  
		   
			});      
	};
	
	//AddUserGroup
	$scope.addUserGroup = function addUserGroup(id_group, id_user) {
			$http.post(urlBase + '/add/user/group/'+id_group+'/'+id_user).
			  success(function(data) {
			  });	       
	};
	
	//AddUserForm
	$scope.addUserForms = function addUserForms() {
			
		$scope.toggle=false;
		$scope.addUserView=false;
		
	};
	
	//AddUser
	$scope.addUser = function addUser(){
		if($scope.addUser.user_name == "" || $scope.addUser.first_name == ""){
			alert("Insufficient Data! Please provide values for name comment, description ");
		}
		else{
		$http.post(urlBase + '/add/user/' +$scope.addUser.user_name+'/'+$scope.addUser.first_name+'/'+$scope.addUser.last_name+'/'+$scope.addUser.email).
		  success(function(data) {
			  alert("User  is add");
			  $scope.addUser.user_name = "";
			  $scope.addUser.first_name = "";
			  $scope.addUser.last_name = "";
			  $scope.addUser.email = "";
			
	 
			  
		  });
		}
		$scope.toggle=true;
		$scope.addUserView=true;
	};
		
	
	
});