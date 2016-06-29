<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/pagess" prefix="page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meat http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<title>泰康之家官方网站</title>
<meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords"/>
<meta content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"  name="description"  />

<meta itemprop="operatingSystems" content="Windows,Mac,linux"/> 
<%@ include file="/include.jsp" %>
<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
<link href="<%=basePath%>/static/tkcow/css/banner.css" rel="stylesheet">
<link href="<%=basePath%>/static/tkcow/css/banner1.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/banner.css">
<link href="<%=basePath%>/static/tkcow/css/page.css" rel="stylesheet">
<script src="<%=basePath%>/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="<%=basePath%>/static/tkcow/js/tkcontent.js"></script>
<script src="<%=basePath%>/static/tkcow/js/tkcontent/yzhhzhb.js"></script>
</head>
<body>
<input type="hidden" id="id"  value="${id}">
<input type="hidden" id="banUrl"  value="${banUrl}">
<input type="hidden" id="modName"  value="${modName}">
<input type="hidden" id="menuList"  value='${menuList }'>
     <div class="allContent">
        <%@ include file="/WEB-INF/view/tkcow/titile.jsp"%>
    <div class="banner2" style="background-repeat: no-repeat;background-position: center top;height: 365px;">
       <!--  <img src="" > -->
    	<div class="bai"></div>
    </div>
     <div class="synr1">
        <div class="main">
        <div class="left">
       <%@ include file="/WEB-INF/view/leftmenu/leftmenuIndex.jsp"%>
          </div>
             <div class="right"></div>
            <div style="width: 638px;float: right;">
           <form action="" id="form5">
	     		<input id="pageNo" type="hidden" value="${pageBean.pageNo}" name="pageNo">
	     		<div class="quotes">
	     			 <page:page pageBean="${pageBean}" targetPage="" formId="form5"></page:page>
				</div>	
		   </form>
          </div>
        </div>
     <div class="synrbottom"></div>
  </div>
  <%@ include file="/WEB-INF/view/tkcow/foot.jsp"%>
       <!-- <div id="floatLayer"> 
          </div> -->
<%@ include file="/rightLogin.jsp"%>
</div>
</body>
</html>