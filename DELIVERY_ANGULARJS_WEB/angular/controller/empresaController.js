
(function() {
  var app = angular.module('Login', []);
 	var nome = "";
  app.controller('CadastrarEmpresaInicio', function ($scope){
     
     $scope.redirect = function(){    	
    	  nome = $scope.nome;
     	location.href="CadastroEmpresas.html"
     }
     
  });

})();
