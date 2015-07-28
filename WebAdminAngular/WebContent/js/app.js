
var id_choos_project=null;

var id_choos_Dev = null;
var editUser = "";
var id_choos_task = null;
var id_choos_comment = null;

var user_choos_name=null;
var id_choos_user = null;
var original = [];


angular.module('mainAngular', ['ngAnimate'])
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
.controller('mainController', function ($scope,$http, pagination) {
	var urlBase="http://localhost:8080/WebAdminAngular";
	$scope.toggle=true;
	$scope.showUser=true;
		
/*	
	$scope.getGet = function (name) {
	    var s = window.location.search;
	    s = s.match(new RegExp(name + '=([^&=]+)'));
	    return s ? s[1] : false;
	}
	 
*/
/*
	
	$http.get(urlBase+'/users').
	success(function(data) {
        $scope.users1 = data;
        pagination.setUser(data);
        $scope.users = pagination.getPageUser();
        $scope.paginationList = pagination.getPaginationList();
        
	});
*/


	/* Show User*/
	$scope.showUser = function showUser(){
		$http.get(urlBase+'/users').
		success(function(data) {
	        $scope.users1 = data;
	        pagination.setUser(data);
	        $scope.users = pagination.getPageUser();
	        $scope.paginationList = pagination.getPaginationList();
	        
	        $scope.toggle=false;
			$scope.showUser=false;
		});
	};
	
	
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
	
	
	
	// Reset
	$scope.reset = function reset() {
		window.location='index.jsp';
	};
	
	//SHow user
	$scope.Show = function Show(id_user, user_name) {
	//	alert(getGet('u'));
	//	alert(id_user + "  "+user_name );
	//	getUserByName(id_choos_user, user_choos_name);
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
	
	
	// delete UserGroup
	$scope.deleteUserGroup = function deleteUserGroup(id_group, id_user) {
		
	//	alert(id_group + "  "+id_user);
	//	
	//	$scope.toggle=false;
	//	$scope.editUserView=false;
		
		
		
			$http.get(urlBase+'/user/deleteGroup/' + id_group + '/' + id_user).
			success(function(data) {
		     //  $scope.deleteUserGroup = data;    
		  
			});
		
	//		Show(1,'dasd');
		
	};
	
	
	
	//Edit user
	$scope.editUser = function editUser(user_name, first_name, last_name, email, id_user) {
		
		//alert(user_name);
		
			alert( user_name+ " - " + first_name +" - " +last_name +" - "+ email +" - " + id_user );
			
			$http.post(urlBase+'/user/edit/' + user_name + '/' + first_name + '/' + last_name + '/' + email + '/' + id_user).
			success(function(data) {
		        $scope.getUserByName = data;
		        
		    //    $scope.toggle=true;
			//	$scope.editUserView=true;
				    
			});
		        
	};
	
	
	//AddUserGroup
	$scope.addUserGroup = function addUserGroup(id_group, id_user) {
		
	//	alert(id_group +" "+id_user);
		
			$http.post(urlBase + '/add/user/group/'+id_group+'/'+id_user).
			  success(function(data) {
			//	  alert("Comment is add");
				
				 
				  //id_choos_user = null;
				 // $scope.managerProject = false;
			  });
			       
	};
	
		
	
	
});