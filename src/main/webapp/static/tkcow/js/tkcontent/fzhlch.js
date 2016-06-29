function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
var path=getContextPath();
$(function() {
	var url=document.getElementById('url').value;
	var banUrl = path + '/' + url;
	var cs = "url('" + banUrl + "')";
	$(".banner2").css("background",cs);
		var id = document.getElementById('id').value;
		var parcont = document.getElementById('parcont').value;
		var chilrcont = document.getElementById('chilrcont').value;
		sessionStorage.setItem("parcont",parcont);
		sessionStorage.setItem("chilrcont",chilrcont);
		$(".content_main li").hover(
				function() {
					$(this).find("ul").show();
					$(this).find("span").css("background",
							"url(img/a2.png)  center center no-repeat");
				},
				function() {
					$(this).find("ul").hide();
					$(this).find("span").css("background",
							"url("+path+"/static/tkcow/img/a1.png)  center center no-repeat");
				});
		var parcont = sessionStorage.getItem("parcont");
		var chilrcont = sessionStorage.getItem("chilrcont");
		var parcon=JSON.parse(parcont);
		var chilrcon=JSON.parse(chilrcont); //转成对象
		var parco = parcon.parcont;  //获取父节点内容
		var chilrco = chilrcon.chirroco; //获取子节点内容
		var chircont;//循环子节点数组内容
		for (var i = 0; i < chilrco.length; i++) {
			chircont=chilrco[i].chilrcont;
		}
		var content = "";
		if (parco.content != null || parco.content != '') {
			content = Base64.decode(Base64.decode(parco.content));
		}
		var xwhtml;
			$("#rightn1").empty();
			$("#rightn1").html(content);
			$("#tbd").empty();
			for (var j = 0; j < chircont.length; j++) {
				if(j==0){
					xwhtml='<tr>'
						+'<td width="72" valign="top" style="float:left;">'
						+'<div style="background: url('+path+'/static/tkcow/img/dian_title.jpg) no-repeat; width: 72px; height: 50px; text-align: center;">'
						+'<span style="padding-top: 25px; font-size: 18px; display: block; color: #018A7C" id="modname">'+chircont[j].mod_name+'</span>'
						+'</div>'
						+'</td>'
						+'<td width="" style="float:left;">'
						+'<div style="width: 500px; margin-left: 25px; font-size: 13px; line-height: 35px" id="conmod">'+Base64.decode(Base64.decode(chircont[j].CONTENT))
						+'</div>'
						+'</td>'
						+'</tr>'
				}else{
					xwhtml='<tr>'
						+'<td width="72" valign="top" style="float:left;margin-top:30px;">'
						+'<div style="background: url('+path+'/static/tkcow/img/dian_title.jpg) no-repeat; width: 72px; height: 50px; text-align: center;">'
						+'<span style="padding-top: 25px; font-size: 18px; display: block; color: #018A7C" id="modname">'+chircont[j].mod_name+'</span>'
						+'</div>'
						+'</td>'
						+'<td width="" style="float:left;margin-top:30px;">'
						+'<div style="width: 500px; margin-left: 25px; font-size: 13px; line-height: 35px" id="conmod">'+Base64.decode(Base64.decode(chircont[j].CONTENT))
						+'</div>'
						+'</td>'
						+'</tr>';
				}
				
				
			$("#tbd").append(xwhtml);
			}
	});
	function leftLiClick(obj) {
		$(obj).children("a").css("color", "#0a8a7a");
		$(obj).siblings("li").children("a").css("color", "#333");
		$(obj).next("div").css("display", "block");
		$(obj).siblings("li").next("div").css("display", "none");
	}