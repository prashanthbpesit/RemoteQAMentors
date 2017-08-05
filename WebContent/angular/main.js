var mainApp = angular.module("mainApp", ['ngRoute']);

mainApp.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'home.html',
		})
		.when('/viewStudents', {
			templateUrl: 'viewStudents.html',
		})
		.otherwise({
			redirectTo: '/home'
		});
});

