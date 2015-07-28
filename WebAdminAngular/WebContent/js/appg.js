
var id_choos_project=null;

var id_choos_Dev = null;
var editUser = "";
var id_choos_task = null;
var id_choos_comment = null;

var group_choos_name = null; 
var id_choos_group = null;



angular.module('groupsAngular', ['ngAnimate'])
	.factory('pagination', function($sce){
		var currentPage = 0;
		var countPerPage  = 10;
		var groupList = [];
		
		  return {
	          setGroups: function(newGroups){
	             groupList = newGroups;
	          },

	          getPageGroups: function(num){
	             var num = angular.isUndefined(num) ? 0 : num;
	             var first = countPerPage * num;
	             var last = first + countPerPage;
	            currentPage = num;
	            last = last > groupList.length ? (groupList.length - 1) : last;
	            return groupList.slice(first,last);
	          }, 

	          getTotalPagesNum: function(){
	            return Math.ceil(groupList.length/countPerPage);
	          }, 

	          getPaginationList: function(){
	            var pagesNum = this.getTotalPagesNum();
	            var paginationList =[];
	            paginationList.push({
	                name: $sce.trustAsHtml('&laquo;'),
	                link: 'prev'
	            });
	            for (var i=0;i<pagesNum;i++){
	              var name = i + 1;
	              paginationList.push({
	                name: $sce.trustAsHtml(String(name)),
	                link: i
	              });
	            };
	            paginationList.push({
	                name: $sce.trustAsHtml('&raquo;'),
	                link: 'next'
	            }); 
	            if (pagesNum > 1){
	              return paginationList;
	            }else{
	              return false;
	            }
	          } ,

	          getCurrentPageNum: function(){
	            return currentPage;
	          },

	          getPrevPageGroups: function(){
	            var prevPageNum = currentPage - 1;
	            if(prevPageNum < 0)prevPageNum = 0;
	            return this.getPageGroups(prevPageNum);
	          },

	          getNextPageGroups: function(){
	            var nextPageNum = currentPage + 1;
	            var pagesNum = this.getTotalPagesNum();
	            if(nextPageNum >=pagesNum )nextPageNum = pagesNum - 1;
	            return this.getPageGroups(nextPageNum);
	          } 
	      }
	})




.controller('groupsController', function ($scope,$http, pagination) {
	var urlBase="http://localhost:8080/WebAdminAngular";
	$scope.toggle=true;
	$scope.editGroupView = true;
	$scope.editUserView = true;
	$scope.addGroupView = true;
	
	

	$http.get(urlBase+'/groups').
	success(function(data) {
		
        $scope.groups1 = data;
        pagination.setGroups(data);
        $scope.groupList = pagination.getPageGroups();
        $scope.paginationList = pagination.getPaginationList();
        
         
	});
	
	$scope.showPage = function(page) {
		if ( page == 'prev' ) {
			$scope.groupList = pagination.getPrevPageGroups();
		} else if ( page == 'next' ) {
			$scope.groupList = pagination.getNextPageGroups();
		} else {
			$scope.groupList = pagination.getPageGroups( page );
		}
	}

	$scope.currentPageNum = function() {
		return pagination.getCurrentPageNum();
	}
	
	// Mainz
	$scope.mainz = function mainz() {
		window.location='index.jsp';
	};
	
	// Reset
	$scope.reset = function reset() {
		window.location='Groups.jsp';
	};
	
	//SHow grup
	$scope.Show = function Show(id_group,name_group) {

		group_choos_name = name_group; 
		id_choos_group = id_group;
		
	};
	
	// Start
	$scope.start = function start() {
			
			$http.get(urlBase+'/group/getByName/' + group_choos_name).
			success(function(data) {
		        $scope.getGroupByName = data;    
			});
			
			$http.get(urlBase+'/groupUser/getByID/' + id_choos_group).
			success(function(data) {
		        $scope.getGroupUserByID = data;	    
			});
			
			$http.get(urlBase+'/noGroupUser/getByID/' + id_choos_group).
			success(function(data) {
		        $scope.getNoGroupUserByID = data;	    
			}); 
	};
	
	//Edit group name
	$scope.editGroupName = function editGroupName(id_group, name_group) {
			
			$http.post(urlBase+'/group/edit/name/' + id_group + '/' + name_group).
			success(function(data) {
			
			});      
	};
	
	
	//Edit user
	$scope.editUser = function editUser(user_name) {
		
		$http.get(urlBase+'/user/getByName/' + user_name).
		success(function(data) {
	        $scope.getUserByName = data;    
		});
		
		$scope.editGroupView = true;
		$scope.editUserView = false;
			     
	};
	
	$scope.editUserName = function editUserName(user_name, first_name, last_name, email,id_user){
		$http.post(urlBase+'/user/edit/' + user_name + '/' + first_name + '/' + last_name + '/' + email + '/' + id_user).
		success(function(data) {    
		}); 
		$scope.editGroupView = false;
		$scope.editUserView = true;
	};
	
	// getGroupByName
	$scope.getGroupByName = function getGroupByName() {
			$scope.toggle=false;
			$scope.editGroupView=false;
			
			$http.get(urlBase+'/group/getByName/' + group_choos_name).
			success(function(data) {
		        $scope.getGroupByName = data;    
			});
			
			$http.get(urlBase+'/groupUser/getByID/' + id_choos_group).
			success(function(data) {
		        $scope.getGroupUserByID = data;	    
			});
			
			$http.get(urlBase+'/noGroupUser/getByID/' + id_choos_group).
			success(function(data) {
		        $scope.getNoGroupUserByID = data;	    
			}); 
	};
	
	//AddGroupUser
	$scope.addGroupUser = function addGroupUser(id_user, id_group) {
		
			$http.post(urlBase + '/add/group/user/'+id_user+'/'+id_group).
			  success(function(data) {
			
			  });      
	};
	
	// delete GroupUser
	$scope.deleteGroupUser = function deleteGroupUser(id_user, id_group) {
	
			$http.get(urlBase+'/group/deleteUser/' + id_user + '/' + id_group).
			success(function(data) {  
		  
			});	
	};
	
	// delete Group
	$scope.deleteGroup = function deleteGroup(id_group) {
			
			$http.get(urlBase+'/group/delete/' + id_group).
			success(function(data) {
			});
		
	};
	
	// delete User
	$scope.deleteUser = function deleteUser(id_user) {
			
			$http.get(urlBase+'/user/delete/' + id_user).
			success(function(data) {
			});
		
	};
	
	//AddGroupForm
	$scope.addGroupsForms = function addGroupsForms() {
			
		$scope.toggle=false;
		$scope.addGroupView=false;
		
	};
	
	//AddGroup
	$scope.addGroups = function addGroups(){
		if($scope.addGroup.name_group == "" ){
			alert("Insufficient Data! Please provide values for name comment, description ");
		}
		else{
		$http.post(urlBase + '/add/group/' +$scope.addGroup.name_group).
		  success(function(data) {
			  alert("Group  is add");
			  $scope.addGroup.group_name = "";
	
		  });
		}
		$scope.toggle=true;
		$scope.addGroupView=true;
	};
	
	
	
	
});

