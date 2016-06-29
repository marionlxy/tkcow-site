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
	var logolist = document.getElementById("menuList").value;
	var modName= document.getElementById("modName").value;
	sessionStorage.setItem("menuLists",logolist);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url(img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	
	$(".right").empty();
	var pageItems = sessionStorage.getItem("menuLists");
	var pItems=JSON.parse(pageItems);
	var meunlist;
	var logolist;
	var indexhtml='<div class="righttitle">'+modName+'优质合作伙伴';
	var kk = pItems.menuList.length;
	for (var i = 0; i <kk; i++) {
		logolist=pItems.menuList[i].logolist;
	}
	indexhtml+='</div><div class="rightnr"><div class="link"><ul>';
	for (var j = 0; j < logolist.length; j++) {
		var banImgUrl = path + '/' + logolist[j].COOPER_LOGO_URL;
		indexhtml+='<li><a href="javascript:;"><img src='+banImgUrl+' width="219" height="179" original='+banImgUrl+' style="display: inline;">'+
            '<div class="hg">'+
        		'<div class="hgtitle">'+logolist[j].COOPER_LOGO_NAME+'</div>'+logolist[j].COOPER_LOGO_DES
     		+'</div>'+
     '</a></li>'
	}
	indexhtml+='</ul></div>';
	$(".right").append(indexhtml);
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