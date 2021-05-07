define([
    'jquery'
], function () {
    var stat_act = false;

    $('.sh-section__btn-stat').on('click', function () {
        if(stat_act || $(this).hasClass('active')) return;

        stat_act = true;

        $('.mfp-bg').trigger('click');

        var $bg = $('<div>').addClass('mfp-bg mfp-with-zoom sh-statistic__bg');

        $(this).addClass('active');

        $('.sh-statistic, .sh-statistic__arrow').stop().fadeIn();

        $('body').append($bg);

        setTimeout(function () {
            $bg.addClass('mfp-ready');
            stat_act = false;
        }, 0);
    });

    $(document).on('click', '.sh-statistic__close, .sh-statistic__bg', function () {
        if(stat_act) return;

        stat_act = true;

        $('.sh-statistic, .sh-statistic__arrow').stop().hide();

        $('.sh-statistic__bg').remove();

        $('.sh-section__btn-stat').removeClass('active');

        stat_act = false;
    });
});