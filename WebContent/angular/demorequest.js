mainApp.controller('DemoRequestController', function($scope) {
$scope.registerLogin = function() {
	try {
		alert($scope.firstname+"====="+$scope.lastname+"======"+$scope.email+"===="+$scope.phone)
		 $http.post("/RemoteQAMentors/rest/services/demorequest?firstname="+$scope.firstname+"&lastname="+$scope.lastname
				 +"&email="+$scope.email+"&phone="+$scope.phone).then(
				function(response) {
					$scope.values = response.data;
					alert("========"+$scope.values)
				}) 
	} catch (err) {
		alert(err);
	}
};


});