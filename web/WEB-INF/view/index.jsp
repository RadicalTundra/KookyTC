<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>My AngularJS App</title>
    <meta name="description" content="">
    <script src="resources/lib/angular/angular.js"></script>
    <script src="resources/lib/angular-route/angular-route.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-animate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-touch/1.7.8/angular-touch.js"></script>
    <script src="resources/lib/uib/ui-bootstrap-tpls-2.5.0.min.js"></script>
    <script src="resources/app.js"></script>
    <script src="resources/Home/home.js"></script>
    <script src="resources/CardList/card-list.js"></script>
    <script src="resources/CardDetail/card-detail.js"></script>
    <script src="resources/DeckList/deck-list.js"></script>
    <script src="resources/core/version/version.js"></script>
    <script src="resources/core/version/version-directive.js"></script>
    <script src="resources/core/version/interpolate-filter.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/lib/html5-boilerplate/dist/css/normalize.css">
    <link rel="stylesheet" href="resources/lib/html5-boilerplate/dist/css/main.css">
    <link rel="stylesheet" href="resources/app.css">
    <script src="resources/lib/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body ng-app="myApp">
<img src="resources/pics/wacky.png" height="75" width="75">
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" ng-click="isNavCollapsed = !isNavCollapsed">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#!/Home" style="font-family: 'Book Antiqua'">Kooky Cards</a>
    </div>
    <div class="collapse navbar-collapse" uib-collapse="!isNavCollapsed">
        <ul class="nav navbar-nav">
            <li><a href="#!/CardList">Cards</a></li>
            <li><a href="#!/DeckList">Your Deck</a></li>
        </ul>
    </div>
</nav>

<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div ng-view></div>


<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->
</body>
</html>
