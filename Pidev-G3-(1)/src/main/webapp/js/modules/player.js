define([
    'jquery'
], function ($) {
    $(document).on('click', '.sh-video .sh-media__btn', function () {
        var $this = $(this),
            $media_wrap = $this.parents('.sh-video'),
            $media = $media_wrap.find('video'),
            media = $media.get(0);

        if(media.paused) {
            media.play();
            $media.attr('controls', 'controls');
            $this.fadeOut();
        }
    });

    $(document).on('click', '.sh-audio .sh-media__btn', function () {
        var $this = $(this),
            $media_wrap = $this.parents('.sh-audio'),
            $media = $media_wrap.find('audio'),
            media = $media.get(0);

        if(media.paused) {
            $media_wrap.addClass('playing');
            media.play();
        } else {
            $media_wrap.removeClass('playing');
            media.pause();
            media.currentTime = 0;
        }

    });
});