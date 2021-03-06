<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Data Base Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/main/webapp/static/css/app.css' />" rel="stylesheet"/>
</head>
<body ng-app="myApp">
<div class="generic-container" ng-controller="HttpBinRequestController as bin_controller">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Requests</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Request Url</th>
                    <th>Request Start Time</th>
                    <th>Request End Time</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="req in bin_controller.requests">
                    <td><span ng-bind="req.id"></span></td>
                    <td><span ng-bind="req.requestUrl"></span></td>
                    <td><span ng-bind="req.requestStartTime"></span></td>
                    <td><span ng-bind="req.requestEndTime"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/main/webapp/static/js/app.js' />"></script>
<script src="<c:url value='/main/webapp/static/js/service/HttpBinRequestService.js' />"></script>
<script src="<c:url value='/main/webapp/static/js/controllers/HttpBinRequestController.js' />"></script>
</body>
</html>