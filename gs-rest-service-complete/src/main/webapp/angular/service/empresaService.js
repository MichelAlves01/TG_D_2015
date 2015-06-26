(function(){
	var app = angular.module('empresaService' , []);
	var urlBase = 'http://localhost:8080';
	
	

	app.controller('cadastroEmpresaInicio', function($scope, $http) {
		    $http.defaults.headers.post["Content-Type"] = "application/jsonp";
		    var statusCpfCnpj = false;
		    var longitude = null;
		    var latitude = null;
		    var latLongTest = null;
			var latLong = null; 

		    $scope.iniciaCadastroEmpresa = function (){
		    	var data = $.param({nome: $scope.nome , cpfCnpj: $scope.cpfCnpj})

		    	if(statusCpfCnpj && $scope.nome != null){
		    	$http.post(urlBase + '/iniciaCadastroEmpresa?'+ data).
	        													success(function(data,status) {
	           													 location.href="CadastroEmpresas.html"
	           			});
	            } else {
	            	if(!statusCpfCnpj){
	            		alert("cpf ou cnpj invalido!!!");
	            	}
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
		    			statusCpfCnpj = true;	
		    			return true;
		    		
		    	} else  

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
				    statusCpfCnpj = true;	
				    return true; // LINHA 51

				} else {
					statusCpfCnpj = false;
				}
		    	
		    }

		    $scope.isValidCpfCnpj = function(){
		    	return statusCpfCnpj;
		    }
		    
	  });


		app.controller('cadastroEmpresaFim', function($scope, $http) {
			 

			/*verifica quais abas devem estar ativas*/
			$scope.finishing = function(){
					$http.get(urlBase + '/getEmpresaCadastro').success(function(data){
					$scope.empresa = data;

					if($scope.empresa.tipo == null){
		    			$("#cadastro").removeAttr("disabled");
		    			$("#atualizar").hide();
		    			$("#excluir").hide();
		    		} else {
		    			/*To do*/
		    		}
					
				});
			}

			$scope.executarCadastro = function(){
				var tipo = $scope.tipo;
				var cidade = $scope.cidade.id;
				var endereco = $scope.bairro + "" + $scope.endereco + "" + $scope.numero;
				var cep = $scope.cep;
				var telFixo = $scope.telFixo;
				var telMovel = $scope.telMovel;
				var email = $scope.email;
				var senha = $scope.senha;		
				var data = $.param({tipo: tipo, 
									idCidade: cidade,
									endereco: endereco,
									email: email,
									telefoneFixo: telFixo,
									telefoneMovel: telMovel,
									cep: cep,
									latitude: latitude,
									longitude: longitude,
									senha: senha});
				var teste = urlBase + '/cadastrarEmpresaController?' + data;
				alert(teste.length);
				$http.post(urlBase + '/cadastrarEmpresaController?' + data).success();
			}	

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

		/*Obtem informações de latitude e longitude e atualiza o mapa */
		$scope.getLatitudeLongitude = function(){
					latLong = new google.maps.LatLng(-23.5505199,-46.63330939999997);
					var valorZoom;
					if($scope.estado == null){
						valorZoom = 4;
					} else {
						valorZoom = 15;
					}
					var mapOptions = {
					    zoom: valorZoom,
					    center: latLong
					  }

					var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
					var geocoder = new google.maps.Geocoder();

					if($scope.estado != null){
						var estado = $scope.estado.nome;
						var cidade = $scope.cidade.nome;
						var bairro = $scope.bairro;
						var endereco = $scope.endereco;
						var numero = $scope.numero;
						var address = estado + ", " + cidade + ", " + bairro + ", " + endereco;
					} else {
						var address = "Brasil , Brasilia";
					}

				  	geocoder.geocode( { 'address': address}, function(results, status) {
				    if (status == google.maps.GeocoderStatus.OK) {
				      	map.setCenter(results[0].geometry.location);
				   		latLong = results[0].geometry.location;
				   		console.log(latLong);
				   		var resLatLong = latLong.toString().split(","); 
				   		latitude = resLatLong[0].replace("(", ""); 
				   		longitude = resLatLong[1].replace(")", "");

				   	if(address != "Brasil , Brasilia"){	
				   	var marker = new google.maps.Marker({
					     position: latLong,
					     map: map,
					     draggable:true,
    					animation: google.maps.Animation.DROP
					  });
					  }

					

				    } else {
				      alert('Geocode was not successful for the following reason: ' + status);
				    }
				  });
		}

		/*Validaçoes de campos no cadastro de empresas*/
		$scope.isValidTipo = function(){			
			if($scope.tipo != null){
				return true;
			} else {
				return false;
			}
		}

		$scope.isValidCidade = function(){
			if($scope.cidade != null){
				return true;
			} else {
				return false;
			}
		}

		latLongTest = new google.maps.LatLng(0,0);
		var typeNeighBor = null;
		$scope.isValidBairro = function(){
		if(typeNeighBor == $scope.bairro || typeNeighBor == null){
			if(	latLong.A.toFixed(1) != latLongTest.A.toFixed(1) && 
				latLong.F != latLongTest.F && 
				latLongTest.A != 0 && 
				latLongTest.F != 0 && 
				$scope.bairro != null){

				typeNeighBor = $scope.bairro;
				return true;
			} else {
				latLongTest = alterLatLongTest();
				return false;
			}
		} else {
				latLongTest = alterLatLongTest();
				typeNeighBor = null;
				return false;
		}

		function alterLatLongTest(){
			var la = latLong.A;
			var lo = latLong.F;
			return new google.maps.LatLng(la,lo); 
		}
		}

		$scope.isValidEndereco = function(){
			if($scope.endereco != null){
				return true;
			} else {
				return false;
			}
		}

		$scope.isValid = function(){
			if($scope.numero != null){
				return true;
			} else {
				return false;
			}
		}
		
		});

})();