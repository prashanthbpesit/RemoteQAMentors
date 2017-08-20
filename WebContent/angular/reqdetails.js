mainApp.controller('RequestDetailsController', function($scope, $http) {
	getDemoReuestList();
	getSuggestionList();
	getFreeLancingList();
	getLiveWebList();

	function getDemoReuestList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getDemoRequetDetails").then(
					function(response) {
						$scope.reqdata = response.data;
						//$scope.makeTodos();
					})
		} catch (err) {
			alert(err);
		}
	};
	
	
	 $scope.filteredRequestedData = []
	  ,$scope.currentPage = 1
	  ,$scope.numPerPage = 5
	  ,$scope.maxSize = 5;
	 
	 $scope.numPages = function () {
		    return Math.ceil($scope.reqdata.length / $scope.numPerPage);
		  };
		  
	 $scope.makeTodos = function() {
		  $scope.$watch("currentPage + numPages", function() {
			    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
			    , end = begin + $scope.numPerPage;

			    $scope.filteredRequestedData = $scope.reqdata.slice(begin, end);
			  })
			  
			  
	 }

	
	
	
	
	function getSuggestionList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getSuggestionDetails").then(
					function(response) {
						$scope.suggestiondata = response.data;
					})
		} catch (err) {
			alert(err);
		}
	};
	function getFreeLancingList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getFreeLancingDetails").then(
					function(response) {
						$scope.freelancingdata = response.data;
					})
		} catch (err) {
			alert(err);
		}
	};
	function getLiveWebList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getLiveWevDetails").then(
					function(response) {
						$scope.liewebdata = response.data;
					})
		} catch (err) {
			alert(err);
		}
	};
});