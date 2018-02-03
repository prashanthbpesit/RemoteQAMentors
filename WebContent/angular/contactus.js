mainApp.controller('ContactUsController', function($scope, $http) {
	document.getElementById("divconfirmaton").style.display="none";
	$scope.addsuggestion = function() {
		try {
			alert($scope.name + "======" + $scope.usermail + "===="+ $scope.phone + "========" + $scope.usercomments)
			$http.post("/RemoteQAMentors/rest/services/addSuggestion?name="+ $scope.name + "&usermail=" + $scope.usermail
							+ "&phone=" + $scope.phone + "&usercomments="+ $scope.usercomments).then(function(response) {
								clearSuggestion();
				$scope.ConfirmationMessage = response.data;
				alert("========" + $scope.ConfirmationMessage)
				document.getElementById("divconfirmaton").style.display="block";
			})
		} catch (err) {
			clearSuggestion();
			alert(err);
		}
	};
	
	function clearSuggestion(){
		try{
			$scope.name ="";
			$scope.usermail = "";
			$scope.phone = "";
			$scope.usercomments="";
		}catch(err){}
	}

});