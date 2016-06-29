<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String baseUrl = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+baseUrl;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:set var="rootPath" value="<%=baseUrl%>"></c:set>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<!-- <title>泰康之家官方网站</title> -->
<!-- <meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords"/> -->
<!-- <meta content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"  name="description"  /> -->
<meta itemprop="operatingSystems" content="Windows,Mac,linux"/> 
<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/banner.css">
<script src="<%=basePath%>/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="<%=basePath%>/static/tkcow/js/jquery-ui.js"></script>
<script src="<%=basePath%>/static/tkcow/js/dateinput-ch-ZN.js"></script>
<script src="<%=basePath%>/static/tkcow/js/jQuery.md5.js"></script>
<script src="<%=basePath%>/static/tkcow/js/common_iu.js"></script>
<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/jquery-ui.css">
<script type="text/javascript" src="<%=basePath%>/static/js/Pc_web_sdk_release_3.0.0.js" td-appid="C4580FE1C98709712000152A3006092A"></script>

<script>
	
$(function(){
	$("#popupDatepicker").datepicker({
		numberOfMonths: 1,
		showButtonPanel: true
	});
	$(".content_main li").hover(function(){
		$(this).find("ul").show();
		$(this).find("span").css("background","url(<%=basePath%>/static/tkcow/img/a2.png)  center center no-repeat");
		},function(){
			$(this).find("ul").hide();
			$(this).find("span").css("background","url(<%=basePath%>/static/tkcowimg/a1.png)  center center no-repeat");
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




</script>
</head>
<body>
    
     

<div id="windownbg"></div>
<div class="white_content_sqzl">
<SCRIPT language=javascript >

function huoquzl(){
	$("#means_email").val("");
	$("#means_bak").val("");	
	$("#options").empty();
	$("#means_bak").empty();

	
	var dictList = getDictList('means_name,means_method');
	var jsonData=dictList.list;
	var jsonDatas=JSON.parse(JSON.stringify(jsonData));
	 for(var i=0;i<jsonData.length;i++){
		  if(jsonData[i].dictTypeId=="means_name")
			  {
		 			 $("#options").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>')
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
	$("#means_email").val("");
	$("#means_bak").val("");
}
//保存
function saveM(){
	 //获取索取资料
	    var nameCode=jQuery("#options option:selected").val();
		var means_name=jQuery("#options option:selected").text();
	
	//索取方式
	    var methodCodes=jQuery("#dianzika option:selected").val();
		var means_method=jQuery("#dianzika option:selected").text();
	var means_email = $("#means_name").val();
	var means_bak = $("#means_bak").val();
$.post("${rootPath}/askforClaim/save",{"means_name":nameCode,"means_method":methodCodes,"means_email":means_email,"means_bak":means_bak},
			function(data)
			{	
	$(".white_content_sqzl").css("display","none");
	$("#windownbg").css("display","none");
			});
 
 	
}

</script>
	<ul>
    	<li><img src="<%=basePath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="sqzl_gb_id" ></li> 
        <div style="clear:both;"></div>
        <li><span class="font30" style="width:100%;text-align:center;">索取资料</span></li>
        <li><span>索取资料</span>
        	<select class="inp7" id="options">	
<!--        	 		<option value="北京燕园社区相关资料">北京燕园社区相关资料 </option> -->
<!--                 <option value="上海申园社区相关资料">上海申园社区相关资料 </option> -->
<!--                 <option value="广州粤园社区相关资料">广州粤园社区相关资料 </option> -->
            </select>
        </li>
        <li><span>索取方式</span>
        	<select class="inp7" id="dianzika">
<!--        	 		<option value="电子版">电子版 </option> -->
            </select>
        </li>
        <li><span>邮箱</span><input type="text"  id = "means_email" class="inp5" /></li>
        <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea id = "means_bak" class="inp9"></textarea></li>
        <li style="width:100%;text-align:center;padding-left:34px;"><input type="button" id="anniu" onclick= "saveM()" style="background:url(<%=basePath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px">
        	<input type="reset"  onclick="goBack(1)" value="" style="background:url(<%=basePath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px">
        </li>
        
    </ul>
</div>
<!--预约参观-->
<div class="white_content_yycg">

<SCRIPT language=javascript >

function yuyueK(){
	$("#tiyan").empty();
	$("#nianl").empty();
	$("#service").empty();
	$("#lianxr").val("");
	 $("#cgrs").val("");
	$("#lianxTel").val("");
	$("#means_bakT").val("");
	$("#popupDatepicker").val("");
	
	var dictList = getDictList('tiyan,nianl,service');
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
	var lianxr = $("#lianxr").val();
	var lianxTel = $("#lianxTel").val();
	var cgrs = $("#cgrs").val();

	var tiyanCode=jQuery("#tiyan option:selected").val();
    var nianlCode=jQuery("#nianl option:selected").val();
    var serviceCode=jQuery("#service option:selected").val();
	var sexCode=$("input[name='sex']:checked").val();
	var means_bakT = $("#means_bakT").val();
    
	var shiTime= $("#shiTime").val();
	var yuyueTimC=jQuery("#yuyueTim option:selected").val();
	var timeT = shiTime+yuyueTimC;
// 	    var nameCode=jQuery("#options option:selected").val();
// 		var means_name=jQuery("#options option:selected").text();
// 	    var methodCodes=jQuery("#dianzika option:selected").val();
// 		var means_method=jQuery("#dianzika option:selected").text();
$.post("${rootPath}/orderVisit/save",
		{"visitName":lianxr,"visitTel":lianxTel,"visitCount":cgrs,"visitTime":timeT, "visitSite":tiyanCode,"visitAge":nianlCode,"visitSex":sexCode, "visitService":serviceCode,"visitBak":means_bakT},
			function(data)
			{	
			$(".white_content_yycg").css("display","none");
			$("#windownbg").css("display","none");
			});
 
 	
}

</script>

	<ul>
    	<li><img src="<%=basePath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="yycg_gb_id"></li>
        <div style="clear:both;"></div>
        <li><span class="font30" style="width:100%;text-align:center;">预约参观</span></li>
        <li><span>联系人</span><input type="text" id = "lianxr" class="inp5" /></li>
        <li><span>联系人电话</span><input type="text" id="lianxTel" class="inp5" /></li>
        <li><span>参观人数</span><input type="text" id = "cgrs" class="inp5" /></li>
        <li><span>预约时间（提前三天预约）</span>
<!--         	<input type="text" class="inp6 hasDatepicker" id = "shiTime"/> -->
			<input type="text" id="popupDatepicker" readonly  class="inp6">
        	<select class="inp8" id = "yuyueTim">
       	 		<option value="09:00">09:00 </option>
                <option value="10:00">10:00 </option>
                <option value="11:00">11:00 </option>
                <option value="12:00">12:00 </option>
                <option value="13:00">13:00 </option>
                <option value="14:00">14:00 </option>
                <option value="15:00">15:00 </option>
                <option value="16:00">16:00 </option>
                <option value="17:00">17:00 </option>
            </select>
        </li>
        <li><span>体验馆</span>
        	<select class="inp7" id="tiyan">
<!--        	 		<option value="泰康之家·燕园">泰康之家·燕园 </option> -->
<!--                 <option value="泰康之家·申园">泰康之家·申园 </option> -->
<!--                 <option value="泰康之家·粤园">泰康之家·粤园 </option> -->
<!--                 <option value="泰康之家·吴园">泰康之家·吴园 </option> -->
            </select>
        </li>
        <li><span>年龄</span>
        	<select class="inp7" id = "nianl">
<!--        	 		<option value="60岁以上">60岁以上 </option> -->
<!--                 <option value="60岁以下">60岁以下 </option> -->
            </select>
        </li>
        <li><span>性别</span>
        	<input type="radio" value="男 " name="sex" checked/>男
            <input type="radio" value="女" name="sex"/>女
        </li>
        <li><span>需要什么样的养老服务</span>
        	<select class="inp7" id="service">
<!--        	 		<option value="独立生活">独立生活 </option> -->
<!--                 <option value="协助生活">协助生活 </option> -->
<!--                 <option value="专业护理">专业护理 </option> -->
<!--                 <option value="康复治疗">康复治疗 </option> -->
<!--                 <option value="其他">其他 </option> -->
            </select>
        </li>
        
        <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea class="inp9" id="means_bakT"></textarea></li>
        <li style="width:100%;text-align:center;padding-left:34px;">
        <input type="button" id="anniuT" onclick="saveMT();" style="background:url(<%=basePath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px">
        	<input type="reset"  value="" style="background:url(<%=basePath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px" onclick="goBackT();">
        </li>
        
    </ul>
</div>




       <div id="floatLayer"> 

            <div style="cursor:pointer; float:right; height:256px; width:62px; overflow:hidden">
             <img src="<%=basePath%>/static/tkcow/img/a0.jpg" width="62" border="0" onclick="javascript:window.open('http://chat.taikangzhijia.com/');">
            <img src="<%=basePath%>/static/tkcow/img/a1.jpg" width="62" border="0" id="sqzl_id" onclick="huoquzl();">
            
            <img src="<%=basePath%>/static/tkcow/img/a2.jpg" width="62" border="0" id="yycg_id"  onclick="yuyueK();">
            
            <img src="<%=basePath%>/static/tkcow/img/a3.jpg" width="62" border="0" onclick1="javascript:showbox('menzhen');">
          </div>
   		</div>

	</body>
</html>

 