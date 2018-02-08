'use strict';

angular.module('myApp').controller('HttpBinRequestController', [
    '$scope', 'HttpBinRequestService', function($scope, HttpBinRequestService) {
        var self = this;

        self.request = {
            id: null,
            requestUrl: '',
            requestStartTime: '',
            requestEndTime: ''
        };

        self.requests=[];

        getRequests();

        function getRequests(){
            HttpBinRequestService.getRequests()
                .then(
                    function(d) {
                        self.requests = d;
                    },
                    function(errResponse){
                        console.error('Error while getting Requests');
                    }
                );
        }

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

        $scope.getDiff = function getDiff(startTime, endTime){
            return new Date(endTime).getTime() - new Date(startTime).getTime();
        };
}]);