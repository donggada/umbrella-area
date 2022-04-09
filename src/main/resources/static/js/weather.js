$(document).ready(function(){
    $.getJSON("/api/weather",function(rdate){
        $.each(rdate,function(index, item){
        let num = Number(index) + 2;
        let weatherIcon = '';
        let {local, weatherType, temperatures } = item

        if (weatherType === 'sunny') {
            weatherIcon = 'sun';
        }else if (weatherType === 'rain') {
            weatherIcon = 'rainy'
        } else {
            weatherIcon = weatherType;
        }

        
        let info = '<div class="slide" id="slide-' + num +'" data-weather="' + weatherType + '">'+
                   '<div class="slide__element slide__element--date">' + local+'&nbsp;&nbsp; </div>' +
                   '<div class="slide__element slide__element--temp">'+ temperatures + ' °<small>C</small></div>'+
                   '</div>';

        let infolist = '<a class="nav-item" href="#slide-' + num + '"><i class="icon icon--' + weatherIcon + '"></i><span>' + local + '</span></a>';

        $('#info').append(info);
        $('.slideshow__nav').append(infolist);
    })
 })
})