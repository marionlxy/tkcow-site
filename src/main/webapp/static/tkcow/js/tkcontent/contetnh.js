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
	$("#ban_div").css("display","block");
	var content=$("#content").val();
	var modName=$("#modName").val();;
	sessionStorage.setItem("content",content);
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url("+path+"/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url("+path+"/static/tkcow/img/a1.png)  center center no-repeat");
 			});
	

	$(".slidesjs-control").css("left","33px");
	var conte = sessionStorage.getItem("content");
	conte=JSON.parse(conte);

	var html='<div class="righttitle">'+modName+'</div><div class="rightnr">'+Base64.decode(conte.contentdt.hascontent)+'</div>';
	var indexhtml="";	
	for (var i = 0; i < conte.bannerlist.length; i++) {
			var banImgUrl = path + '/' + conte.bannerlist[i].BAN_IMG_URL;
				indexhtml+='<div style="width:564px;height:174px;">'
				+'<a href="'+conte.bannerlist[i].BAN_IMG_OUTSIDE+'"><img src="'+banImgUrl+'" style="width:282px;height:174px;background-size:100%;"></a>'
			var banImgUrl1 = "";
			var banOutSide = "";
			if (i+1 < conte.bannerlist.length) {
				banImgUrl1 = path + '/' + conte.bannerlist[i+1].BAN_IMG_URL;
				banOutSide = conte.bannerlist[i+1].BAN_IMG_OUTSIDE;
				indexhtml = indexhtml +'<a href="'+banOutSide+'"><img src="'+banImgUrl1+'" style="width:282px;height:174px;background-size:100%;"></a>'
				i = i + 1;
			}
				
			indexhtml=indexhtml+'</div>';
		}
	$(".right").html(html)
	$("#slides1").html(indexhtml);
	slides();
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
			//console.log($(aList[i]));
			$(aList[i]).parents("li").next("div").css("display","block");
			$(aList[i]).parents("li").siblings("li").next("div").css("display","none");
			break;
			}
		};

	$(".slidesjs-control").css("left","33px");
	$(".right").empty();
	var conte = sessionStorage.getItem("content");
	conte=JSON.parse(conte);
	$(".right").append(
			'<div class="righttitle">'+modName+'</div><div class="rightnr">'+conte.contentdt.hascontent+'</div>');
		for (var i = 0; i < conte.bannerlist.length; i++) {
			var banImgUrl = path + '/' + conte.bannerlist[i].BAN_IMG_URL;
			var banImgUrl1 = "";
			var bannerOutSide = "";
			if (i*2+1 <= conte.bannerlist.length) {
				banImgUrl1 = path + '/' + conte.bannerlist[i+1].BAN_IMG_URL;
				bannerOutSide = conte.bannerlist[i+1].BAN_IMG_OUTSIDE;
			}
			
			var indexhtml='<div style="width:564px;height:174px;">'
				+'<a href="'+conte.bannerlist[i].BAN_IMG_OUTSIDE+'"><img src="'+banImgUrl+'" style="width:282px;height:174px;background-size:100%;"></a>'
				+'<a href="'+bannerOutSide+'"><img src="'+banImgUrl1+'" style="width:282px;height:174px;background-size:100%;"></a>'
				//+'<div style="width:282px;height:31px;margin-top:-31px;text-align:center;background:url(${rootPath}/static/tkcow/img/listbg.png) repeat-x;position: absolute;">'
					//+'<a style="width:282px;height:31px;line-height:31px;font-size:17px;">'+conte.bannerlist[i].BAN_IMG_DES+'</a>'
				//+'</div>'
				//+'<div style="width:282px;height:31px;margin-top:-31px;text-align:center;background:url(${rootPath}/static/tkcow/img/listbg.png) repeat-x;position: absolute;margin-left:282px;">'
					//+'<a style="width:282px;height:31px;line-height:31px;font-size:17px;">'+conte.bannerlist[i+1].BAN_IMG_DES+'</a>'
				//+'</div>'
			+'</div>';
			i=i+1;
		$("#slides1").append(indexhtml);
		}		
			setTimeout(slides,100);
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