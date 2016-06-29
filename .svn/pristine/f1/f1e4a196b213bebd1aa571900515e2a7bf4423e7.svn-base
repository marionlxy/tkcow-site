function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
/**
 * 初始化页面信息
 */
var path = getContextPath();
$(function() {
	$(".content_main li").hover(
			function() {
				$(this).find("ul").show();
				$(this).find("span").css("background",
						"url(img/a2.png)  center center no-repeat");
			},
			function() {
				$(this).find("ul").hide();
				$(this).find("span").css("background",
						"url("+ path +"/static/tkcow/img/a1.png)  center center no-repeat");
			});
	$("#sqzl_id").click(function() {
		$("#windownbg").css("display", "block");
		$(".white_content_sqzl").css("display", "block");
	});
	$("#sqzl_gb_id").click(function() {
		$("#windownbg").css("display", "none");
		$(".white_content_sqzl").css("display", "none");
	});
	$("#yycg_id").click(function() {
		$("#windownbg").css("display", "block");
		$(".white_content_yycg").css("display", "block");
	});
	$("#yycg_gb_id").click(function() {
		$("#windownbg").css("display", "none");
		$(".white_content_yycg").css("display", "none");
	});
});

$(function() {
	var WIDTH=$(window).width();
	$('#slides').slidesjs({
	width:WIDTH,
	height:382,
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
});