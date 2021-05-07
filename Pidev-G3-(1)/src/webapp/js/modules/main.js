define([
    'jquery',
    'plugins/bootstrap_v3'
], function () {
    $("[rel='tooltip']").tooltip();

    function copy(str){
        var tmp   = document.createElement('INPUT'),
            focus = document.activeElement;

        tmp.value = str;

        document.body.appendChild(tmp);
        tmp.select();
        document.execCommand('copy');
        document.body.removeChild(tmp);
        focus.focus();
    }

    $('.sh-input-copy > a').on('click', function (e) {
        var $input = $(this).parents('.sh-input-copy').find('input');

        copy($input.val());

        e.preventDefault();
        return false;
    });
});