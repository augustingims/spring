var app = angular.module('demoApp', []);
app.controller('postcontroller', function($scope, $http, $location) {
	var vm = this;
	
	vm.personne = {};
	 
	vm.submitForm = function(){
		var url = $location.absUrl() + "app/save";
	
		$http.post(url, vm.personne).then(function (response) {
			$scope.postResultMessage = response.data;
			 vm.personne = {};
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
});

app.controller('getcontroller', function($scope, $http, $location) {
	var vm = this;
	
	vm.getfunction = function(){
		var url = $location.absUrl() + "app/findall";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	
	vm.getfunction();
});
app.controller('HomeController', function($scope, $http, $location) {
	var vm = this;
	
	
});