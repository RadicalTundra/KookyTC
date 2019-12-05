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
    <title>Edit Card</title>
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

<div>

    <h3>Edit Card</h3>

    <form:form action="${contextPath}/card/save" enctype="multipart/form-data" modelAttribute="card"
               method="post" id="cardForm">
        <form:hidden path="card_id" value="${card.card_id}"/>
        <form:hidden path="imageFileName" value="${card.imageFileName}"/>

        <table id="cards">
            <tr>
                <td><label for="cardName">Card Name</label></td>
                <td><form:input path="card_name" id="cardName"/>
                    <form:errors path="card_name" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="cardType">Card Type</label></td>
                <td><form:select path="card_type" id="cardType">
                    <form:option value="Land">Land</form:option>
                    <form:option value="Creature">Creature</form:option>
                    <form:option value="Artifact">Artifact</form:option>
                    <form:option value="Enchantment">Enchantment</form:option>
                    <form:option value="Planeswalker">Planeswalker</form:option>
                    <form:option value="Instant">Instant</form:option>
                    <form:option value="Sorcery">Land</form:option>
                </form:select>
                    <form:errors path="card_type" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="cardSet">Card Set</label></td>
                <td><form:input path="card_set" id="cardSet"/>
                    <form:errors path="card_set" cssClass="error"/></td>
                </td>
            </tr>
            <tr>
                <td><label for="cardPower">Card Power</label></td>
                <td><form:input path="power" id="cardPower"/>
                    <form:errors path="power" cssClass="error"/></td>
                </td>
            </tr>
            <tr>
                <td><label for="cardToughness">Card Toughness</label></td>
                <td><form:input path="toughness" id="cardToughness"/>
                    <form:errors path="toughness" cssClass="error"/></td>
                </td>
            </tr>
            <tr>
                <td><label for="cardCost">Card Cost</label></td>
                <td><form:input path="card_cost" id="cardCost"/>
                    <form:errors path="card_cost" cssClass="error"/></td>
                </td>
            </tr>
            <tr>
                <td><label for="cardArtist">Artist</label></td>
                <td><form:input path="artist" id="cardArtist"/>
                    <form:errors path="artist" cssClass="error"/></td>
                </td>
            </tr>
            <tr>
                <td><label>Image</label></td>
                <td>
                    <input type="file" name="image">
                    <c:if test="${card.imageFileName != null}">
                        <br/><br/>
                        <img height="220" width="150"
                             src="${contextPath}/resources/pics/userCardPics/${card.imageFileName}"
                             alt="${card.card_name}">
                        <br/>${card.imageFileName}
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
</body>
</html>
