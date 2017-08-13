mainApp.controller('FreeLancingController', function($scope, $http) {

	$scope.registerLogin = function() {
		try {
			alert($scope.firstname+"====="+$scope.lastname+"======"+$scope.usermail+"===="+$scope.phone)
			 $http.post("/RemoteQAMentors/rest/services/enrollToFreeLancing?username="+$scope.username
					 +"&password="+$scope.userpassword+"&firstname="+$scope.firstname
					 +"&lastname="+$scope.lastname +"&usermail="+$scope.usermail
					 +"&phone="+$scope.phone+"&usercomments="+$scope.usercomments).then(
					function(response) {
						$scope.values = response.data;
						alert("========"+$scope.values)
					}) 
		} catch (err) {
			alert(err);
		}
	};

});