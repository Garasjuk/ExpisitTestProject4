var name_choos_group = "";

angular.module('groupsAngular', ['ngAnimate'])
.filter('startFrom', function(){
  return function(input, start){
    start = +start;
    return input.slice(start);
  }
})
.controller('groupsController', function ($scope,$http) {
	var urlBase="http://localhost:8080/UsersAndGroups";
	$scope.toggle = true;
	$scope.groupChoos = true;
	
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
	
	if (param['id_group'] != null)
	{
		$http.get(urlBase+'/groupChoos/' + param['id_group']).
		success(function(data) {
			 $scope.groupById = data;
		});
		
		$http.get(urlBase+'/userNoGroup/' + param['id_group']).
		success(function(data) {
			$scope.userNoGroup = data;
		});

		$http.get(urlBase+'/userGroup/' + param['id_group']).
		success(function(data) {
			$scope.userGroup = data;
			 $scope.toggle = false;
			 $scope.groupChoos = false;
		});
	}	
	else
	{
		

		$scope.currentPage = 0;
		$scope.itemsPerPage = 5;
		
		$http.get(urlBase+'/groups').
		success(function(data) {
	        $scope.groups = data; 
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
		window.location='listGroup.jsp';
	};
	
	
	// getNameGroup
	$scope.getNameGroup = function getNameGroup (name_group) {
		alert(name_group);
		name_choos_group = name_group;
	};
	
	// Choos Group
	$scope.choosGroup = function choosGroup(id_group) {
		$http.get(urlBase+'/groupChoos/' + id_group).
		success(function(data) {
			 $scope.groupById = data;
		});
		
		$http.get(urlBase+'/userNoGroup/' + id_group).
		success(function(data) {
			$scope.userNoGroup = data;
		});

		$http.get(urlBase+'/userGroup/' + id_group).
		success(function(data) {
			$scope.userGroup = data;
			 $scope.toggle = false;
			 $scope.groupChoos = false;
		});
	};
	
	// Add New Group
	$scope.addNewGroup = function addNewGroup(name_new_group) {
		 if($scope.name_new_group == null){
					alert("Insufficient Data! Please provide values for group name");
		}else{
			$http.post(urlBase + '/group/insert/' + $scope.name_new_group).
			success(function(data) {
		    });
		}
	};
	
	// Update Group
	$scope.updateGroup = function updateGroup(id_group) {
		 if($scope.groupById.name_group == null){
					alert("Insufficient Data! Please provide values for group name");
		}else{
			$http.post(urlBase + '/group/update/' + $scope.groupById.name_group + '/' + id_group).
			success(function(data) {
		    });
		}
	};
	
//	Delete Group
	$scope.deleteGroup = function deleteGroup(id_group) {
		$http.post(urlBase + '/group/delete/' + id_group).
		success(function(data) {
	    });
	};
	
//		Delete Group User
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

	// Open User
	$scope.openUser = function openUser(id_user) {
		window.location='listUser.jsp?id_user=' + id_user;
	};
	
});
