'use strict';

angular.module('myApp').controller(
    'HttpBinRequestController',
    [
        '$scope', 'HttpBinRequestService', function($scope, HttpBinRequestService)
    {
        $scope.request = {
            id: null,
            requestUrl: '',
            requestStartTime: '',
            requestEndTime: ''
        };

        $scope.requests = [];

        $scope.getStatusOk = function getStatusOk(){
            HttpBinRequestService.getStatusOk()
                .then(
                    function(d) {
                        self.request = d;
                    },
                    function(errResponse){
                        console.error('Error while getStatusOk');
                    }
                );
        };

        $scope.randomDelay = function randomDelay(){
            HttpBinRequestService.randomDelay()
                .then(
                    function(d) {
                        self.request = d;
                    },
                    function(errResponse){
                        console.error('Error while randomDelay');
                    }
                );
        };
    }
    ]
);