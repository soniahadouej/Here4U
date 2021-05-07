define([
    'jquery'
], function () {
    var $header = $('.sh-header'),
        $menu = $('.sh-header__dropdown'),
        $menu_btn = $('.sh-header__btn-dropdown'),
        $logo = $('.sh-header .sh-logo'),
        $mega_menu = $('.sh-header__nav');

    $menu_btn.find('> i').on('click', function () {
        $menu_btn.toggleClass('active');

        if($menu_btn.hasClass('active')) {
            $menu.stop().slideDown({
                complete: function() {
                    $logo.addClass('sh-logo__invert');
                }
            });
        } else {
            $menu.stop().slideUp();
            $logo.removeClass('sh-logo__invert');
        }
    });

    var $head_cont = $header.find('> .container');

    $mega_menu.each(function () {
        $(this).append($('<div>').addClass('sh-header__menu-transition'));
    });

    $('.sh-header__menu > li').on({
        mouseenter: function() {
            var $this = $(this),
                li_l = $this.get(0).getBoundingClientRect().left,
                li_b = $this.get(0).getBoundingClientRect().bottom,
                li_w = $this.innerWidth(),
                header_b = $header.get(0).getBoundingClientRect().bottom,
                trans_l = li_l,
                trans_h = header_b - li_b,
                $megamenu = $(this).find('.sh-header__nav'),
                $transition = $megamenu.find('.sh-header__menu-transition');

            if($megamenu.length) {
                if($menu_btn.hasClass('active')) {
                    $menu_btn.removeClass('active');
                    $logo.removeClass('sh-logo__invert');
                    $menu.stop().hide();
                }

                $transition.css({
                    left: trans_l,
                    height: trans_h + 4,
                    width: li_w
                });

                $head_cont.addClass('static');
                $megamenu.show();
            }
        },
        mouseleave: function() {
            var $megamenu = $(this).parent().find('.sh-header__nav');

            if($megamenu.length) {
                $head_cont.removeClass('static');
                $megamenu.hide();
            }
        }
    })


});