function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
var path=getContextPath();
$(function(){
	var id=document.getElementById('id').value;
	var url = document.getElementById('url').value;
	var banUrl = path + '/' + url;
	var cs = "url('" + banUrl + "')";
	$(".banner2").css("background",cs);
	
	var modName = document.getElementById('modName').value;
	var content = document.getElementById('content').value;
	var con=JSON.parse(content);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url("+path+"/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+path+"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	
		//内容模板不带图
		var indehtml = "<div class='righttitle'>"+modName+"</div><div class='rightnr'>"+Base64.decode(con.hascontent)+"</div>";
		//console.log(indehtml)
		$("#right1").html(indehtml);
	
});
function leftLiClick(obj){
	$(obj).children("a").css("color","#0a8a7a");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
	}