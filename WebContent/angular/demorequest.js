mainApp.controller('DemoRequestController', function($scope,  $http) {
document.getElementById("divreqconfirmaton").style.display="none";
$scope.demoRequest = function() {
	try {
		alert($scope.firstname+"====="+$scope.usermail+"===="+$scope.phone)
		 $http.post("/RemoteQAMentors/rest/services/demorequest?firstname="+$scope.firstname+"&usermail="+$scope.usermail
				 +"&phone="+$scope.phone+"&usercomments="+$scope.usercomments).then(
				function(response) {
					clearRequest();
					$scope.ConfirmationMessage = response.data;
					alert("========" + $scope.ConfirmationMessage)
					document.getElementById("divreqconfirmaton").style.display="block";
				}) 
	} catch (err) {
		clearRequest();
		alert(err);
	}
};


function clearRequest(){
	try{
		$scope.firstname ="";
		$scope.usermail = "";
		$scope.phone = "";
		$scope.usercomments="";
	}catch(err){
		
	}
}

});