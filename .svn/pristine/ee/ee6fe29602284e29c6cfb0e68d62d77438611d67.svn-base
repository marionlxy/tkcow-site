function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
/**
 * 初始化页面信息
 */
var path = getContextPath();
$(function(){
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url(img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url(img/a1.png)  center center no-repeat");
			});
	$("#sqzl_id").click(function(){
		$("#windownbg").css("display","block");
		$(".white_content_sqzl").css("display","block");
		});
	$("#sqzl_gb_id").click(function(){
		$("#windownbg").css("display","none");
		$(".white_content_sqzl").css("display","none");
		});
	$("#yycg_id").click(function(){
		$("#windownbg").css("display","block");
		$(".white_content_yycg").css("display","block");
		});
	$("#yycg_gb_id").click(function(){
		$("#windownbg").css("display","none");
		$(".white_content_yycg").css("display","none");
		});
	
});
function leftLiClick(obj){
	$(obj).children("a").css("color","#0a8a7a");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
	$.post(path+ "/zjowModuleContent/list",function(data){
		if(data==0){
			//$("#goodsForm").submit();
			return true;
        }else{
		 	
		 	return false;
		 	}
	});
	}