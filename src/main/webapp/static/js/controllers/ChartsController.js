'use strict';

angular.module('myApp').controller('ChartsController', [
    "HttpBinRequestService",
    function(HttpBinRequestService) {

        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawStatusOkChart);
        google.charts.setOnLoadCallback(drawDelayChart);

        function drawStatusOkChart() {
            HttpBinRequestService.getAllGetOkRequests()
                .then(
                    function(requests) {
                        drawChart(requests, 'Request status/200 Performance', 'status_ok_chart');
                    }
                );
        }

        function drawDelayChart() {
            HttpBinRequestService.getAllDelayRequests()
                .then(
                    function(requests) {
                        drawChart(requests, 'Request delay/n Performance', 'delay_chart');
                    }
                );
        }

        function drawChart(requests, chartName, chartId) {
            var resultView = [['Start Time', 'Execution Time, ms']];
            for (var item in requests) {
                resultView.push([
                    requests[item]['requestStartTime'],
                    new Date(requests[item]['requestEndTime']).getTime() -
                    new Date(requests[item]['requestStartTime']).getTime()
                ]);
            }

            var data = google.visualization.arrayToDataTable(resultView);

            var options = {
                title: chartName,
                hAxis: {title: 'Execution Date',  titleTextStyle: {color: '#333'}},
                vAxis: {minValue: 0}
            };

            var chart = new google.visualization.AreaChart(document.getElementById(chartId));
            chart.draw(data, options);
        }
    }]);
