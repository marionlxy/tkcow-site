function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
/**
 * 初始化页面信息
 */
var path = getContextPath();
$(document).ready(function(){
	//加载首页banner列表
	$.ajax({
		   type: "POST",
		   datatype : "json",
	  	   contentType : "application/json; charset=utf-8",
		   url: path+ "/homepage/queryBanner",
		   data: "",
		   async:false,
		   success: function(data){
			var jsonBanner=JSON.parse(JSON.stringify(data)).bannerData;
			for(var i=0;i<jsonBanner.length;i++){
				$("#slides").append('<img src='+ path +'/'+ jsonBanner[i].BAN_IMG_URL + ' onclick="getHrefStr(this)" original='+ jsonBanner[i].BAN_IMG_OUTSIDE+'>');
			}
		   }
		});
		//初始化首页滑动下拉一级菜单列表
		$.ajax({
			   type: "POST",
			   datatype : "json",
		  	   contentType : "application/json; charset=utf-8",
			   url: path + "/homepage/queryOneMenu",
			   data: "",
			   success: function(data){
				var jsonData=JSON.parse(JSON.stringify(data)).menuList;
				var oneHTML="";
				for(var i=0;i<jsonData.length;i++){
					var mUrl =  path + '/' + jsonData[i].MOD_URL;
					$("#quanguobuju").html("全国布局").attr("href", path +'/huodongyanglao');
					oneHTML='<li class="topnav"style="z-index:99;" >'
				                    +'<a href="' + mUrl + '" id="hlyl_id">'+jsonData[i].MOD_NAME+'</a>'
				                    +'<span style="background-image:url('+path+'/static/tkcow/img/a1.png); background-position: 50% 50%; background-repeat: no-repeat no-repeat;"></span>'
					            +'<input type="hidden" value="'+jsonData[i].MOD_ID+'"><ul style="display: none;">'          
					            +'</ul>'
				              +'</li> ';
				         $("#oneMenu").append(oneHTML); 
				}
				$(".topnav").hover(function(){
					$(this).find("ul").show();
					$(this).find("span").css("background","url("+path+"/static/tkcow/img/a2.png)  center center no-repeat");
					var flagStr=$(this).find("a").html();
					var id=$(this).find("input").val();
					var data = sessionStorage.getItem("jsonData");
					var json=JSON.parse(data);
					var liTex="";
					for(var i=0;i<json.length;i++){
						if(json[i].MOD_PARENT_ID==id){
							liTex+='<li><a href="'+path + '/'+json[i].MOD_URL+'">'+json[i].MOD_NAME+'</a></li>';
						}
					}
					$(this).find("ul").html(liTex);
				},function(){
					$(this).find("ul").hide();
					$(this).find("span").css("background","url("+path+"/static/tkcow/img/a1.png)  center center no-repeat");
				})
			   }
			});	
	
	//初始化首页滑动下拉菜单列表
	
	$.ajax({
		   type: "POST",
		   datatype : "json",
	  	   contentType : "application/json; charset=utf-8",
		   url: path+"/homepage/queryTwoMenu",
		   data: "",
		   success: function(data){
			var jsonData=JSON.parse(JSON.stringify(data)).menuList;
			var savaData=JSON.stringify(jsonData);
			sessionStorage.setItem("jsonData",savaData);
		   }
		});
	});

$(function(){
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

function getHrefStr(obj){
	var hrefStr=$(obj).attr("original") + "";
	var hrefLink;
	if(hrefStr=="" || hrefStr==null || hrefStr==undefined){
		hrefLink="#";
	}else{
		if (hrefStr.indexOf('/') == 0) {
			hrefLink = getContextPath() + hrefStr;
		} else {
			hrefLink=hrefStr;
		}
	}
	window.location.href=hrefLink;
}