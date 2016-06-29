function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
/**
 * 初始化页面信息
 */
if(window!=top){
	var path = contextPath;
    top.location = path + "/login";
}

$(function(){         
    $('#kaptchaImage').click(function () {
     //生成验证码  
     $(this).hide().attr('src', './ValidateCodeServlet/Validate.png?' + Math.floor(Math.random()*100) ).fadeIn();  
     event.cancelBubble=true;  
    });  
});

function changeCode() {  
    $('#kaptchaImage').hide().attr('src', './ValidateCodeServlet/Validate.png?' + Math.floor(Math.random()*100) ).fadeIn();  
    event.cancelBubble=true;  
};