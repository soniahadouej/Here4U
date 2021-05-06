define( [
    'require',
    'jquery',
    'plugins/isotope'
], function( require, $, Isotope ) {

    require( [
        'plugins/bridget'
    ], function( jQueryBridget ) {

        jQueryBridget( 'isotope', Isotope, $ );

        var $sect_wrap = $('.sh-section__wrap'),
            $more_btn = $('.sh-footer__more-btn'),
            posts_number = 1;

        $(function () {
            $sect_wrap.isotope({
                itemSelector: '.sh-section__item',
                layoutMode: 'masonry',
            }).addClass('sh-section__isotope-init');
        });

        function send_ajax() {
            $.ajax({
                data: 'get=posts&number=' + posts_number,
                type: 'POST',
                url: 'php/get_posts.php',
                timeout: 5000,
                cache: false,
                success: function (data) {

                    var $elem = $(data);

                    $sect_wrap.isotope()
                        .append( $elem )
                        .isotope( 'appended', $elem )
                        .isotope('layout');

                    posts_number++;

                    if(posts_number > 2) {
                        $more_btn.addClass('sh-footer__more-btn-disable');
                    }
                },
                error: function (jqXHR, exception) {

                    if (jqXHR.status === 0) {
                        console.log('Not connect.\n Verify Network.');
                    } else if (jqXHR.status == 404) {
                        console.log('Requested page not found. [404]');
                    } else if (jqXHR.status == 500) {
                        console.log('Internal Server Error [500].');
                    } else if (exception === 'parsererror') {
                        console.log(jqXHR.responseText);
                    } else if (exception === 'timeout') {
                        console.log('Time out error.');
                    } else if (exception === 'abort') {
                        console.log('Ajax request aborted.');
                    } else {
                        console.log('Uncaught Error.\n' + jqXHR.responseText);
                    }
                }
            });
        };

        $more_btn.on('click', function (e) {

            if(posts_number > 2 || $more_btn.hasClass('sh-footer__more-btn-disable')) {
                e.preventDefault();
                return false;
            }

            send_ajax();

            e.preventDefault();
            return false;
        });

        $(window).on('scroll', function () {
            var body_b = $('body').get(0).getBoundingClientRect().bottom,
                wind_h = window.innerHeight;

            if(posts_number > 2 || $more_btn.hasClass('sh-footer__more-btn-disable')) {
                return;
            }

            if(body_b < wind_h + 10)
                send_ajax();
        });
    });
});