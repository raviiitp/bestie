'use strict';

angular.module('bestie')
    .controller('homePageCtrl', function ($scope, $log, CompanyService) {
        console.log("homePageCtrl is called");
        $scope.showCompany = false;
        $scope.company = null;
        $scope.companyList = CompanyService.getParents().get();
        console.log($scope.companyList);

        $scope.getChildren = function(pCatId){
            console.log(pCatId);
            $scope.childrenCompany = CompanyService.getChildren(pCatId).getChildren();
            $scope.company = {};
            $scope.showCompany = false;
        };

        $scope.getCompany = function(catId){
            $scope.company = CompanyService.getCompany(catId).getCompany();
            $scope.showCompany = true;
        };

        $scope.saveCompany = function(newCompany){
            CompanyService.saveCompany().saveCompany({}, newCompany);
        };
    }
    );

