(function(){
	var app = angular.module('cidadeEstadoService' , []);

	app.controller('CidadesEstados' , function($scope, $http){

		$scope.getEstados = function(){
			$http.get('http://localhost:8080/getEstados').success(function(data){
				$scope.estados = data;
			})
		}


		$scope.getCidades = function(){
			var idEstado = $.param({idEstado: $scope.estado.id});
			$http.get('http://localhost:8080/getCidades?' + idEstado).success(function(data){
				$scope.cidades = data;
			})
		}

		});

	})();