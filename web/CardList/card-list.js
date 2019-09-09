'use strict';

angular.module('myApp.cardList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CardList', {
    templateUrl: 'CardList/card-list.html',
    controller: 'cardListCtrl'
  });
}])

.controller('cardListCtrl', function($scope, $http, $rootScope) {
  $scope.searchCardName = '';
  $scope.cards = [];
  $scope.cardNames = [];

  $scope.searchCards = function()
  {
    $scope.cards = [];
    var params = {
      name: $scope.searchCardName
    }
    console.log($scope.searchCardName);
    $http({
      method: 'get',
      url: ($scope.searchCardName === '') ? 'https://api.scryfall.com/cards' :
          'https://api.scryfall.com/cards/search?q=' + $scope.searchCardName + '&unique=cards&as=grid&order=name',
      params: params
    }).then(function (response) {
      if (response.data.object === 'list' || response.data.object === 'catalog') {
        // @ts-ignore
        $scope.cards = response.data.data;
        console.log($scope.cards);
      }
      console.log(response);
    });
  }
  $scope.addToDeck = function(newCard)
  {
    $rootScope.decklist.push(newCard);
    console.log($rootScope.decklist);
  }
  angular.element(document).ready(function()
  {
    $http({
      method: 'get',
      url: 'https://api.scryfall.com/cards',
    }).then(function (response) {
      console.log(response);
      $scope.cards = response.data.data;
    });
  });
  $scope.autocomplete = function() {
    if ($scope.searchCardName.length > 3) {
      var params = {
        name: $scope.searchCardName
      }
      $http({
        method: 'get',
        url: 'https://api.scryfall.com/cards/autocomplete?q=' + $scope.searchCardName,
        params: params
      }).then(function (response) {
        console.log(response);
        $scope.cardNames = response.data.data;
      });
    }
  }
  $scope.setCard = function(card)
  {
    $rootScope.selectedCard = card;
  }
});
