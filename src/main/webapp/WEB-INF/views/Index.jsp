<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Http Bin Load Generator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/HttpBinRequestService.js' />"></script>
    <script src="<c:url value='/static/js/service/ConfigurationService.js' />"></script>
    <script src="<c:url value='/static/js/controllers/ChartsController.js' />"></script>
    <script src="<c:url value='/static/js/controllers/HttpBinRequestController.js' />"></script>
    <script src="<c:url value='/static/js/controllers/ConfigurationController.js' />"></script>

</head>

<body ng-app="myApp">

<div class="generic-container">
    <a href="#" class="btn btn-success btn-lg">Main Page</a>
    <a href="#!Charts" class="btn btn-success btn-lg">Charts</a>
    <a href="#!DataBase" class="btn btn-success btn-lg">DataBase</a>
    <a href="#!Configuration" class="btn btn-success btn-lg">Configuration</a>
</div>

<div ng-view></div>

</body>
</html>