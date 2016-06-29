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
// 	$("#popupDatepicker").datepicker({
// 		numberOfMonths: 1,
// 		showButtonPanel: true
// 	});
	 $('#kaptchaImage').click(function () {
	     //生成验证码  
	     $(this).hide().attr('src', '../ValidateCodeServlet/Validate.png?' + Math.floor(Math.random()*100) ).fadeIn();  
	     event.cancelBubble=true;  
	    });  
// 	$(".content_main li").hover(function(){
// 		$(this).find("ul").show();
<%-- 		$(this).find("span").css("background","url(<%=basePath%>/static/tkcow/img/a2.png)  center center no-repeat"); --%>
// 		},function(){
// 			$(this).find("ul").hide();
<%-- 			$(this).find("span").css("background","url(<%=basePath%>/static/tkcowimg/a1.png)  center center no-repeat"); --%>
// 			});
// 	$("#sqzl_id").click(function(){
// 		$("#windownbg").css("display","block");
// 		$(".white_content_sqzl").css("display","block");
// 		});
// 	$("#sqzl_gb_id").click(function(){
// 		$("#windownbg").css("display","none");
// 		$(".white_content_sqzl").css("display","none");
// 		});
// 	$("#yycg_id").click(function(){
// 		$("#windownbg").css("display","block");
// 		$(".white_content_yycg").css("display","block");
// 		});
// 	$("#yycg_gb_id").click(function(){
// 		$("#windownbg").css("display","none");
// 		$(".white_content_yycg").css("display","none");
// 		});
	
	
	
	  
	
});
//验证码
function changeCode() {  
    $('#kaptchaImage').hide().attr('src', '../ValidateCodeServlet/Validate.png?' + Math.floor(Math.random()*100) ).fadeIn();  
    event.cancelBubble=true;  
}



</script>
</head>
<body>
     <div class="allContent">
     <%@ include file="/WEB-INF/view/tkcow/titile.jsp"%>
<!--         <div class="content_top" style="margin:0 auto;"> -->
<!--             <div class="content_logo"> -->
<!--                 <a href="index.html"> -->
<%--                 <img src="<%=basePath%>/static/tkcow/img/logo.jpg" width="203" height="56" title="泰康之家官方网站" original="<%=basePath%>/static/tkcow/img/logo.jpg"> --%>
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="headright"> -->
<!--                <div class="content_Topimg">  -->
<!--                     <ul> -->
<!--                        <li class="t1"><a href="index.html">泰康之家</a></li>  -->
<!--                        <li class="t2"><a href="huoliyl.html">全国布局</a></li>  -->
<!--                        <li class="t3"><a href="#">微信帐号</a><span></span></li>  -->
<!--                        <li class="t4"><a href="login.html">会员登录</a></li>  -->
<!--                     </ul> -->
<!--                 </div> -->
<!--               <div class="content_tel">40060-95522</div> -->
<!--             </div> -->
<!--         </div> -->
        
<!--         <div class="content_main"> -->
<!--             <div class="content_main983"> -->
<!--                 <ul>                    -->
<!--                 <li class="topnav"> -->
<!--                     <a href="huoliyl.html">活力养老</a> -->
<%--                     <span style="background-image:url(<%=basePath%>/static/tkcow/img/a1.png); background-position: 50% 50%; background-repeat: no-repeat no-repeat;"></span> --%>
<!--                 <ul style="display: none;"> -->
<!--                     <li><a href="#">>都市医养社区</a></li> -->
<!--                     <li><a href="#">>度假特色社区</a></li> -->
<!--                     <li><a href="#">>联盟养老社区</a></li> -->
<!--                     <li><a href="#">>社区特色服务</a></li> -->
<!--                     <li><a href="#">>社区文化产品</a></li> -->
<!--                     <li><a href="#">>我的养老规划</a></li>                -->
<!--                  </ul> -->
<!--               </li>                     -->
<!--               <li class="topnav"> -->
<!--                  <a href="gdyl.html">高端医疗</a> -->
<%--                  <span style="background-image: url(<%=basePath%>/static/tkcow/img/a1.png); background-position: 50% 50%; background-repeat: no-repeat no-repeat;"></span> --%>
<!--                 <ul style="display: none;"> -->
<!--                     <li><a href="#">国际综合医院</a></li> -->
<!--                     <li><a href="#">康复医疗连锁</a></li> -->
<!--                     <li><a href="#">高端名医诊所</a></li> -->
<!--                     <li><a href="#">全球医疗直通</a></li> -->
<!--                     <li><a href="#">全程健康管理</a></li>                -->
<!--                 </ul> -->
<!--              </li>                     -->
<!--              <li class="topnav"> -->
<!--              <a href="qyshq.html">企业社区</a> -->
<%--              <span style="background-image: url(<%=basePath%>/static/tkcow/img/a1.png); background-position: 50% 50%; background-repeat: no-repeat no-repeat;"></span> --%>
<!--              <ul style="display: none;"> -->
<!--                 <li><a href="#">泰康企业社区</a></li> -->
<!--                 <li><a href="#">企业管家服务</a></li> -->
<!--                 <li><a href="#">员工生活服务</a></li> -->
<!--                 <li><a href="#">租赁垂询</a></li>                -->
<!--                 </ul> -->
<!--             </li>                     -->
<!--             <li class="topnav"> -->
<%--           <a href="gywm.html">关于我们</a><span style="background-image: url(<%=basePath%>/static/tkcow/img/a1.png); background-position: 50% 50%; background-repeat: no-repeat no-repeat;"></span> --%>
<!--              <ul style="display: none;"> -->
<!--                 <li><a href="#">关于泰康之家</a></li> -->
<!--                 <li><a href="#">发展历程</a></li> -->
<!--                 <li><a href="#">企业荣誉</a></li> -->
<!--                 <li><a href="#">加入我们</a></li> -->
<!--                 <li><a href="#">联系我们</a></li>                -->
<!--                 </ul> -->
<!--             </li>                                                                                      -->
<!--            <li class="searchbg"> -->
<!--                 <form id="form1" name="form1" method="get" action="/so.php"> -->
<!--                     <input name="skey" type="text" class="search_text" style="height:18px; margin-top:13px; margin-left:10px; border:0px; line-height:20px" id="skey"> -->
<!--                     <input type="submit" value="" class="search_submit"> -->
<!--                 </form> -->
<!--                 Powered by MINETHINK -->
<!--                 www.minethink.com -->
<!--             </li> -->
<!--            </ul> -->
<!--         </div> -->
<!--    </div> -->
     
     <div class="dlzc"></div>
        <div class="synr1">
        <div class="main" style="margin:0 auto;">
           <div class="ltitle">| 登录注册</div>
           
       <script language=javascript >
          //登录
			function getidT(id)
	        {
	          return  document.getElementById(id);
	        }
            function loginAction() {
            	 if(getidT('login_username').value=="" )
                 {
                     alt=alt+'姓名不能为空\n'; 
                 }
            	 if(getidT('login_password').value=="" )
                 {
                     alt=alt+'密码不能为空\n'; 
                 }
            	 if(getidT('validatecodepro').value=="" )
                 {
                     alt=alt+'验证码不能为空\n'; 
                 }else{
                	 
            		var username =$("#login_username").val(); //对数据加密
            		var password =$.md5($("#login_password").val());
            		var validatecodepro =$("#validatecodepro").val();
            		 
            		$.post("${rootPath}/loginT/login",{"login_username":username,"login_password":password,"validatecodepro":validatecodepro},
                  			function(data)
                  			{	
            				var jsonDatas=JSON.parse(JSON.stringify(data));
            			 	if(jsonDatas.result == 'true' || jsonDatas.result == true){
            			 			window.location.href = "${rootPath}/tkcow/index";
	            				 }else{
	            					 alert(jsonDatas.srt);
	            				 }
                  			});
            		 
            	}
            }
        </script>
          <div class="dlkuang">
               <div class="dlleft">
               <p>&nbsp;</p>
               <p>&nbsp;</p>
               <p class="font20">老用户登陆</p>
               <p>&nbsp;</p>
<!--                <form id="form2" name="form2" method="post" action="?action=chk"> -->

           <form id="loginForm" >

               <table width="100%" border="0" cellspacing="0" cellpadding="0">
           
          <tr>
            <td width="17%" height="70">用户名</td>
            <td colspan="2"><input type="text" name="login_username" id="login_username"  class="inp3"/></td>
            <td width="30%">&nbsp;</td>
          </tr>
          <tr>
            <td height="70">密   &nbsp;&nbsp;码</td>
            <td colspan="2">
              <input type="password" name="login_password" id="login_password"   class="inp3"/>
            </td>
            <td class="font12">&nbsp;&nbsp;忘记密码</td>
          </tr>
          <tr style="height:70px;line-height:70px;">
            <td style="padding-top:10px;">验证码</td>
            
            
            <td width="26%"><input name="validatecodepro" id="validatecodepro" maxlength="4"  class="inp4" style="float:left"/>
					<img src="../ValidateCodeServlet/Validate.png" id="kaptchaImage" style="position:relative;float:left;margin-left:34px;" border='0' width="100" height="34" /> <a href="#" onclick="changeCode()"></a>
			
			</td>
						
<!-- 				提交表单		 -->
<%--            		 <form id="loginForm" method="post" action="${rootPath}/login"> --%>
<!-- 							<input type="hidden" name="username" id="username"/> -->
<!-- 							<input type="hidden" name="password" id="password"/> -->
<!-- 			   	 </form> -->
            
            
<!--             <td width="26%"><input type="text" class="inp4" style="float:left"/> -->
<!--             <input type="text" name="code" id="code"  class="inp4" style="position:absolute;opacity:0.5;background:#fff;z-index:1000;border:none;text-align:center;font-size:16px;float:left;margin-left:-100px;" disabled="disabled"/> -->
<!-- 	            <a href="#" onclick="createCode()"> -->
<%-- 	            	<img style="position:relative;float:left;margin-left:34px;"  src='<%=basePath%>/static/tkcow/img/y1zm.png' border='0' width="100" height="34" id="kaptchaImage"/> --%>
<!-- 	            </a> -->
<!--             </td> -->

          </tr>
          <tr>
            <td height="70">&nbsp;</td>
            <td colspan="3"><input  type="button" value="" id="login" onclick="loginAction()" style="background:url(<%=basePath%>/static/tkcow/img/tj.jpg); border:0px; width:232px; height:41px" /></td>
            </tr>
        </table></form>
			</div>
               <div class="dlright">
                 <p>&nbsp;</p>
                 <p>&nbsp;</p>
                 <p class="font20">新用户注册</p>
                 <p class="font20">&nbsp;</p>
                 <p></p>
        <SCRIPT language=javascript >
        function getid(id)
        {
          return  document.getElementById(id);
        }
        function check()
        { 
            var err,reg = /^(.+)@(.+)\.(.+)$/;
            err=0;
            alt='';
            if(getid('xm').value=="" )
            {
                alt=alt+'姓名不能为空\n'; 
                err++;
            }
            if(getid('tel').value=="" )
            {
                alt=alt+'电话不能为空\n'; 
                err++;
            }
            if(getid('email').value=="" )
            {
                alt=alt+'email不能为空\n'; 
                err++;
            }
            else if(!reg.test(getid('email').value)){
                alt=alt+'电子邮件地址无效，应当与xxx@126.com等格式\n';  
             }
             
            if(getid('username').value==""  )
            {
                alt=alt+'用户名不能为空\n'; 
                err++;
            }
            if(getid('password').value==""  )
            {
                alt=alt+'密码不能为空\n'; 
                err++;
            }
            
            if (getid('password').value.length<8||getid('password').value.length>32) 
            {
                alt=alt+'密码格式（8-20字，至少使用一个字母，数字或符号）\n';
                err++;
            }else{
            	
				var password = $.md5($("#password").val());
        		
            	$("#password").val(password);
            	
				var repassword = $.md5($("#repassword").val());
        		
            	$("#repassword").val(repassword);
            }
            
            if(getid('password').value!==getid('repassword').value  )
            {
                alt=alt+'密码和确认密码不一致！\n'; 
                err++;
            }
        
            if(err>0) {alert(alt);return false;}
             
        }

        </script>
             <form id="registerform"  method="post" action="${rootPath}/userTk/save"  onsubmit="return check();"><input type="hidden" name="token" value="6e1227429af1f72b2d19ef28583bf74f"/> 
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10%" align="right" class="fontred">*</td>
            <td width="15%" height="62" align="right">姓   名<br /></td>
            <td width="2%">&nbsp;</td>
            <td width="73%"><input type="text" name="xm" id="xm"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">电   话<br /></td>
            <td>&nbsp;</td>
            <td><input type="text" name="tel" id="tel"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">E-mail<br /></td>
            <td>&nbsp;</td>
            <td><input type="text" name="email" id="email"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">城市<br /></td>
            <td>&nbsp;</td>
            <td><input type="text" name="address" id="address"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">用户名<br /></td>
            <td>&nbsp;</td>
            <td><input type="text" name="username" id="username"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">设置密码<br /></td>
            <td>&nbsp;</td>
            <td><input type="password" name="password" id="password"  class="inp3"/></td>
          </tr>
          <tr>
            <td align="right" class="fontred">*</td>
            <td height="62" align="right">确认密码</td>
            <td>&nbsp;</td>
            <td><input type="password" name="repassword" id="repassword"  class="inp3"/></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="62">&nbsp;</td>
            <td>&nbsp;</td>
            <td class="font12">
              <input name="radio" type="radio" id="radio" value="radio" checked="checked" />
           
              同意泰康之家条款</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="62">&nbsp;</td>
            <td>&nbsp;</td>
            <td><input  type="submit" value="" style="background:url(<%=basePath%>/static/tkcow/img/zc.jpg); border:0px; width:232px; height:41px" /></td>
          </tr>
        </table>
        </form>
        </div>
           </div>    
        </div>
</div>

<div class="synrbottom"></div>

<%@ include file="/WEB-INF/view/tkcow/foot.jsp"%>
    
<!--   <div class="foot"> -->
<!--     <p>泰康人寿 版权所有  京ICP备15000213号<br> -->
<!--     Copyright Taikanglife.&nbsp;All Rights Reserved </p> -->
<!--       <p>本网站所有资讯与说明文字仅供参考，如有与本公司相关公告及产品法律文件不符，以相关公告及产品法律文件为准。 </p> -->
<!--         <div class="copyright"> -->
<!--         	<table width="100%" border="0" cellspacing="0" cellpadding="0"> -->
<!--       			<tbody> -->
<!--                     <tr> -->
<!--                         <td align="right" class="footdh"> -->
<!--                             <a href="flshm.html">法律声明</a> |      -->
<!--                             <a href="wzhdt.html">网站地图</a> |     -->
<!--                             <a href="gywm.html">常见问题</a> |      -->
<!--                             <a href="#">联系我们</a> |      -->
<!--                             <a href="#">招聘信息</a> -->
<!--                          </td> -->
<!--                   </tr> -->
<!--             </tbody> -->
<!--         </table> -->
<!--     <div style="height:5px"></div> -->
<!--       <table width="283" border="0" align="right" cellpadding="0" cellspacing="0"> -->
<!--         <tbody> -->
<!--         <tr> -->
<%--         <td width="30" height="29" align="center" valign="middle"><a href="#"><img src="<%=basePath%>/static/tkcow/img/s1.jpg"></a></td> --%>
<%--         <td width="30" align="center" valign="middle"><a href="#"><img src="<%=basePath%>/static/tkcow/img/s2.jpg"></a></td> --%>
<%--         <td width="30" align="center" valign="middle"><a href="#"><img src="<%=basePath%>/static/tkcow/img/s3.jpg"></a></td> --%>
<%--         <td width="30" align="center" valign="middle"><a href="#"><img src="<%=basePath%>/static/tkcow/img/s4.jpg"></a></td>  --%>
<!--           <td>  -->
<!--               <div class="search"> -->
<!--                 <select name="" class="inp" onchange="if(this.options[selectedIndex].value!=='-1')window.open(this.options[selectedIndex].value)"> -->
<!--                   <option value="-1">访问泰康其他网站</option> -->
<!--                   <option value="#">泰康人寿</option> -->
<!--                   <option value="#">泰康资产</option> -->
<!--                   <option value="#">泰康养老</option> -->
<!--                 </select> -->
<!--              </div> -->
<!--          </td> -->
<!--      	<td width="10"></td> -->
<!--         </tr> -->
<!--       </tbody></table> -->
<!--       </div> -->
<!-- 	</div> -->


<!-- <div class="white_content_sqzl"> -->
<!-- <SCRIPT language=javascript > -->

<!-- // function huoquzl(){ -->
<!-- // 	$("#means_email").val(""); -->
<!-- // 	$("#means_bak").val("");	 -->
<!-- // 	$("#options").empty(); -->
<!-- // 	$("#means_bak").empty(); -->

	
<!-- // 	var dictList = getDictList('means_name,means_method'); -->
<!-- // 	var jsonData=dictList.list; -->
<!-- // 	var jsonDatas=JSON.parse(JSON.stringify(jsonData)); -->
<!-- // 	 for(var i=0;i<jsonData.length;i++){ -->
<!-- // 		  if(jsonData[i].dictTypeId=="means_name") -->
<!-- // 			  { -->
<!-- // 		 			 $("#options").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>') -->
<!-- // 			  } -->
<!-- // 		  else if(jsonData[i].dictTypeId=="means_method") -->
<!-- // 			  { -->
<!-- // 			  		$("#dianzika").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>') -->
<!-- // 			  } -->
<!-- // 	 } -->
	 
<!-- // // 	 //获取索取资料 -->
<!-- // // 	    var areaCode=jQuery("#options option:selected").val(); -->
<!-- //  		//var areaName=jQuery("#options option:selected").text(); -->
	
<!-- // // 	//索取方式 -->
<!-- // // 	    var areaCodes=jQuery("#dianzika option:selected").val(); -->
<!-- // // 		var areaNames=jQuery("#dianzika option:selected").text(); -->
		
<!-- // } -->
<!-- // //重置 -->
<!-- // function goBack(flag) { -->
<!-- // 	$("#means_email").val(""); -->
<!-- // 	$("#means_bak").val(""); -->
<!-- // } -->
<!-- // //保存 -->
<!-- // function saveM(){ -->
<!-- // 	 //获取索取资料 -->
<!-- // 	    var nameCode=jQuery("#options option:selected").val(); -->
<!-- // 		var means_name=jQuery("#options option:selected").text(); -->
	
<!-- // 	//索取方式 -->
<!-- // 	    var methodCodes=jQuery("#dianzika option:selected").val(); -->
<!-- // 		var means_method=jQuery("#dianzika option:selected").text(); -->
<!-- // 	var means_email = $("#means_name").val(); -->
<!-- // 	var means_bak = $("#means_bak").val(); -->
<!-- // $.post("${rootPath}/askforClaim/save",{"means_name":nameCode,"means_method":methodCodes,"means_email":means_email,"means_bak":means_bak}, -->
<!-- // 			function(data) -->
<!-- // 			{	 -->
<!-- // 	$(".white_content_sqzl").css("display","none"); -->
<!-- // 	$("#windownbg").css("display","none"); -->
<!-- // 			}); -->
 
 	
<!-- // } -->

<!-- </script> -->
<!-- 	<ul> -->
<%--     	<li><img src="<%=basePath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="sqzl_gb_id" ></li>  --%>
<!--         <div style="clear:both;"></div> -->
<!--         <li><span class="font30" style="width:100%;text-align:center;">索取资料</span></li> -->
<!--         <li><span>索取资料</span> -->
<!--         	<select class="inp7" id="options">	 -->
<!-- <!--        	 		<option value="北京燕园社区相关资料">北京燕园社区相关资料 </option> --> -->
<!-- <!--                 <option value="上海申园社区相关资料">上海申园社区相关资料 </option> --> -->
<!-- <!--                 <option value="广州粤园社区相关资料">广州粤园社区相关资料 </option> --> -->
<!--             </select> -->
<!--         </li> -->
<!--         <li><span>索取方式</span> -->
<!--         	<select class="inp7" id="dianzika"> -->
<!-- <!--        	 		<option value="电子版">电子版 </option> --> -->
<!--             </select> -->
<!--         </li> -->
<!--         <li><span>邮箱</span><input type="text"  id = "means_email" class="inp5" /></li> -->
<!--         <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea id = "means_bak" class="inp9"></textarea></li> -->
<%--         <li style="width:100%;text-align:center;padding-left:34px;"><input type="button" id="anniu" onclick= "saveM()" style="background:url(<%=basePath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px"> --%>
<%--         	<input type="reset"  onclick="goBack(1)" value="" style="background:url(<%=basePath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px"> --%>
<!--         </li> -->
        
<!--     </ul> -->
</div>
<!--预约参观-->
<!-- <div class="white_content_yycg"> -->

<!-- <SCRIPT language=javascript > -->

<!-- // function yuyueK(){ -->
<!-- // 	$("#tiyan").empty(); -->
<!-- // 	$("#nianl").empty(); -->
<!-- // 	$("#service").empty(); -->
<!-- // 	$("#lianxr").val(""); -->
<!-- // 	 $("#cgrs").val(""); -->
<!-- // 	$("#lianxTel").val(""); -->
<!-- // 	$("#means_bakT").val(""); -->
<!-- // 	$("#popupDatepicker").val(""); -->
	
<!-- // 	var dictList = getDictList('tiyan,nianl,service'); -->
<!-- // 	var jsonData=dictList.list; -->
<!-- // 	var jsonDatas=JSON.parse(JSON.stringify(jsonData)); -->
<!-- // 	for(var i=0;i<jsonData.length;i++){ -->
<!-- // 	  if(jsonData[i].dictTypeId=="tiyan") -->
<!-- // 		  { -->
<!-- // 	 			 $("#tiyan").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>') -->
<!-- // 		  } -->
<!-- // 	  else if(jsonData[i].dictTypeId=="nianl") -->
<!-- // 		  { -->
<!-- // 		  		$("#nianl").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>') -->
<!-- // 		  } -->
<!-- // 	  else if(jsonData[i].dictTypeId=="service") -->
<!-- // 	 	{ -->
<!-- // 	  		$("#service").append('<option value='+jsonData[i].dictId+'>'+jsonData[i].dictName+'</option>') -->
<!-- // 	 	 } -->
<!-- //  } -->
<!-- // } -->
<!-- // //重置 -->
<!-- // function goBackT() { -->
<!-- // 	$("#lianxr").val(""); -->
<!-- // 	 $("#cgrs").val(""); -->
<!-- // 	$("#lianxTel").val(""); -->
<!-- // 	$("#means_bakT").val(""); -->
<!-- // 	$("#popupDatepicker").val(""); -->
<!-- // } -->
<!-- // //保存 -->
<!-- // function saveMT(){ -->
<!-- // 	var lianxr = $("#lianxr").val(); -->
<!-- // 	var lianxTel = $("#lianxTel").val(); -->
<!-- // 	var cgrs = $("#cgrs").val(); -->

<!-- // 	var tiyanCode=jQuery("#tiyan option:selected").val(); -->
<!-- //     var nianlCode=jQuery("#nianl option:selected").val(); -->
<!-- //     var serviceCode=jQuery("#service option:selected").val(); -->
<!-- // 	var sexCode=$("input[name='sex']:checked").val(); -->
<!-- // 	var means_bakT = $("#means_bakT").val(); -->
    
<!-- // 	var shiTime= $("#shiTime").val(); -->
<!-- // 	var yuyueTimC=jQuery("#yuyueTim option:selected").val(); -->
<!-- // 	var timeT = shiTime+yuyueTimC; -->
<!-- // // 	    var nameCode=jQuery("#options option:selected").val(); -->
<!-- // // 		var means_name=jQuery("#options option:selected").text(); -->
<!-- // // 	    var methodCodes=jQuery("#dianzika option:selected").val(); -->
<!-- // // 		var means_method=jQuery("#dianzika option:selected").text(); -->
<!-- // $.post("${rootPath}/orderVisit/save", -->
<!-- // 		{"visitName":lianxr,"visitTel":lianxTel,"visitCount":cgrs,"visitTime":timeT, "visitSite":tiyanCode,"visitAge":nianlCode,"visitSex":sexCode, "visitService":serviceCode,"visitBak":means_bakT}, -->
<!-- // 			function(data) -->
<!-- // 			{	 -->
<!-- // 			$(".white_content_yycg").css("display","none"); -->
<!-- // 			$("#windownbg").css("display","none"); -->
<!-- // 			}); -->
 
 	
<!-- // } -->

<!-- </script> -->

<!-- 	<ul> -->
<%--     	<li><img src="<%=basePath%>/static/tkcow/img/gb.jpg" style="float:right;margin-top:3px;" id="yycg_gb_id"></li> --%>
<!--         <div style="clear:both;"></div> -->
<!--         <li><span class="font30" style="width:100%;text-align:center;">预约参观</span></li> -->
<!--         <li><span>联系人</span><input type="text" id = "lianxr" class="inp5" /></li> -->
<!--         <li><span>联系人电话</span><input type="text" id="lianxTel" class="inp5" /></li> -->
<!--         <li><span>参观人数</span><input type="text" id = "cgrs" class="inp5" /></li> -->
<!--         <li><span>预约时间（提前三天预约）</span> -->
<!-- <!--         	<input type="text" class="inp6 hasDatepicker" id = "shiTime"/> --> -->
<!-- 			<input type="text" id="popupDatepicker" readonly  class="inp6"> -->
<!--         	<select class="inp8" id = "yuyueTim"> -->
<!--        	 		<option value="09:00">09:00 </option> -->
<!--                 <option value="10:00">10:00 </option> -->
<!--                 <option value="11:00">11:00 </option> -->
<!--                 <option value="12:00">12:00 </option> -->
<!--                 <option value="13:00">13:00 </option> -->
<!--                 <option value="14:00">14:00 </option> -->
<!--                 <option value="15:00">15:00 </option> -->
<!--                 <option value="16:00">16:00 </option> -->
<!--                 <option value="17:00">17:00 </option> -->
<!--             </select> -->
<!--         </li> -->
<!--         <li><span>体验馆</span> -->
<!--         	<select class="inp7" id="tiyan"> -->
<!-- <!--        	 		<option value="泰康之家·燕园">泰康之家·燕园 </option> --> -->
<!-- <!--                 <option value="泰康之家·申园">泰康之家·申园 </option> --> -->
<!-- <!--                 <option value="泰康之家·粤园">泰康之家·粤园 </option> --> -->
<!-- <!--                 <option value="泰康之家·吴园">泰康之家·吴园 </option> --> -->
<!--             </select> -->
<!--         </li> -->
<!--         <li><span>年龄</span> -->
<!--         	<select class="inp7" id = "nianl"> -->
<!-- <!--        	 		<option value="60岁以上">60岁以上 </option> --> -->
<!-- <!--                 <option value="60岁以下">60岁以下 </option> --> -->
<!--             </select> -->
<!--         </li> -->
<!--         <li><span>性别</span> -->
<!--         	<input type="radio" value="男 " name="sex" checked/>男 -->
<!--             <input type="radio" value="女" name="sex"/>女 -->
<!--         </li> -->
<!--         <li><span>需要什么样的养老服务</span> -->
<!--         	<select class="inp7" id="service"> -->
<!-- <!--        	 		<option value="独立生活">独立生活 </option> --> -->
<!-- <!--                 <option value="协助生活">协助生活 </option> --> -->
<!-- <!--                 <option value="专业护理">专业护理 </option> --> -->
<!-- <!--                 <option value="康复治疗">康复治疗 </option> --> -->
<!-- <!--                 <option value="其他">其他 </option> --> -->
<!--             </select> -->
<!--         </li> -->
        
<!--         <li style="height:125px;line-height:125px;margin-top: 12px; margin-bottom: 24px;"><span>备注</span><textarea class="inp9" id="means_bakT"></textarea></li> -->
<!--         <li style="width:100%;text-align:center;padding-left:34px;"> -->
<%--         <input type="button" id="anniuT" onclick="saveMT();" style="background:url(<%=basePath%>/static/tkcow/img/tj1.jpg); border:0px; width:124px; height:41px"> --%>
<%--         	<input type="reset"  value="" style="background:url(<%=basePath%>/static/tkcow/img/qx.jpg); border:0px; width:124px; height:41px" onclick="goBackT();"> --%>
<!--         </li> -->
        
<!--     </ul> -->
</div>




       <div id="floatLayer"> 

            	<%@ include file="/rightLogin.jsp"%>
<!--             <div style="cursor:pointer; float:right; height:256px; width:62px; overflow:hidden"> -->
<%--              <img src="<%=basePath%>/static/tkcow/img/a0.jpg" width="62" border="0" onclick="javascript:window.open('http://chat.taikangzhijia.com/');"> --%>
<%--             <img src="<%=basePath%>/static/tkcow/img/a1.jpg" width="62" border="0" id="sqzl_id" onclick="huoquzl();"> --%>
            
<%--             <img src="<%=basePath%>/static/tkcow/img/a2.jpg" width="62" border="0" id="yycg_id"  onclick="yuyueK();"> --%>
            
<%--             <img src="<%=basePath%>/static/tkcow/img/a3.jpg" width="62" border="0" onclick1="javascript:showbox('menzhen');"> --%>
          </div>
   		</div>

	</body>
</html>

 