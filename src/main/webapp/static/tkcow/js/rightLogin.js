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
	$("#popupDatepicker").datepicker({
		numberOfMonths: 1,
		showButtonPanel: true
	});
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url(<%=basePath1%>/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url(<%=basePath1%>/static/tkcowimg/a1.png)  center center no-repeat");
			});
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
function stripscript(s)
{
var pattern = new RegExp("[`@#$^&*()=+|{}<>,\\/~￥]");
var rs = "";
for (var i = 0; i < s.length; i++) {
rs = rs+s.substr(i, 1).replace(pattern, '');
}
return rs;
} 

function huoquzl(){
	$("#means_email").val("");
	$("#means_bak").val("");	
	$("#options").empty();
	$("#means_bak").empty();
	$("#dianzika").empty();
	var heights=$(document).scrollTop();
	$(".white_content_sqzl").css("top",heights+50+"px");
	var dictList = getDictList('means_name,means_method');
	var jsonData=dictList.list;
	var jsonDatas=JSON.parse(JSON.stringify(jsonData));
	 for(var i=0;i<jsonData.length;i++){
		  if(jsonData[i].dictTypeId=="means_name")
			  {
		 			 $("#options").append('<li><span><input type="checkbox" value="'+jsonData[i].dictId+'" style="height:33px;"></span>'
		 		        	+'<span><input type="text" class="inp5" value="'+jsonData[i].dictName+'" style="padding-left:4px;" disabled></span>'
		 		           +'</li>')
			  }
		  else if(jsonData[i].dictTypeId=="means_method")
			  {
			  		$("#dianzika").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
			  }
	 }
	 
// 	 //获取索取资料
// 	    var areaCode=jQuery("#options option:selected").val();
 		//var areaName=jQuery("#options option:selected").text();
	
// 	//索取方式
// 	    var areaCodes=jQuery("#dianzika option:selected").val();
// 		var areaNames=jQuery("#dianzika option:selected").text();
		
}
//重置
function goBack(flag) {
	huoquzl();
// 	var sqObject=$("input[type='checkbox']:checked").attr("checked","false");
// 	$("#means_email").val("");
// 	$("#means_bak").val("");
}
//保存
function saveM(){
	var suoquStr="";
	var sqObject=$("input[type='checkbox']:checked");
	var sqLength=sqObject.length;
	for(var i=0;i<sqLength;i++){
		if(i==(sqLength-1)){
			suoquStr+=$(sqObject).eq(i).val();
		}else{
			suoquStr+=$(sqObject).eq(i).val()+",";
		}
	}
	
	 //获取索取资料
	    /* var nameCode=jQuery("#options option:selected").val();
		var means_name=jQuery("#options option:selected").text(); */
	//索取方式
	    var methodCodes=jQuery("#dianzika option:selected").val();
		var means_method=jQuery("#dianzika option:selected").text();
	var means_email = $("#means_email").val();
	var email_reg = new RegExp("^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$");
	if(!email_reg.test(means_email)||means_email.trim().length<=0){
		alert("请输入正确的邮箱地址");
		return;
	}
	var means_bak = $("#means_bak").val();
	
	var temp = stripscript(means_bak);

	if(temp.trim().length != means_bak.trim().length&means_bak.trim().length<=0){
		alert("不能填入非法字符！");
		return;
	}
$.post( path +"/askforClaim/save",{"means_name":suoquStr,"means_method":methodCodes,"means_email":means_email,"means_bak":means_bak},
			function(data)
			{
	var dataObject=JSON.parse(data);
	if(dataObject.flag==1){
		$(".white_content_sqzl").css("display","none");
		$("#windownbg").css("display","none");
		alert("提交成功！我们看到后会第一时间联系您！");
	}else{
		$(".white_content_sqzl").css("display","none");
		$("#windownbg").css("display","none");
		alert("提交失败");
	}
	
			});
}
function yuyueK(){
	$("#tiyan").empty();
	$("#yuyueTim").empty();
	$("#nianl").empty();
	$("#service").empty();
	$("#lianxr").val("");
	 $("#cgrs").val("");
	$("#lianxTel").val("");
	$("#means_bakT").val("");
	$("#popupDatepicker").val("");
	var heights=$(document).scrollTop();
	$(".white_content_yycg").css("top",heights+50+"px");
	var dictList = getDictList('tiyan,nianl,service,timeYY');
	var jsonData=dictList.list;
	var jsonDatas=JSON.parse(JSON.stringify(jsonData));
	for(var i=0;i<jsonData.length;i++){
	  if(jsonData[i].dictTypeId=="tiyan")
		  {
	 			 $("#tiyan").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
		  }
	  else if(jsonData[i].dictTypeId=="nianl")
		  {
		  		$("#nianl").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
		  }
	  else if(jsonData[i].dictTypeId=="service")
	 	{
	  		$("#service").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
	 	 }
	  else if(jsonData[i].dictTypeId=="timeYY")
	 	{
	  		$("#yuyueTim").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
	 	 }
 }
}
//重置
function goBackT() {
	$("#lianxr").val("");
	 $("#cgrs").val("");
	$("#lianxTel").val("");
	$("#means_bakT").val("");
	$("#popupDatepicker").val("");
}
//保存
function saveMT(){
	var reg = new RegExp("^[0-9]*$");
	var lianxr = $("#lianxr").val();
	var lianxTel = $("#lianxTel").val();
	var cgrs = $("#cgrs").val();
	if(lianxr.trim().length<=0){
		alert("请输入联系人 ");
		return;
	}
	var phoneReg = /^0\d{2,3}-?\d{7,8}$|^[1]+[3,5,8]+\d{9}$/;
	if(lianxTel.trim().length<=0||!phoneReg.test(lianxTel)){
		alert("请输入正确的电话号码");
		return;
	}
	if(!reg.test(cgrs)||cgrs.trim().length<=0){
		alert("请输入正确的人数");
		return;
	}
	var tiyanCode=jQuery("#tiyan option:selected").val();
    var nianlCode=jQuery("#nianl option:selected").val();
    var serviceCode=jQuery("#service option:selected").val();
    var yuyueTimC=jQuery("#yuyueTim option:selected").text();

	var sexCode=$("input[name='sex']:checked").val();
	var means_bakT = $("#means_bakT").val();
    
	var shiTime= $("#popupDatepicker").val();
// 	var yuyueTimC=jQuery("#yuyueTim option:selected").val();
	var timeT = shiTime+" "+yuyueTimC;
// 	    var nameCode=jQuery("#options option:selected").val();
// 		var means_name=jQuery("#options option:selected").text();
// 	    var methodCodes=jQuery("#dianzika option:selected").val();
// 		var means_method=jQuery("#dianzika option:selected").text();
	var temp = stripscript(means_bakT);

	if(temp.trim().length != means_bakT.trim().length&means_bakT.trim().length<=0){
		alert("不能填入非法字符！");
		return;
	}
$.post(path+"/orderVisit/save",
		{"visitName":lianxr,"visitTel":lianxTel,"visitCount":cgrs,"visitTime":timeT, "visitSite":tiyanCode,"visitAge":nianlCode,"visitSex":sexCode, "visitService":serviceCode,"visitBak":means_bakT},
			function(data)
			{	
			$(".white_content_yycg").css("display","none");
			$("#windownbg").css("display","none");
			alert("提交成功！我们看到后会第一时间联系您！");
			});
 
 	
}