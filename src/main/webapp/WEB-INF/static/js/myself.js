<<<<<<< HEAD
$("#history-div").click(function (){
    $(".content").css('display','none');
    $(".history").css('display',"block");
    $("#return").css("display","block");
});
$("#return").click(function(){
    $(".content").css('display','block');
    $(".history").css('display',"none");
    $("#return").css("display","none");
    $(".management").css("display","none");
    $(".order").css("display","none");
    $(".back").css("display","none");
    $("#trash").css("display","none");
    $(".settings").css("display","none");
})
$("#back-div").click(function(){
    $(".content").css('display','none');
    $(".back").css('display',"block");
    $("#return").css("display","block");
})
$("#order-div").click(function(){
    $(".content").css('display','none');
    $(".order").css('display',"block");
    $("#return").css("display","block");
    $("#trash").css("display","block");
})
$("#settings-div").click(function(){
    $(".content").css('display','none');
    $(".settings").css('display',"block");
    $("#return").css("display","block");
})
$("#trash").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked)
            $(box[i]).parent().parent().remove();
    };
})
$("#management-div").click(function(){
    $(".content").css('display','none');
    $(".management").css('display',"block");
    $("#return").css("display","block");
=======
$("#history-div").click(function (){
    $(".content").css('display','none');
    $(".history").css('display',"block");
    $("#return").css("display","block");
});
$("#return").click(function(){
    $(".content").css('display','block');
    $(".history").css('display',"none");
    $("#return").css("display","none");
    $(".management").css("display","none");
    $(".order").css("display","none");
    $(".back").css("display","none");
    $("#trash").css("display","none");
    $(".settings").css("display","none");
})
$("#back-div").click(function(){
    $(".content").css('display','none');
    $(".back").css('display',"block");
    $("#return").css("display","block");
})
$("#order-div").click(function(){
    $(".content").css('display','none');
    $(".order").css('display',"block");
    $("#return").css("display","block");
    $("#trash").css("display","block");
})
$("#settings-div").click(function(){
    $(".content").css('display','none');
    $(".settings").css('display',"block");
    $("#return").css("display","block");
})
$("#trash").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked)
            $(box[i]).parent().parent().remove();
    };
})
$("#management-div").click(function(){
    $(".content").css('display','none');
    $(".management").css('display',"block");
    $("#return").css("display","block");
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
})