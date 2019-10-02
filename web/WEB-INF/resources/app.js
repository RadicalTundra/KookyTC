'use strict';

// Declare app level module which depends on views, and core components
var app = angular.module('myApp', [
  'ngRoute',
  'myApp.cardList',
  'myApp.home',
  'myApp.deckList',
  'myApp.cardDetail',
  'myApp.version',
  'ui.bootstrap'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/Home'});
}]);

app.run(function ($rootScope){
  $rootScope.decklist = [];
  $rootScope.selectedCard = [];
});
