define([
    'jquery',
    'https://www.gstatic.com/charts/loader.js'
], function ($) {
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Views'],
            ['',  0],
            ['23.12.2016',  139.037],
            ['24.12.2016',  60],
            ['',  0],
        ]);

        var options = {
            title: 'Page Views',
            curveType: 'function',
            legend: { position: 'top' },
            width: 470
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
    }
});