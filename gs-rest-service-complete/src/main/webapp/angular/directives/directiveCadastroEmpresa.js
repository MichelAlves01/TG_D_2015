(function(){
	var app = angular.module('cadastro-empresa-pages',[]);

	app.directive('form', function(){
		return{
			restrict: 'A',
			templateUrl: 'view-cadastro/cadastro-empresa.html'
		};
	});

	app.directive('preenchido', function(){
		return{
			restrict: 'A',
			templateUrl: 'view-cadastro/cadastro-empresa-preenchido.html'
		};
	});

	app.directive('mapa', function(){
		return{
			restrict: 'A',
			templateUrl: 'view-cadastro/mapa.html'
		};
	});
	
	app.directive('buttons', function(){
		return{
			restrict: 'A',
			templateUrl: 'view-cadastro/buttons.html'
		};
	});

})();