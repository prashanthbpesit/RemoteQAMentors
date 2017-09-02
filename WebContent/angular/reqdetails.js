mainApp.controller('RequestDetailsController', function($scope, $http) {
	getAllLists();
	
	function getAllLists(){
		try{
			getDemoReuestList();
			getSuggestionList();
			getFreeLancingList();
			getLiveWebList();
		}catch(err){
			alert(err);
		}
	}
	function getDemoReuestList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getDemoRequetDetails").then(
					function(response) {
						$scope.reqdata = response.data;
						$scope.demoRequestFilters();
					})
		} catch (err) {
			alert(err);
		}
	};
	 $scope.filteredRequestedData = []
	  ,$scope.requestedCurrentPage = 1
	  ,$scope.requestedNumPerPage = 10
	  ,$scope.requestedTotalcount = 5
	  ,$scope.requestedMaxSize = 5;
	 $scope.demoRequestFilters = function() {
		 $scope.totalcount = Math.ceil($scope.reqdata.length / $scope.requestedNumPerPage);
		 $scope.$watch("requestedCurrentPage + requestedTotalcount", function() {
			    var begin = (($scope.requestedCurrentPage - 1) * $scope.requestedNumPerPage);
			     var end = begin + $scope.requestedNumPerPage;
			    $scope.filteredRequestedData = $scope.reqdata.slice(begin, end);
			  })
	 }

	function getSuggestionList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getSuggestionDetails").then(
					function(response) {
						$scope.suggestiondata = response.data;
						$scope.suggestionDataFilters();
					})
		} catch (err) {
			alert(err);
		}
	};
	 $scope.filteredSuggestionData = []
	  ,$scope.suggestionCurrentPage = 1
	  ,$scope.suggestionNumPerPage = 10
	  ,$scope.suggestionTotalcount = 5
	  ,$scope.suggestionMaxSize = 5;
	 $scope.suggestionDataFilters = function() {
		 $scope.suggestionTotalcount = Math.ceil($scope.suggestiondata.length / $scope.suggestionNumPerPage);
		 $scope.$watch("suggestionCurrentPage + suggestionTotalcount", function() {
			    var begin = (($scope.suggestionCurrentPage - 1) * $scope.suggestionNumPerPage);
			     var end = begin + $scope.suggestionNumPerPage;
			    $scope.filteredSuggestionData = $scope.suggestiondata.slice(begin, end);
			  })
	 }
	
	
	function getFreeLancingList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getFreeLancingDetails").then(
					function(response) {
						$scope.freelancingdata = response.data;
						$scope.freelancingDataFilters();
					})
		} catch (err) {
			alert(err);
		}
	};
	 $scope.filteredFreeLancingData = []
	  ,$scope.freelancingCurrentPage = 1
	  ,$scope.freelancingNumPerPage = 10
	  ,$scope.freelancingTotalcount = 5
	  ,$scope.freelancingMaxSize = 5;
	 $scope.freelancingDataFilters = function() {
		 $scope.freelancingTotalcount = Math.ceil($scope.freelancingdata.length / $scope.freelancingNumPerPage);
		 $scope.$watch("freelancingCurrentPage + freelancingTotalcount", function() {
			    var begin = (($scope.freelancingCurrentPage - 1) * $scope.freelancingNumPerPage);
			     var end = begin + $scope.freelancingNumPerPage;
			    $scope.filteredFreeLancingData = $scope.freelancingdata.slice(begin, end);
			  })
	 }
	
	
	function getLiveWebList() {
		try {
			$http.post("/RemoteQAMentors/rest/services/getLiveWevDetails").then(
					function(response) {
						$scope.liewebdata = response.data;
						$scope.liveWebDataFilters();
					})
		} catch (err) {
			alert(err);
		}
	};
	 $scope.filteredlivewebData = []
	  ,$scope.livewebCurrentPage = 1
	  ,$scope.livewebNumPerPage = 10
	  ,$scope.livewebTotalcount = 5
	  ,$scope.livewebMaxSize = 5;
	 $scope.liveWebDataFilters = function() {
		 $scope.livewebTotalcount = Math.ceil($scope.liewebdata.length / $scope.livewebNumPerPage);
		 $scope.$watch("livewebCurrentPage + livewebTotalcount", function() {
			    var begin = (($scope.livewebCurrentPage - 1) * $scope.livewebNumPerPage);
			     var end = begin + $scope.livewebNumPerPage;
			    $scope.filteredlivewebData = $scope.liewebdata.slice(begin, end);
			  })
	 }
	
	
});