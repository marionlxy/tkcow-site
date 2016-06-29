<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String url = request.getContextPath();
String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+url;
%>

<c:set var="url" value="<%=url%>"></c:set>
<c:set var="path" value="<%=path%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meat http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
   <script src="<%=path%>/static/tkcow/js/tkcow/title.js"></script> 
</head>
<body>
         <div class="content_top">
            <div class="content_logo">
                <a href="index.htm">
                <img src="${rootPath}/static/tkcow/img/logo015.jpg" width="488" height="61" title="泰康之家官方网站" original="${rootPath}/index.htm">
                </a>
            </div>
            <div class="headright">
               <div class="content_Topimg"> 
                    <ul>
                       <li class="t1"><a href="index.html">泰康之家</a></li> 
                       <li class="t2"><a href="#" id="quanguobuju">全国布局</a></li> 
                       <li class="t3"><a href="#">微信帐号</a><span></span></li> 
<%--                        <li class="t4"><a href="${rootPath}/user/login"> 会员登录</a></li>  --%>
                    </ul>
                </div>
              <div class="content_tel">40060-95522</div>
            </div>
        </div>
        
                <div class="content_main">
            <div class="content_main983">
                <ul id="oneMenu">                   
                                                                                                    
           <li class="searchbg">
                <form id="form1" name="form1" method="post" action="${rootPath}/homepage/toPage">
                    <input name="skey" id="skey" type="text" class="search_text" style="height:18px; margin-top:13px; margin-left:10px; border:0px; line-height:20px" id="skey">
                    <input type="submit" value="" class="search_submit">
                </form>
            </li>
           </ul>
        </div>
   </div>
</body>
</html>