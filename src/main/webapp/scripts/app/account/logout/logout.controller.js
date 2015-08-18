'use strict';

angular.module('shoptellApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
