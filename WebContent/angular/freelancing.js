mainApp.controller('FreeLancingController', function($scope, $http) {
	document.getElementById("divlancingconfirmaton").style.display="none";
	$scope.registerLogin = function() {
		try {
			alert($scope.firstname+"======"+$scope.usermail+"===="+$scope.phone)
			 $http.post("/RemoteQAMentors/rest/services/enrollToFreeLancing?firstname="+$scope.firstname+"&usermail="+$scope.usermail
					 +"&phone="+$scope.phone+"&usercomments="+$scope.usercomments).then(
					function(response) {
						clearFreelancing();
						$scope.ConfirmationMessage = response.data;
						alert("========" + $scope.ConfirmationMessage)
						document.getElementById("divlancingconfirmaton").style.display="block";
					}) 
		} catch (err) {
			clearFreelancing();
			alert(err);
		}
	};
	function clearFreelancing(){
		try{
			$scope.firstname ="";
			$scope.usermail = "";
			$scope.phone = "";
			$scope.usercomments="";
		}catch(err){}
	}
});