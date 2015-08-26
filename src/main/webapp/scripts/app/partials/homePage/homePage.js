'use strict';

angular.module('bestie')
    .config(function ($stateProvider) {
        $stateProvider
            .state('homePage', {
                parent: 'site',
                url: '/',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: '/scripts/app/partials/homePage/homePage.html',
                        controller: 'homePageCtrl'
                    }
                },
                resolve: {
                }
            });
    });