'use strict';

angular.module('myApp.deckList', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/DeckList', {
            templateUrl: 'resources/DeckList/deck-list.html',
            controller: 'deckListCtrl'
        });
    }])

    .controller('deckListCtrl', function($rootScope, $scope, $http) {
        $scope.deck = $rootScope.decklist;

        $scope.removeFromDeck = function(index)
        {
            $rootScope.decklist.splice(index, 1);
        }
        $scope.setCard = function(card)
        {
            $rootScope.selectedCard = card;
        }
        $scope.saveDeck = function(deck)
        {
            console.log(deck);
            $http({
                method: 'POST',
                url: "Advanced_Java_war_exploded/saveDeck",
                spell_count: "5"
            }).then(function successCallBack(response){
                    console.log(response);
            }, function errorCallBack(response){
               console.log(response);
            });
        }
    });
