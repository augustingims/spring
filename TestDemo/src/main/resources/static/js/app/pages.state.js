(function() {
    'use strict';

    angular
        .module('demoApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider,$urlRouterProvider) {
    	$urlRouterProvider.otherwise("/home");
        $stateProvider.state('home', {
            parent: 'app',
            url: '/home',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: '/views/home.html',
                    controller: 'HomeController',
                    controllerAs: 'vm'
                }
            }
        }).state('login', {
            parent: 'app',
            url: '/login',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: '/views/login.html',
                    controller: 'LoginController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();