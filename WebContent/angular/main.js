var mainApp = angular.module("mainApp", ['ngRoute','ui.bootstrap']);
mainApp.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'home.html',
			controller: 'HomeController'
		})
		.when('/aboutus', {
			templateUrl: 'aboutus.html',
			controller: 'AboutUsController'
		})
		.when('/blog', {
			templateUrl: 'blog.html',
			controller: 'BlogController'
		})
		.when('/contactus', {
			templateUrl: 'contactus.html',
			controller: 'ContactUsController'
		})
		.when('/earningsdisclaimer', {
			templateUrl: 'earnigsdisclaimer.html',
			controller: 'EarningDisclaimerController'
		})
		.when('/faq', {
			templateUrl: 'faq.html',
			controller: 'FAQController'
		})
		.when('/freelancingcourse', {
			templateUrl: 'freelancingcourse.html',
			controller: 'FreeLancingController'
		})
		.when('/privacypolicy', {
			templateUrl: 'privacypolicy.html',
			controller: 'PrivacyPolicyController'
		})
		.when('/recordedwebtraining', {
			templateUrl: 'recordedwebtraining.html',
			controller: 'RecordedWebController'
		})
		.when('/requestfordemo', {
			templateUrl: 'requestfordemo.html',
			controller: 'DemoRequestController'
		})
		.when('/reqdetails', {
			templateUrl: 'reqdetails.html',
			controller: 'RequestDetailsController'
		})
		.otherwise({
			redirectTo: '/home'
		});
});