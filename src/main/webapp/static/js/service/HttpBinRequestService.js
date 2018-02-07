'use strict';

angular.module('myApp').factory(
    'HttpBinRequestService',
    [
        '$http', '$q', function($http, $q)
    {
        var REST_SERVICE_URI = 'http://localhost:8080/httpBin';

        // var factory = {
        //     getStatusOk: getStatusOk,
        //     randomDelay: randomDelay
        // };
        //
        // return factory;

        $http.getStatusOk = function getStatusOk() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + '/getStatusOk')
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
        };

        $http.randomDelay = function randomDelay() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + '/randomDelay')
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
    }
    ]
);