app.factory('ConfigurationService', ['$rootScope', function ($rootScope) {
    var service = {

        model: {
            rpmStatusOk: 10,
            rpmDelay: 10
        },

        SaveState: function () {
            sessionStorage.configuration = angular.toJson(service.model);
        },

        RestoreState: function () {
            service.model = angular.fromJson(sessionStorage.configuration);
        }
    };

    $rootScope.$on("savestate", service.SaveState);
    $rootScope.$on("restorestate", service.RestoreState);

    return service;
}]);