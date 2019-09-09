'use strict';

angular.module('myApp.deckList', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/DeckList', {
            templateUrl: 'DeckList/deck-list.html',
            controller: 'deckListCtrl'
        });
    }])

    .controller('deckListCtrl', function($rootScope, $scope) {
        $scope.deck = $rootScope.decklist;

        $scope.removeFromDeck = function(index)
        {
            $rootScope.decklist.splice(index, 1);
        }
        $scope.setCard = function(card)
        {
            $rootScope.selectedCard = card;
        }
    });
