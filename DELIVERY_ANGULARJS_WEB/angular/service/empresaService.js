(function(){
	var app = angular.module('empresaService' , []);
	var urlBase = 'http://localhost:8080';


	app.controller('cadastroEmpresaParte1', function($scope, $http) {
		     $http.defaults.headers.post["Content-Type"] = "application/jsonp";

		    $scope.iniciaCadastroEmpresa = function (){
		    	alert("task add" + $scope.nome + " e " + $scope.cpfCnpj);
		    	var data = $.param({nome: $scope.nome , cpfCnpj: $scope.cpfCnpj})

		    	$http.post(urlBase + '/iniciaCadastroEmpresa?'+ data).
	        													success(function(data,status) {
	           													 $scope.empresa = data;
	           													
	           													 location.href="CadastroEmpresas.html"
	            
	        });
		    }
		    
	  });

})();