
(function() {
  var app = angular.module('Login', ['empresaService']);
 	var nome = "";
  
  app.controller('CadastrarEmpresaInicio', function ($scope){
     
     $scope.redirect = function(){    	
    	  nome = $scope.nome;
     	location.href="CadastroEmpresas.html"
     }

     $scope.inicioCadastro = function(){
     	alert("deu bom até aqui");
     	iniciaCadastroEmpresa.dadosCadastro({nome: $scope.nome, cpfCnpj: $scope.cpfCnpj});
     }
     
  });

})();
