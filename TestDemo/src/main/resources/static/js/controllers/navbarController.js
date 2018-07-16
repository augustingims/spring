(function() {
    'use strict';

    angular
        .module('demoApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state'];

    function NavbarController ($state) {
        var vm = this;

        vm.isNavbarCollapsed = true;
       

        vm.logout = logout;
        vm.toggleNavbar = toggleNavbar;
        vm.collapseNavbar = collapseNavbar;
        vm.$state = $state;

        function logout() {
            collapseNavbar();
            $state.go('home');
        }

        function toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }

        function collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }
    }
})();
