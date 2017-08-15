mainApp.controller('RequestDetailsController', function($scope, $http) {
	getList();

	function getList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getDemoRequest").then(
					function(response) {
						$scope.mydata = response.data;
					})
		} catch (err) {
			alert(err);
		}
	};
	
});