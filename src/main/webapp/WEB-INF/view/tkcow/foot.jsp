<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meat http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<script src="${rootPath}/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="${rootPath}/static/tkcow/js/common_iu.js"></script>
<script src="${rootPath}/static/tkcow/js/tkcow/foot.js"></script>
</head>
<body>
<div class="foot">
	<div style="float:left;width:50%;">
		<p>泰康人寿 版权所有  京ICP备15000213号<br>
		Copyright Taikanglife.&nbsp;All Rights Reserved </p>
	</div>
	
	<div style="float:right;width:50%;">
		<div class="foot_menu">
		</div>
	</div>
	<div style="float:left;width:65%;">
		<p>本网站所有资讯与说明文字仅供参考，如有与本公司相关公告及产品法律文件不符，以相关公告及产品法律文件为准。 </p>
	</div>
	<div style="float:right;width:35%;margin-top:-6px;" class="foot_img">
		<span style="margin-left:66px;"><a href="http://weibo.com/p/1006063379672002/home?from=page_100606&amp;mod=TAB#place"><img src="${rootPath}/static/tkcow/img/s1.jpg"></a></span>
        <span><a href="#"><img src="${rootPath}/static/tkcow/img/s2.jpg"></a></span>
        <span><a href="#"><img src="${rootPath}/static/tkcow/img/s3.jpg"></a></span>
        <span><a href="#"><img src="${rootPath}/static/tkcow/img/s4.jpg"></a></span> 
		 <div class="search" style="float:right;">
            <select name="" id="searchUrl" style="margin-top:0px;" class="inp" onchange="if(this.options[selectedIndex].value!=='-1')window.open(this.options[selectedIndex].value)">
              <option value="-1">访问泰康其他网站</option>
            </select>
         </div>
	</div>
</div>
</body>
</html>