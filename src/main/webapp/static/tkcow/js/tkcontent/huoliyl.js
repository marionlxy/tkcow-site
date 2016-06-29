function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
var path=getContextPath();

$(function(){
	var url=$("#url").val();
	var banUrl = path + '/' + url;
	var cs = "url('" + banUrl + "')";
	$(".banner2").css("background",cs);
	
	var id = document.getElementById('id').value;
	var contentlist = document.getElementById('contlist').value;
	//alert(contentlist);
	sessionStorage.setItem("contentlist",contentlist);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url("+path+"/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+path+"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	$(".right").empty();
	var contentlist1 = sessionStorage.getItem("contentlist");
	var conteli=JSON.parse(contentlist1);
	var colist = conteli.contlist;
	var colists;
	for (var j = 0; j < colist.length; j++) {
		colists=colist[j].contlist;
	}
	
	var contehtml='<div class="rightnr">'+Base64.decode(conteli.contents.contentst)+'</div>';
	for (var i = 0; i < colists.length; i++) {
		var imgUrl = path + '/' + colists[i].mod_img;
		
		contehtml+='<div class="nrlist">'+
				  '<div class="nrtitle">'+colists[i].mod_name+'</div>'+
				  '<dl>'+
                  '<dt><a href='+colists[i].mod_url+'><img src= "' + imgUrl + '" width="190" height="131" /></a></dt>'+
                  '<dd>'+colists[i].mod_des+'</dd>'+
                  '</dl>'+
                  '<div style="width:597px;border:0px;height:79px;">'+
                  '<a style="float:right;padding-top:10px;" href="'+colists[i].mod_url+'"><img src="'+path+'/static/tkcow/img/seeMore.jpg" width="103" height="39"/></a>'+
                  '</div></div></div>';
	}
	
	$(".right").html(contehtml);
	
});
function leftLiClick(obj){
	$(obj).children("a").css("color","#f07905");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
	}
function left_change(obj){
	$(obj).children("a").css("color","#f07905");
	$(obj).siblings("li").children("a").css("color","#333");
	}
function more_text(obj){
	var clickTXT=$(obj).parents(".nrlist").find(".nrtitle").html();
	var aList=$(".leftdh").children("ul").children("li").children("a");
	for(var i=0;i<aList.length;i++){
		if($(aList[i]).html()==clickTXT){
			$(aList[i]).parents("li").next("div").css("display","block");
			$(aList[i]).parents("li").siblings("li").next("div").css("display","none");
			break;
			}
		};
	slides();
	$(".slidesjs-control").css("left","33px");
}

function slides(){
	$('#slides1').slidesjs({
		width:564,
		height:174,
		start: 1,
		play: {
		  auto: true,
		  swap: true, 
		  pauseOnHover: true
		},
		navigation:{
		  active: true//是否开启左右按钮
		  
		},
		effect: {
		  slide: {
			// 滑动效果设置.
			speed: 200
			  // [number] 速度以毫秒为单位的幻灯片动画。
			}
		  }
	  }); 
	
	}