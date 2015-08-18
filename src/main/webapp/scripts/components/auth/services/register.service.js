'use strict';

angular.module('shoptellApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


