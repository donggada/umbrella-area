$(document).ready(function(){
 $.getJSON("/weather",function(rdate){
 $.each(rdate,function(index,item){
        var num=Number(index)+1;
        var dw="";
        var wicon=""
        if(item.lgt!="0"){
            dw="storm";
        }else if(item.pty=="0"){
            dw="sunny"
        }else{
        switch(item.pty){
                    case "4":
                    dw="drizzle";
                    break;
                    default:
                    dw="rain";
                    }
        }
        switch(dw){
            case "storm":
            wicon="storm";
            break;
            case "sunny":
            wicon="sun";
            break;
            case "rain":
            wicon="rainy";
            break;
            case "drizzle":
            wicon="drizzle";
            break;
        }

        var info='<div class="slide" id="slide-'+num+'" data-weather="'+dw+'">'+
                  '<div class="slide__element slide__element--date">'+item.local+'&nbsp;&nbsp;'+item.date+'</div>'+
                  '<div class="slide__element slide__element--temp">'+item.t1H+'°<small>C</small></div>'+
                  '</div>';
        var infolist='<a class="nav-item" href="#slide-'+num+'"><i class="icon icon--'+wicon+'"></i><span>'+item.local+'</span></a>';
        $('#info').append(info);
        $('.slideshow__nav').append(infolist);
    })
 })
})