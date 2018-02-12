<div class="generic-container" ng-controller="HttpBinRequestController as bin_controller">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">List of Requests</span>
        </div>
        <div class="table-container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th width="5%"></th>
                        <th>ID</th>
                        <th>Request Url</th>
                        <th>Request Start Time</th>
                        <th>Request End Time</th>
                        <th>Execution Time, ms</th>
                        <th width="5%"></th>
                    </tr>
                </thead>

                <tbody>
                    <tr ng-repeat="request in bin_controller.requests">
                        <th width="5%"></th>
                        <td><span ng-bind="request.id"></span></td>
                        <td><span ng-bind="request.requestUrl"></span></td>
                        <td><span ng-bind="request.requestStartTime | date :  'dd.MM.yyyy HH:mm:ss.sss' "></span></td>
                        <td><span ng-bind="request.requestEndTime | date :  'dd.MM.yyyy HH:mm:ss.sss' "></span></td>
                        <td><span ng-bind="getDiff(request.requestStartTime, request.requestEndTime)"></span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>