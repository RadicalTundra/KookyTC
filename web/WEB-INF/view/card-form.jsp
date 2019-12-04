<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
    <title>Edit Card</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/card-form-styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/card-form-js.js"/>
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
            <li><a href="${contextPath}/CardList">Cards</a></li>
            <li><a href="${contextPath}/DeckList">Your Deck</a></li>
        </ul>
    </div>
</nav>
<div class="container">

    <div>

        <h3>Edit Card</h3>

        <form:form action="${contextPath}/card/save" enctype="multipart/form-data" modelAttribute="card"
                   method="post" id="cardForm">
            <form:hidden path="card_id" value="${card.card_id}"/>
            <form:hidden path="image" value="${card.image}"/>

            <table>
                <tr>
                    <td><label>Card Name</label></td>
                    <td><form:input path="card_name"/>
                        <form:errors path="card_name" cssClass="error"/></td>
                </tr>
                <tr>
                    <form:hidden path="card_type" id="allCardTypes"/>
                    <td><label>Card Type</label></td>
                    <td><select class="cardType">
                        <option value="Land">Land</option>
                        <option value="Creature">Creature</option>
                        <option value="Artifact">Artifact</option>
                        <option value="Enchantment">Enchantment</option>
                        <option value="Planeswalker">Planeswalker</option>
                        <option value="Instant">Instant</option>
                        <option value="Sorcery">Land</option>
                    </select>
                        <input type="button" class="btn btn-primary" value="Add Another Type" id="anotherType">
                        <form:errors path="card_type" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Card Set</label></td>
                    <td><form:input path="card_set"/>
                        <form:errors path="card_set" cssClass="error"/></td>
                    </td>
                </tr>
                <tr>
                    <td><label>Card Power</label></td>
                    <td><form:input path="power"/>
                        <form:errors path="power" cssClass="error"/></td>
                    </td>
                </tr>
                <tr>
                    <td><label>Card Toughness</label></td>
                    <td><form:input path="toughness"/>
                        <form:errors path="toughness" cssClass="error"/></td>
                    </td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td>
                        <input type="file" name="image">
                        <c:if test="${card.image != null}">
                            <br/><br/>
                            <img src="${contextPath}/resources/pics/userCardPics/${card.image}" alt="${card.name}">
                            <br/>${card.image}
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>
        </form:form>

    </div>
</div>
</body>
</html>
