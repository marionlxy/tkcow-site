<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>泰康之家官方网站</title>
<meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords"/>
<meta content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"  name="description"  />
<meat http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<meta itemprop="operatingSystems" content="Windows,Mac,linux"/> 
<%@ include file="/include.jsp" %>
<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/banner.css">
<script src="<%=basePath%>/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="<%=basePath%>/static/js/json.min.js"></script>
</head>
<body>
     <div class="allContent" style="position:relative;">
         <%@ include file="/WEB-INF/view/tkcow/titile.jsp"%>
    <div class="banner">
        <div class="container">
            <div id="slides">
            </div>
       </div>
     </div>
     <div class="syhy">欢迎来到泰康之家！</div>
     <div class="synrtop"></div>
     <div class="synr">
          <div class="synrnei" id="homeModel">
          </div>
        </div>
     <div class="synrbottom"></div>
  </div>
  <%@ include file="/WEB-INF/view/tkcow/foot.jsp"%>
	<%@ include file="/rightLogin.jsp"%> 
    
<script src="<%=basePath%>/static/tkcow/js/jquery.slides.min.js"></script>
<script src="<%=basePath%>/static/tkcow/js/tkcow/index.js"></script>


</body>
</html>