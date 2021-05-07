define([
    'jquery'
], function ($) {
    var avatar_act = false;

    $('.sh-header__avatar').on('click', function () {
        if(avatar_act || $(this).hasClass('active')) return;

        avatar_act = true;

        $('.mfp-bg').trigger('click');

        var $bg = $('<div>').addClass('mfp-bg mfp-with-zoom sh-avatar__bg');

        $(this).addClass('active');

        $('.sh-user').stop().fadeIn();

        $('body').append($bg);

        setTimeout(function () {
            $bg.addClass('mfp-ready');
            avatar_act = false;
        }, 0);
    });

    $(document).on('click', '.sh-user__close, .sh-avatar__bg', function () {
        if(avatar_act) return;

        avatar_act = true;

        $('.sh-user').stop().hide();

        $('.sh-avatar__bg').remove();

        $('.sh-header__avatar').removeClass('active');

        avatar_act = false;
    });

    $('.sh-header__btn-like, .sh-header__btn-comment, .sh-header__btn-notification').on('click', function (e) {
        $('.sh-header__avatar').trigger('click');

        e.preventDefault();
        return false;
    });
});