angular.module('myApp').controller('HttpBinRequestController', [
    '$scope', 'HttpBinRequestService', 'ConfigurationService',
    function($scope, HttpBinRequestService, ConfigurationService) {
        var self = this;
        $scope.config = ConfigurationService;
        $scope.$broadcast('restorestate');

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
            HttpBinRequestService.getStatusOk($scope.config.model.rpmStatusOk)
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
            HttpBinRequestService.randomDelay($scope.config.model.rpmDelay)
                .then(
                    function(d) {
                        self.request = d;
                    },
                    function(errResponse){
                        console.error('Error while randomDelay');
                    }
                );
        };

        $scope.stopTasks = function stopTasks(){
            HttpBinRequestService.stopTasks()
                .then(
                    function(d) {
                        self.request = d;
                    },
                    function(errResponse){
                        console.error('Error while stopTasks');
                    }
                );
        };

        $scope.getDiff = function getDiff(startTime, endTime){
            return new Date(endTime).getTime() - new Date(startTime).getTime();
        };
}]);