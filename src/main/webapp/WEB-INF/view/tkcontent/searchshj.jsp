<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/pagess" prefix="page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>泰康之家官方网站</title>
<meta content="泰康之家,高端养老社区,养老服务,养老医疗" name="keywords"/>
<meta content="泰康之家官方网站，中国高端养老社区，详细介绍泰康之家养老社区的养老服务、养老医疗。泰康之家致力于打造大规模、全功能、高品质的国际标准医养社区，以医养结合、活力养老、舒适居住为核心，为老人提供全方位的养老生活解决方案。"  name="description"  />

<meta itemprop="operatingSystems" content="Windows,Mac,linux"/> 
<%@ include file="/include.jsp" %>
<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
<link href="<%=basePath%>/static/tkcow/css/banner.css" rel="stylesheet">
<link href="<%=basePath%>/static/tkcow/css/page.css" rel="stylesheet">

<script src="<%=basePath%>/static/tkcow/js/jquery-1.10.1.min.js"></script>
<script src="<%=basePath%>/static/tkcow/js/tkcontent.js"></script>
 <script src="<%=basePath%>/static/tkcow/js/tkcontent/searchshj.js"></script> 
</head>
<body>
<input type="hidden" id="params"  value='${params}'>
     <div class="allContent">
     <%@ include file="/WEB-INF/view/tkcow/titile.jsp"%>
    <div class="banner2" style="background:url();background-repeat: no-repeat;background-position: center top;height:365px;" >
    	<div class="bai"></div>
    </div>
     <div class="synr1">
        <div class="main">
        <div class="left">
		 <div class="ltitle"  style=' color:#21acd8 ' >| <a href="#" style=' color:#21acd8 '>搜索结果</a></div>
		 <div class="leftdh"> 
		           <ul>
		              <li class="no"></li>  
		  		<li>搜索结果</li>        
		            </ul>
		       </div>
          </div>
          <div class="right">
          <div class="righttitle">搜索结果</div>
          <div class="rightnr">
            <div class="news">
            <ul id="news_ul">
              </ul>
            </div>
               </div>
        </div>
          
        
  </div> 
  <div style="clear:both;"></div>
          <form action="" id="form2">
     		<input id="pageNo" type="hidden" value="${pageBean.pageNo}" name="pageNo">
     		<input name="skey" id="skey" type="hidden" id="skey">
     		<div class="quotes">
     			 <page:page pageBean="${pageBean}" targetPage="" formId="form2"></page:page>
			</div>	
	   </form>          
        
        </div>
       
 		
     <div class="synrbottom"></div>
  </div>
  
  	
 <%@ include file="/WEB-INF/view/tkcow/foot.jsp"%>
 
       <!-- <div id="floatLayer"> 
   		</div> -->
		<%@ include file="/rightLogin.jsp"%>
</body>
</html>