
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String localUrl = request.getContextPath();
String localPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+localUrl;
%>
<head>
<!-- <title>泰康之家官方网站</title> -->
<!-- <meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords"/> -->
<!-- <meta content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"  name="description"  /> -->
<script src="<%=localPath%>/static/tkcow/js/jquery-ui.js"></script>
<script src="<%=localPath%>/static/tkcow/js/dateinput-ch-ZN.js"></script>
<script src="<%=localPath%>/static/tkcow/js/jQuery.md5.js"></script>
<script src="<%=localPath%>/static/tkcow/js/common_iu.js"></script>
<script src="<%=localPath%>/static/tkcow/js/rightLogin.js"></script>
<link rel="stylesheet" href="<%=localPath%>/static/tkcow/css/jquery-ui.css">
<script>
</script>
</head>
<body>

       <div id="floatLayer"> 
            <div style="cursor:pointer; float:right; height:256px; width:62px; overflow:hidden">
            <img src="<%=localPath%>/static/tkcow/img/a0.jpg" width="62" border="0" onclick="javascript:window.open('http://chat.taikangzhijia.com/');">
            <img src="<%=localPath%>/static/tkcow/img/a1.jpg" width="62" border="0" id="sqzl_id" onclick="huoquzl();">
            <img src="<%=localPath%>/static/tkcow/img/a2.jpg" width="62" border="0" id="yycg_id"  onclick="yuyueK();">
            <img src="<%=localPath%>/static/tkcow/img/a3.jpg" width="62" border="0" onclick1="javascript:showbox('menzhen');">
          </div>
   		</div>
<div id="windownbg"></div>
<div class="white_content_sqzl" >
	<ul>
    	<li><img src="<%=localPath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="sqzl_gb_id" ></li> 
        <div style="clear:both;"></div>
        <li><span class="font30" style="width:100%;text-align:center;">索取资料</span></li>
	        <ul id="options">
	        </ul>
        <li><span>索取方式</span>
        	<select class="inp7" id="dianzika">
<!--        	 		<option value="电子版">电子版 </option> -->
            </select>
        </li>
        <li><span>邮箱</span><input type="text"  id = "means_email" class="inp5" /></li>
        <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea id = "means_bak" class="inp9"></textarea></li>
        <li style="width:100%;text-align:center;padding-left:34px;"><input type="button" id="anniu" onclick= "saveM()" style="background:url(<%=localPath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px">
        	<input type="reset"  onclick="goBack(1)" value="" style="background:url(<%=localPath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px">
        </li>
    </ul>
</div>
<!--预约参观-->
<div class="white_content_yycg">
	<ul>
    	<li><img src="<%=localPath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="yycg_gb_id"></li>
        <div style="clear:both;"></div>
        <li><span class="font30" style="width:100%;text-align:center;">预约参观</span></li>
        <div style="margin-left:50px;text-align:left">特别提醒：申园体验馆将于3月31日停止接受预约参观，预约参观的恢复时间将另行通知。感谢您的关注！</div>
        <li><span>联系人</span><input type="text" id = "lianxr" class="inp5" /></li>
        <li><span>联系人电话</span><input type="text" id="lianxTel" class="inp5" /></li>
        <li><span>参观人数</span><input type="text" id = "cgrs" class="inp5" /></li>
        <li><span>预约时间（提前三天预约）</span>
			<input type="text" id="popupDatepicker" readonly  class="inp6">
        	<select class="inp8" id = "yuyueTim">
            </select>
        </li>
        <li><span>体验馆</span>
        	<select class="inp7" id="tiyan">
            </select>
        </li>
        <li><span>年龄</span>
        	<select class="inp7" id = "nianl">
            </select>
        </li>
        <li><span>性别</span>
        	<input type="radio" value="男 " name="sex" checked/>男
            <input type="radio" value="女" name="sex"/>女
        </li>
        <li><span>需要什么样的养老服务</span>
        	<select class="inp7" id="service">
            </select>
        </li>
        <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea class="inp9" id="means_bakT"></textarea></li>
        <li style="width:100%;text-align:center;padding-left:34px;">
        <input type="button" id="anniuT" onclick="saveMT();" style="background:url(<%=localPath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px">
        	<input type="reset"  value="" style="background:url(<%=localPath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px" onclick="goBackT();">
        </li>
        
    </ul>
</div>
	</body>
</html>

 