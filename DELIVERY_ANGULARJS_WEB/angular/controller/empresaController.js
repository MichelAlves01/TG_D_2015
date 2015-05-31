
(function() {
  var app = angular.module('Login', ['empresaService' , 'Login-Pages']);
 	var nome = "";
  
  app.controller('CadastrarEmpresaInicio', function ($scope){
     
     $scope.redirect = function(){    	
    	  nome = $scope.nome;
     	
     }

     $scope.inicioCadastro = function(){
     	alert("deu bom até aqui");
     	cadastroEmpresaParte1.iniciaCadastroEmpresa();
     }
     
  });



})();
