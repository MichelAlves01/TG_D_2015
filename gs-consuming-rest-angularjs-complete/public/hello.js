(function() {
	  var app = angular.module('Hello', []);
	 
	  app.controller('Hello_App', function($scope, $http) {
		    $http.get('http://localhost:8080/greeting').
	        success(function(data) {
	            $scope.greeting = data;
	            
	        });
	  });
	})();

