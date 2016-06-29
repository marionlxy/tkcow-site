<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meat http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>泰康之家官方网站</title>
<meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords" />
<meta
	content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"
	name="description" />

<meta itemprop="operatingSystems" content="Windows,Mac,linux" />
<%@ include file="/include.jsp"%>
<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/banner.css">
<script src="<%=basePath%>/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="<%=basePath%>/static/json.min.js"></script>
<body>
 <div class="allContent">
         <%@ include file="/WEB-INF/view/tkcow/titile.jsp"%>
    <div class="banner">
        <div class="container">
            <div id="slides">
            </div>
       </div>
       
     </div>
     
	<div class="synr1" style="margin-top: -55px;">
		<div class="main">
			<div class="left">
				<div class="ltitle" style="color: #21acd8">
					| <a href="/" style="color: #21acd8">网站地图</a>
				</div>
				<div class="leftdh">
					<ul>
						<li class="no"></li>
						<c:if test="${!empty rList}">
							<c:forEach items="${rList}" var="item"  varStatus="status">
								<li>
									<a href="${item.MOD_URL}" title="${item.MOD_NAME}" style="">${item.MOD_NAME}</a>
								</li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="right">
			<div class="righttitle">网站地图</div>
			<div class="rightnr">
					<c:if test="${!empty cList}">
							<c:forEach items="${cList}" var="item2"  varStatus="status">
								<div class="map">
								<div class="lmbt">
									<a href="${item2.url}">${item2.name}</a>&gt;&gt;
								</div>
								<ul>
									<c:set var="child" value="${item2.child}"/>
									<c:if test="${!empty child}">
										<c:forEach items="${child}" var="item3"  varStatus="status">
											<li><a href="${item3.MOD_URL}">${item3.MOD_NAME}</a></li>
										</c:forEach>
									</c:if>
								</ul>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</c:if>
				</div>
				</div>
			</div>
		</div>
				<div class="synrbottom"></div>
	</div>
	<script src="<%=basePath%>/static/tkcow/js/tkcow/sitemap.js"></script> 
	  <%@ include file="/WEB-INF/view/tkcow/foot.jsp"%>
	<script src="<%=basePath%>/static/tkcow/js/jquery.slides.min.js"></script>
</body>
</html>