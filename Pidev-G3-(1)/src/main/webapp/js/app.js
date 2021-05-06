"use strict";

//scripts availabel
require.config({
    baseUrl: '',
    paths: {
        //PLUGINS
        'jquery': 'vendor/jquery/jquery.min',
        'plugins/modernizr': 'vendor/modernizr/modernizr',
        'plugins/bootstrap_v3': 'vendor/bootstrap/v3/js/bootstrap.min',
        'plugins/slick': 'vendor/slick/slick.min',
        'plugins/progress': 'vendor/progress/dist/circle-progress.min',
        'plugins/magnificPopup': 'vendor/magnificPopup/dist/jquery.magnific-popup.min',
        'plugins/bridget': 'vendor/jquery/jquery-bridget',
        'plugins/isotope': 'vendor/isotope/isotope.pkgd.min',
        'plugins/datePicker': 'vendor/datePicker/js/datepicker',
        //MODULES
        'modules/main': 'js/modules/main',
        'modules/player': 'js/modules/player',
        'modules/progress': 'js/modules/progress',
        'modules/upload': 'js/modules/upload',
        'modules/userToggle': 'js/modules/user-toggle',
        'modules/menu': 'js/modules/menu',
        'modules/statistic': 'js/modules/statistic',
        'modules/posts': 'js/modules/posts',
        'modules/googleCharts': 'js/modules/google-charts',
        'modules/datePicker': 'js/modules/datepicker',
    },
    shim : {
        //PLUGINS
        'plugins/modernizr': {
            exports: 'Modernizr'
        },
        'plugins/bootstrap_v3': {
            deps: ['jquery'],
            exports: 'Bootstrap'
        },
        'plugins/datePicker': {
            deps: ['jquery'],
            exports: 'datePicker'
        },
    }
});











