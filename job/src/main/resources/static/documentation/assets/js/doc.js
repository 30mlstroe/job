$(function(){

    "use strict";

    $(".bootstrap-sidebar ul li a[href^='#']").on('click', function(e) {

        e.preventDefault();

        var that = $(this),
            hash = this.hash;

        if( $(this).next('ul').length > 0 ){
            $(this).parent("li").siblings().find("ul").slideUp(150);
            $(this).next('ul').slideToggle(150);
        }

        $(".bootstrap-sidebar ul li").removeClass("active");

        $('html, body').finish().animate({
            scrollTop: $(hash).offset().top
        }, 500, 'swing', function(){
            that.parent("li").addClass("active");
            window.location.hash = hash;
        });

    });

});