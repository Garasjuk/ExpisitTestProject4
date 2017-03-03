var id_choos_user = null;
var countUser = 0;

angular.module('usersAngular', ['ngAnimate'])

.filter('startFrom', function(){
  return function(input, start){
    start = +start;
    return input.slice(start);
  }
})
.controller('usersController', function ($scope,$http) {
	var urlBase="http://localhost:8080/UsersAndGroups";
	$scope.toggle=true;
	$scope.userChoos=true;
	$scope.FormEditPass=true;

	var param = window
    .location
    .search
    .replace('?','')
    .split('&')
    .reduce(
        function(p,e){
            var a = e.split('=');
            p[ decodeURIComponent(a[0])] = decodeURIComponent(a[1]);
            return p;
        },
        {}
    ); 

	if (param['id_user'] != null)
	{
		$http.get(urlBase+'/userChoos/' + param['id_user']).
		success(function(data) {
	        $scope.userById = data;
		});
		
		$http.get(urlBase+'/groupNoUser/' + param['id_user']).
		success(function(data) {
			$scope.groupNoUser = data;
		});
		
		$http.get(urlBase+'/groupUser/' + param['id_user']).
		success(function(data) {
			$scope.groupUser = data;
			$scope.toggle=false;
			$scope.userChoos=false;
		});
	}
	else
	{
		$scope.currentPage = 0;
		$scope.itemsPerPage = 5;
		
		$http.get(urlBase+'/users').
		success(function(data) {
	        $scope.users = data;
	        $scope.items = data;
	        
		});
		
		
		
//		Pagination
		$scope.firstPage = function() {
			return $scope.currentPage == 0;
		}
		$scope.lastPage = function() {
			var lastPageNum = Math.ceil($scope.items.length / $scope.itemsPerPage - 1);
			return $scope.currentPage == lastPageNum;
		}
		$scope.numberOfPages = function(){
		  return Math.ceil($scope.items.length / $scope.itemsPerPage);
		}
		$scope.startingItem = function() {
		  return $scope.currentPage * $scope.itemsPerPage;
		}
		$scope.pageBack = function() {
		  $scope.currentPage = $scope.currentPage - 1;
		}
		$scope.pageForward = function() {
		  $scope.currentPage = $scope.currentPage + 1;
		}
		
		
		
		
		
	}

	// Reset
	$scope.reset = function reset() {
		window.location='listUser.jsp';
	};
		
	// ChoosUser
	$scope.choosUser = function choosUser(id_user) {

		$http.get(urlBase+'/userChoos/' + id_user).
		success(function(data) {
	        $scope.userById = data;
	      
		});
		
		$http.get(urlBase+'/groupNoUser/' + id_user).
		success(function(data) {
			$scope.groupNoUser = data;
		});
		
		$http.get(urlBase+'/groupUser/' + id_user).
		success(function(data) {
			$scope.groupUser = data;
			$scope.toggle=false;
			$scope.userChoos=false;
		});

	};
	
	// Add New User
	$scope.addNewUser = function addNewUser() {
		if($scope.new_login_user == null || $scope.new_pass_user == null || $scope.new_last_name == null || $scope.new_first_name == null ){
					alert("Insufficient Data! Please provide values");
		}else{
			$http.post(urlBase + '/user/insert/' + $scope.new_login_user + '/' + $scope.new_pass_user + '/' + $scope.new_last_name + '/' + $scope.new_first_name + '/' + $scope.new_date_birthday).
			success(function(data) {
		    });
			window.location='listUser.jsp';
		}
	};
	
	// Add New User
	$scope.updateUser = function updateUser(id_user) {
		if($scope.userById.login_user == null || $scope.userById.last_name == null || $scope.userById.first_name == null || $scope.userById.date_birthday == null ){
					alert("Insufficient Data! Please provide values");
		}else{
			$http.post(urlBase + '/user/update/' + $scope.userById.login_user + '/'  + $scope.userById.last_name + '/' + $scope.userById.first_name + '/' + $scope.userById.date_birthday + '/' + id_user).
			success(function(data) {
		    });
			window.location='listUser.jsp';
		}
	};

	// Edit Password
	$scope.editPass = function editPass(id_user) {
		id_choos_user = id_user;
		$scope.userChoos=true;
		$scope.FormEditPass=false;
	};
	
	// Edit Password
	$scope.updatePass = function updatePass() {
	if ($scope.pass_1 == $scope.pass_2)
	{
		alert("Pass true ");
		$scope.userChoos=false;
		$scope.FormEditPass=true;
	}
	else
		{
		alert("Pass false ");
		}
	};
	
	// Open Group
	$scope.openGroup = function openGroup(id_group) {
		window.location='listGroup.jsp?id_group=' + id_group;
	};
	
//	Delete User
	$scope.deleteUser = function deleteUser(id_user) {
		$http.post(urlBase + '/user/delete/' + id_user).
		success(function(data) {
	    });
	};
	
//	Delete Group User
	$scope.deleteGroupUser = function deleteGroupUser(id_group, id_user) {
		$http.post(urlBase + '/user/delete/group/'+ id_group + '/' + id_user).
		success(function(data) {
	    });
	};
	
//	Add Group User
	$scope.addGroupUser = function addGroupUser(id_group, id_user) {
		$http.post(urlBase + '/user/insert/group/' + id_group + '/' + id_user ).
		success(function(data) {
	    });
	};
	
	// Choos Group
	$scope.choosGroup = function choosGroup(id_group) {
		$http.get(urlBase+'/groupChoos/' + id_group).
		success(function(data) {
			 $scope.groupById = data;
		});
		
		$http.get(urlBase+'/userGroup/' + id_group).
		success(function(data) {
			$scope.userGroup = data;
			 $scope.toggle = false;
			 $scope.groupChoos = false;
		});
	};

});


