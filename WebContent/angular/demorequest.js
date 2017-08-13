mainApp.controller('DemoRequestController', function($scope,  $http) {
$scope.demoRequest = function() {
	try {
		alert($scope.firstname+"====="+$scope.lastname+"======"+$scope.usermail+"===="+$scope.phone)
		 $http.post("/RemoteQAMentors/rest/services/demorequest?firstname="+$scope.firstname+"&lastname="+$scope.lastname
				 +"&usermail="+$scope.usermail+"&phone="+$scope.phone+"&usercomments="+$scope.usercomments).then(
				function(response) {
					$scope.values = response.data;
					alert("========"+$scope.values)
				}) 
	} catch (err) {
		alert(err);
	}
};


});