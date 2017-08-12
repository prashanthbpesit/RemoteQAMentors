mainApp.controller('ContactUsController', function($scope, $http) {
	$scope.addsuggestion = function() {
		try {
			alert($scope.name + "======" + $scope.usermail + "===="
					+ $scope.phone + "========" + $scope.usercomments)
			$http.post("/RemoteQAMentors/rest/services/addSuggestion?name="
							+ $scope.name + "&usermail=" + $scope.usermail
							+ "&phone=" + $scope.phone + "&usercomments="
							+ $scope.usercomments).then(function(response) {
				$scope.values = response.data;
				alert("========" + $scope.values)
			})
		} catch (err) {
			alert(err);
		}
	};

});