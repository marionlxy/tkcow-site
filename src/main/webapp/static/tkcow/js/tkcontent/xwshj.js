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
	var banUrl = document.getElementById("banUrl").value;
	banUrl = path + '/' + banUrl;
	var cs = "url('" + banUrl + "')";
	$(".banner2").css("background",cs);
	//$(".banner2").find("img").attr("src",banUrl);
	var id = document.getElementById("id").value;
	var xwlists = document.getElementById("xwlists").value;
	sessionStorage.setItem("xwsjlist",xwlists);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	$(".righttitle").empty();
	$("#news_ul").empty();
	var xwsjlist = sessionStorage.getItem("xwsjlist");
	//alert(xwsjlist);
	var xwli=JSON.parse(xwsjlist);
	var xwList = xwli.xwList;
	var xwhtml;
	var xwslist;
	for (var i = 0; i < xwList.length; i++) {
		xwslist=xwList[i].xwslist;	
	}
	$('.righttitle').html(xwli.mod_name);
	var xwhtml="";
	for (var j = 0; j < xwslist.length; j++) {
		xwhtml+='<li><a href='+xwslist[j].mod_url+'>'+xwslist[j].title+'</a><span>'+xwslist[j].created_time+'</span></li>';
	}
		$("#news_ul").append(xwhtml);
});
function leftLiClick(obj){
	$(obj).children("a").css("color","#21acd8");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
	var divLen=$(obj).next("div").find("div").length;
	if(divLen>0){
		$(obj).next("div").find("div").css("display","block");
		}
	
	}
function left_change(obj){
	$(obj).children("a").css("color","#21acd8");
	$(obj).siblings("li").children("a").css("color","#333");
	var divLen=$(obj).next("div").length;
	if(divLen==0){
		$(obj).siblings("li").next("div").css("display","none");
		}
	}
function chil_change(obj){
	$(obj).children("a").css("color","#21acd8");
	$(obj).siblings("li").children("a").css("color","#333");
	}
function window_ceng(obj){
	$("#windownbg").css("display","block");
	$(".white_content").css("display","block");
	}