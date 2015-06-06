(function(){
	var app = angular.module('empresaService' , []);
	var urlBase = 'http://localhost:8080';


	app.controller('cadastroEmpresaParte1', function($scope, $http) {
		     $http.defaults.headers.post["Content-Type"] = "application/jsonp";
		     var statusCpfCnpj = null;
		    
		    $scope.iniciaCadastroEmpresa = function (){
		    	var data = $.param({nome: $scope.nome , cpfCnpj: $scope.cpfCnpj})

		    	if(statusCpfCnpj == 1){
		    	$http.post(urlBase + '/iniciaCadastroEmpresa?'+ data).
	        													success(function(data,status) {
	           													 $scope.empresa = data;
	           													
	           													 location.href="CadastroEmpresas.html"
	           			});
	            } else {
	            	alert("cpf ou cnpj invalido!!!");
	        	}
		    }	

		    $scope.validaCpfCnpj = function(){

		    	if($scope.cpfCnpj.length == 11){
		    		var strCPF = $scope.cpfCnpj;
		    		var Soma; 
		    		var Resto; 
		    		Soma = 0; 
		    		if (strCPF == "00000000000") return false;

		    		for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i); Resto = (Soma * 10) % 11; 
		    		
		    		if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		    			if (Resto != parseInt(strCPF.substring(9, 10)) ) return false; 
		    			
		    			Soma = 0; 
		    			for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i); Resto = (Soma * 10) % 11; 
		    			
		    			if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		    			if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false; 
		    			statusCpfCnpj = 1;	
		    			return true;
		    		
		    	} 

		    	if($scope.cpfCnpj.length == 14){

		    		var cnpj = $scope.cpfCnpj;
		    		cnpj = cnpj.replace(/[^\d]+/g,'');
		    		alert(cnpj);

				    if(cnpj == '') return false;

				    if (cnpj.length != 14)
				        return false;

				    // LINHA 10 - Elimina CNPJs invalidos conhecidos
				    if (cnpj == "00000000000000" || 
				        cnpj == "11111111111111" || 
				        cnpj == "22222222222222" || 
				        cnpj == "33333333333333" || 
				        cnpj == "44444444444444" || 
				        cnpj == "55555555555555" || 
				        cnpj == "66666666666666" || 
				        cnpj == "77777777777777" || 
				        cnpj == "88888888888888" || 
				        cnpj == "99999999999999")
				        return false; // LINHA 21

				    // Valida DVs LINHA 23 -
				    tamanho = cnpj.length - 2
				    numeros = cnpj.substring(0,tamanho);
				    digitos = cnpj.substring(tamanho);
				    soma = 0;
				    pos = tamanho - 7;
				    for (i = tamanho; i >= 1; i--) {
				      soma += numeros.charAt(tamanho - i) * pos--;
				      if (pos < 2)
				            pos = 9;
				    }
				    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
				    if (resultado != digitos.charAt(0))
				        return false;

				    tamanho = tamanho + 1;
				    numeros = cnpj.substring(0,tamanho);
				    soma = 0;
				    pos = tamanho - 7;
				    for (i = tamanho; i >= 1; i--) {
				      soma += numeros.charAt(tamanho - i) * pos--;
				      if (pos < 2)
				            pos = 9;
				    }
				    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
				    if (resultado != digitos.charAt(1))
				          return false; // LINHA 49
				    statusCpfCnpj = 1;	
				    return true; // LINHA 51

				}
		    	
		    }
		    
	  });




})();