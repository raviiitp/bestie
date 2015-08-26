/**
 * Created by ravi on 8/26/15.
 */
'use strict';



angular.module('bestie')
    .factory('CompanyService', function($rootScope, $resource){
        return {
            getParents: function(){
                return $resource('companyList/', {}, {
                    'query': {method: 'GET', isArray:true},
                    'get': {
                        method: 'GET',
                        isArray:true,
                        transformResponse: function (data) {
                            data = angular.fromJson(data);
                            return data;
                        }
                    }
                });
            },
            getChildren: function(pCatId){
                console.log(pCatId);
                return $resource('company/', {}, {
                    'query': {method: 'GET', isArray:true},
                    'getChildren': {
                        method: 'GET',
                        isArray: true,
                        params: {tag: 'ch', id: pCatId},
                        transformResponse: function (data) {
                            data = angular.fromJson(data);
                            return data;
                        }
                    }
                });
            },
            getCompany: function(catId){
                console.log(catId);
                return $resource('company/', {}, {
                    'query': {method: 'GET', isArray:true},
                    'getCompany': {
                        method: 'GET',
                        params: {tag: 'ct', id: catId},
                        transformResponse: function (data) {
                            data = angular.fromJson(data);
                            return data;
                        }
                    }
                });
            },
            saveCompany: function(){
                return $resource('company/insertCompany', {}, {
                     'saveCompany': {
                         method: 'POST'
                     }
                });
            }
        };
    });