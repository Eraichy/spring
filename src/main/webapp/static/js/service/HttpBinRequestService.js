'use strict';

angular.module('myApp').factory('HttpBinRequestService', [ '$http', '$q', function($http, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/httpBin';

    return{
        getAllDelayRequests: getAllDelayRequests,
        getAllGetOkRequests: getAllGetOkRequests,
        getRequests: getRequests,
        getStatusOk: getStatusOk,
        randomDelay: randomDelay,
        stopTasks: stopTasks
    };

    function getAllDelayRequests() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/getAllDelayRequests')
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while getAllDelayRequests');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function getAllGetOkRequests() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/getAllGetOkRequests')
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while getAllGetOkRequests');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function getRequests() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/getRequests')
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while getRequests');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function getStatusOk(rpm) {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/getStatusOkLoad?requestsPerMin=' + rpm)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while getStatusOk');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function randomDelay(rpm) {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/getDelayLoad?requestsPerMin=' + rpm)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while randomDelay');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function stopTasks() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + '/stopTasks')
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while stopTasks');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

}]);