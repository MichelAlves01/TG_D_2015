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

		$scope.getLatitudeLongitude = function(){
					var myLatlng = new google.maps.LatLng(-23.5505199,-46.63330939999997);
					var valorZoom;
					if($scope.estado == null){
						valorZoom = 4;
					} else {
						valorZoom = 15;
					}
					var mapOptions = {
					    zoom: valorZoom,
					    center: myLatlng
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
				   		var latLong = results[0].geometry.location;
				   		console.log(latLong);
				   		var resLatLong = latLong.toString().split(","); 
				   		var latitude = resLatLong[0].replace("(", ""); 
				   		var longitude = resLatLong[1].replace(")", "");

				   	var marker = new google.maps.Marker({
					     position: latLong,
					     map: map,
					     draggable:true,
    					animation: google.maps.Animation.DROP
					  });

				    } else {
				      alert('Geocode was not successful for the following reason: ' + status);
				    }
				  });
		}

		});




	})();