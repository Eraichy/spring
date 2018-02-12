app.controller('ConfigurationController', function($scope, ConfigurationService) {
    $scope.config = ConfigurationService;

    $scope.$broadcast('restorestate');

    $scope.submit = function() {
        $scope.$broadcast('savestate');
    }
});