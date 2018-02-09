<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Start Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    </head>
    <body ng-app="myApp">
        <div class="generic-container">
            <nav class="navbar navbar-default">
                <div>
                    <button type="button" class="btn btn-success btn-lg" href="#" ng-href="/Index.jsp"> Main </button>
                    <button type="button" class="btn btn-success btn-lg" href="#" ng-href="/Charts.jsp"> Charts </button>
                    <button type="button" class="btn btn-success btn-lg" href="#" ng-href="/Configuration.jsp"> Configuration </button>
                    <button type="button" class="btn btn-success btn-lg" href="#" ng-href="/DataBase.jsp"> DataBase </button>
                </div>
            </nav>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
    </body>
</html>