define([
    'jquery',
    'plugins/datePicker'
], function ($) {
    var calend_act = false;

    $('.sh-content-head__btn-calendar > i').on('click', function () {
        var $this = $(this).parents('.sh-content-head__btn-calendar'),
            $calend = $('.sh-calendar__datepicker');

        if(calend_act) return;

        if($this.hasClass('active')) {
            $('.sh-calendar__close').trigger('click');
            return;
        }

        calend_act = true;

        $('.mfp-bg').trigger('click');

        var $bg = $('<div>').addClass('mfp-bg mfp-with-zoom sh-calend__bg');

        $this.addClass('active');

        $('.sh-calendar').stop().fadeIn();

        $calend.find('.datepicker').empty().remove();

        $calend.DatePicker({
            flat: true,
            date: ['2017-09-01'],
            current: '2017-09-01',
            mode: 'multiple'
        });

        $('body').append($bg);

        setTimeout(function () {
            $bg.addClass('mfp-ready');
            calend_act = false;
        }, 0);
    });

    $(document).on('click', '.sh-calendar__close, .sh-calend__bg', function () {
        if(calend_act) return;

        calend_act = true;

        $('.sh-calendar').stop().hide();

        $('.sh-calend__bg').remove();

        $('.sh-content-head__btn-calendar').removeClass('active');

        calend_act = false;
    });
});