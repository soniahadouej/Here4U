define([
    'jquery',
    'plugins/progress'
], function () {
    $('.tt-progress').circleProgress({
        fill: {color: '#3482e2'},
        thickness: 2,
        size: 46
    }).on('circle-animation-progress', function(event, progress, stepValue) {
        var set_val = stepValue * 10;

        $(this).find('strong').text(set_val.toFixed(1));
    });
});