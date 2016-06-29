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
	var xwcontent = document.getElementById("xwcontent").value;
	var xwud = document.getElementById("xwud").value;
	sessionStorage.setItem("xwcontent", xwcontent);
	sessionStorage.setItem("xwud", xwud);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url(img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	$(".right").empty();
	var xwcontent = sessionStorage.getItem("xwcontent");
	var xwconte=JSON.parse(xwcontent);
	var xwud = sessionStorage.getItem("xwud");
	var xwupd=JSON.parse(xwud);
	var uhtml;
	uhtml='<div class="righttitle">'+xwconte.xwcontent.xwdes.title+'</div>'+
			'<div class="rightnr">';
			if(xwconte.xwcontent.xwdes.content==undefined || xwconte.xwcontent.xwdes.content == null || xwconte.xwcontent.xwdes.content==''){
				uhtml+=Base64.decode(Base64.decode(xwconte.xwcontent.xwdes.content))+'</div>'+
				'<p></p><div class="prenext">';
			}else{
				uhtml+=Base64.decode(Base64.decode(xwconte.xwcontent.xwdes.content)) +'</div>'+'<p></p><div class="prenext">';
			}
			var doUrl = path + '/' + xwupd.xwdo.modUrl;
			var upUrl = path + '/' + xwupd.xwup.modUrl;
			if(xwupd.xwup.title==undefined || xwupd.xwup.title==null || xwupd.xwup.title==''){
				uhtml+='<span>上一篇：已经是第一篇</span><br>'+
					'<span>下一篇：<a href='+doUrl+'>'+xwupd.xwdo.title+'</a></span></div>';
			}else{
				if(xwupd.xwdo.title==undefined || xwupd.xwdo.title==null || xwupd.xwdo.title==''){
					uhtml+='<span>上一篇：<a href='+upUrl+'>'+xwupd.xwup.title+'</a></span><br>'+
					'<span>下一篇：已经是最后一篇</span></div>';
				}else{
					uhtml+='<span>上一篇：<a href='+upUrl+'>'+xwupd.xwup.title+'</a></span><br>'+
					'<span>下一篇：<a href='+doUrl+'>'+xwupd.xwdo.title+'</a></span></div>';
				}
			}
			$(".right").append(uhtml);
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