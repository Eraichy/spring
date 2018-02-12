var app = angular.module('myApp', ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/main/webapp/WEB-INF/views/StartPage.jsp',
            controller: 'ConfigurationController'
        })
        .when('/Charts', {
            templateUrl : '/main/webapp/WEB-INF/views/Charts.jsp',
            controller: 'ChartsController'
        })
        .when('/DataBase', {
            templateUrl : '/main/webapp/WEB-INF/views/DataBase.jsp'
        })
        .when('/Configuration', {
            templateUrl : '/main/webapp/WEB-INF/views/Configuration.jsp',
            controller: 'ConfigurationController'
        });
});