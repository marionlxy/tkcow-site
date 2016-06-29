function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
var path=getContextPath();

$(function(){
	var banUrl = document.getElementById("banUrl").value;
	banUrl = path + '/' + banUrl;
	var cs = "url('" + banUrl + "')";
	$(".banner2").css("background",cs);
	var id = document.getElementById('id').value; ;
	var modName= document.getElementById('modName').value;
	var listimg =  document.getElementById('listimg').value;
	sessionStorage.setItem("listimg",listimg);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+ path +"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	var pageItems = sessionStorage.getItem("listimg");
	var pItems=JSON.parse(pageItems);
	$(".right").empty();
	$(".white_content").empty();
	var imglist;
	var indexhtml='<div class="righttitle">'+modName;
	var kk = pItems.menuList.length;
	for (var i = 0; i < kk; i++) {
		imglist=pItems.menuList[i].imglists;
	}
				indexhtml+="</div><div class='rightnr'>"
				  +'<div class="xmly">'
				  +'<ul>';
				  for (var j = 0;  j< imglist.length; j++) {
						var mId = imglist[j].MOD_ID;
						var mImgUrl = path + '/' +imglist[j].MOD_IMG;
						var indeximgchtml="";
					  if (j % 2 != 0 ) {
						  indexhtml +="<li onclick=\"window_ceng(\'"+mId+"\')\" id=\"xmlyjd\">"
						  +"<a href='javascript:void(0);'>"
						  +"<img src=" +mImgUrl+" width='306' height='211' original="+mImgUrl+">"
						  +"<div class='hzgy'>"+imglist[j].modpas_name+"</div></a></li>"
						  
						}else{
							indexhtml +="<li onclick=\"window_ceng(\'"+mId+"\')\">"
						  +"<a href='javascript:void(0);'>"
						  +"<img src=" +mImgUrl+" width='306' height='211' original="+mImgUrl+">"
						  +"<div class='hzgy'>"+imglist[j].modpas_name+"</div></a></li>"
						  
						}
					  
						  indeximgchtml = '<div id="wind'+imglist[j].MOD_ID+'"><div class="white_content">'+
						  '<div style="margin-left:50px;width:660px;height:60px;text-align:right;">'+
  						  '<a href="javascript:void(0)" onclick="closeWindown()"><img src="'+path + '"/static/tkcow/img/gb.jpg"></a>'+
  						  '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></div>'+
						  '<div style="width:561px;margin-left:50px;"><div style="width:529px;margin-left:32px;font-size:14px;">'
						  indeximgchtml+='<p style="font-size:16px; font-weight:bold; padding-top:11px;padding-bottom:11px;">'+imglist[j].modpas_name+'</p>'
						  +'<p style="font-size:14px;word-break:break-all;overflow:auto;">'+Base64.decode(Base64.decode(imglist[j].content))+'</p>';
						  indeximgchtml+='</div></div></div>';
					$("#windows").append(indeximgchtml);
				}
					 
				  indexhtml+='</ul>'
				  +'</div>'
				  +'</div>';
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
	
	var pageItems = sessionStorage.getItem("listimg");
	var pItems=JSON.parse(pageItems);
	$(".right").empty();
	$(".white_content").empty();
	var imglist;
	var indexhtml='<div class="righttitle">';
	var indeximgchtml = '<div id="wind'+pItems.menuList.length+'">'+
		'<div style="margin-left:50px;width:660px;height:60px;text-align:right;">'+
		'<a href="javascript:void(0)" onclick="closeWindown()"><img src="'+path + '"/static/tkcow/img/gb.jpg"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
		'<div style="width:561px;margin-left:50px;"><div style="width:529px;letter-spacing:0px;margin-left:32px;font-size:14px;">';
	var kk = pItems.menuList.length;
	for (var i = 0; i < kk; i++) {
		imglist=pItems.menuList[i].imglists;
	}
				indexhtml+='</div><div class="rightnr">'
				  +'<div class="xmly">'
				  +'<ul>';
				  for (var j = 0;  j< imglist.length; j++) {
					  indexhtml+='<li onclick="window_ceng(this)">'
						  +'<a href="javascript:void(0);" onclick="javascript:showbox_xmly();">'
						  +'<img src='+imglist[j].MOD_IMG+' width="306" height="211" original='+imglist[j].MOD_IMG+'>'
						  +'<div class="hzgy">'+imglist[j].modpas_name+'</div></a></li>';
						  
					  indeximgchtml+='<p style="font-size:16px; font-weight:bold; padding:11px;">'+imglist[j].modpas_name+'</p>'
					  +'<p style="font-size:14px;">'+Base64.decode(Base64.decode(imglist[j].content))+'</p>'
					  }
					 
				  indexhtml+='</ul>'
				  +'</div>'
				  +'</div>';
				  indeximgchtml+='</div></div></div>';
	$(".right").append(indexhtml);
	$(".white_content").append(indeximgchtml);
	
						
	}
function chil_change(obj){
	$(obj).children("a").css("color","#21acd8");
	$(obj).siblings("li").children("a").css("color","#333");
	}
function window_ceng(obj){
	$("#windownbg").css("display","block");
	$("#wind"+obj).children(".white_content").css("display","block");
	}
function closeWindown(){
	$("#windownbg").css("display","none");
	$(".white_content").css("display","none");
}