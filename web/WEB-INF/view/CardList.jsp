<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<!--[if lt IE 7]>
<html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>List of All Cards</title>
    <meta name="description" content="">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/card-list-styles.css">
</head>
<body ng-app="myApp">
<img src="${contextPath}/resources/pics/wacky.png" height="75" width="75">
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" ng-click="isNavCollapsed = !isNavCollapsed">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${contextPath}/" style="font-family: 'Book Antiqua'">Kooky Cards</a>
    </div>
    <div class="collapse navbar-collapse" uib-collapse="!isNavCollapsed">
        <ul class="nav navbar-nav">
            <li><a href="${contextPath}/card/List">Cards</a></li>
            <li><a href="${contextPath}/DeckList">Your Deck</a></li>
        </ul>
    </div>
</nav>
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->
<div style="margin-left: 1em;">
    <form:form action="search" method="GET">
        Search Cards <input type="search" name="searchTerm"/>
        <input type="submit" value="Search" class="btn btn-primary"/>
    </form:form>
    <a class="btn btn-success" href="${contextPath}/card/showAddCardForm">Add a New Card</a>
</div>
<br>
<div style="margin: 2em;">
    <table id="cards">
        <tr>
            <th>Card Picture</th>
            <th>Card Name</th>
            <th>Card Type</th>
            <th>Card Set</th>
            <th>Card Power</th>
            <th>Card Toughness</th>
            <th>Card Cost</th>
            <th>Card Artist</th>
            <th>Card Actions</th>
        </tr>
        <c:forEach var="tempCard" items="${cards}">

            <!-- construct an "update" link with donut id -->
            <!-- c:url is same as JSP's response.encodeURL() -->
            <c:url var="updateLink" value="/card/showUpdateCardForm">
                <c:param name="card_id" value="${tempCard.card_id}"/>
            </c:url>

            <!-- construct a "delete" link with donut id -->
            <c:url var="deleteLink" value="/card/delete">
                <c:param name="card_id" value="${tempCard.card_id}"/>
            </c:url>

            <tr>
                <td>
                    <img height="220" width="150"
                         src="${contextPath}/resources/pics/userCardPics/${tempCard.imageFileName}"
                         alt="${tempCard.card_name}"></td>
                <td>${tempCard.card_name}</td>
                <td>${tempCard.card_type}</td>
                <td>${tempCard.card_set}</td>
                <td>${tempCard.power}</td>
                <td>${tempCard.toughness}</td>
                <td>${tempCard.card_cost}</td>
                <td>${tempCard.artist}</td>
                <td>
                    <!-- display the update link -->
                    <a class="btn btn-primary" href="${updateLink}">Update ${tempCard.card_name}</a>
                    |
                    <!-- display the delete link -->
                    <a class="btn btn-danger" href="${deleteLink}"
                       onclick="if (!confirm('Are you sure?')) return false">Delete ${tempCard.card_name}</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="margin-left: 1em;">
    <a class="btn btn-success" href="${contextPath}/card/showAddCardForm">Add a New Card</a>
</div>
</body>
</html>
