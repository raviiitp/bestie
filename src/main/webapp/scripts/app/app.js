'use strict';

angular.module('bestie', ['ui.router', 'ngResource'])
.config(function ($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider) {

		//enable CSRF
		$httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
		$httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

		$locationProvider.html5Mode(true);

		$urlRouterProvider.otherwise('/');
        $stateProvider.state('site', {
        'abstract': true,
        views: {
            'navbar@': {
                templateUrl: 'scripts/components/navbar/navbar.html',
                //controller: 'NavbarController'
            },
            'footer@':{
                templateUrl: 'scripts/components/footer/footer.html',
            }
        },
            resolve: {
            }
    });
})
;
