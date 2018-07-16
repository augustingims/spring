var app = angular.module('demoApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/Api',
    USER_SERVICE_API : 'http://localhost:8080/Api/app'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/templates/home.html',
                controller:'HomeController',
                controllerAs:'vm'
            });
        $urlRouterProvider.otherwise('/');
}]);
