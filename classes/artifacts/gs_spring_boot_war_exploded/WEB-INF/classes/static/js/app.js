'use strict';

var app = angular.module('myApp', ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "/Index.jsp"
        })
        .when("/Charts", {
            templateUrl : "/Charts.jsp"
        })
        .when("/Configuration", {
            templateUrl : "/Configuration.jsp"
        })
        .when("/DataBase", {
            templateUrl : "/DataBase.jsp"
        });
});