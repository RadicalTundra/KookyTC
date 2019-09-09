'use strict';

angular.module('myApp.cardDetail', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/CardDetail', {
            templateUrl: 'CardDetail/card-detail.html',
            controller: 'cardDetailCtrl'
        });
    }])

    .controller('cardDetailCtrl', function($rootScope, $scope) {
        $scope.selectedCard = $rootScope.selectedCard;
        $scope.manaTypes = [];
        $scope.oracleTexts = [];
        if($scope.selectedCard.mana_cost)
        {
            $scope.manaTypes = $scope.selectedCard.mana_cost.split('{');
            $scope.manaTypes.splice(0, 1);
            for ( let color of $scope.manaTypes) {
                $scope.manaTypes[$scope.manaTypes.indexOf(color)] = color.substring(0, color.length - 1);
            }
            console.log($scope.manaTypes);
        }
        if ($scope.selectedCard.oracle_text) {
            $scope.oracleTexts = $scope.selectedCard.oracle_text.split(/\r?\n/);
            console.log($scope.oracleTexts);
        }
    });
