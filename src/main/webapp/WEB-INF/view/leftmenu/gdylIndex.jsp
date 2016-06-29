<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
	<link href="<%=basePath%>/static/tkcow/css/main.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>/static/tkcow/css/banner1.css">
    <title></title>
    <script type="text/javascript">
    $(function(){
//     	// 注意：不要读取缓存
    	jQuery.ajaxSetup({
    		cache : false
    	});
    	
    	id ='${id}';
    	if (id != null && id != "" && id!=0){
    		var MenuUrl='${rootPath}/leftMenu/menuList';
    		$.ajax({
    			   type: "POST",
    			   datatype : "json",
    		  	   contentType : "application/json; charset=utf-8",
    			   url: MenuUrl,
    			   data:"id:"+id,
    			   success: function(data){
       				var jsonData=JSON.parse(JSON.stringify(data)).resultList;
       				var oneChildData = JSON.parse(JSON.stringify(data)).OneChildList;
       				var savaData=JSON.stringify(jsonData);
       				var oneCData=JSON.stringify(oneChildData);
       				var twoChildData = JSON.parse(JSON.stringify(data)).twoChildList;
       				if(twoChildData != "undefined"){
       					var twoCData=JSON.stringify(twoChildData);
       					sessionStorage.setItem("gdylTwoChild",twoCData);
       				}
       				sessionStorage.setItem("gdylOneChild",oneCData);
       				$(".leftdh").find("ul").empty();
       				for(var i=0;i<jsonData.length;i++){
       			    	$(".leftdh").find("ul").append('<li onclick="leftLiClick(this)"><input type="hidden" value='+jsonData[i].modId+'><a href="#"   title='+jsonData[i].modName+'  style="text-decoration:none;" ></a>'+jsonData[i].modName+'</li><div style="display:none;"></div>')
       				}
       			   }
       			});
       	}
       	
       })
       //左侧树形菜单选中状态
   function leftLiClick(obj){
    	$(obj).css("color","#60b24b");
        $(obj).siblings("li").css("color","#333");
       	var oneChildData = sessionStorage.getItem("gdylOneChild");
   		var oneJson=JSON.parse(oneChildData);
   		//console.log(oneJson);
   	$(obj).children("a").css("color","#60b24b");
   	$(obj).siblings("li").children("a").css("color","#333");
   	$(obj).next("div").css("display","block");
   	$(obj).siblings("li").next("div").css("display","none");
   	var parentId=$(obj).find("input").val();
   	$(obj).next("div").empty();
   		for(var j=0;j<oneJson.length;j++){
   			if(parentId == oneJson[j].modParentId){
   				$(obj).next("div").append('<li onclick="left_change(this)" style="padding-left:25px; font-size:14px;  color:#60b24b " id='+oneJson[j].modId+'><input type="hidden" value='+oneJson[j].modId+'>-<a href="#" style="text-decoration:none;" title='+oneJson[j].modName+'>'+oneJson[j].modName+'</a></li><div style="display:none;"></div>');
   				if(j==0){
					var twoChildData = sessionStorage.getItem("gdylTwoChild");
					if(twoChildData != undefined && twoChildData != "undefined"){
						var twoJson=JSON.parse(twoChildData);
						left_chang(oneJson[0].modId);
    				}else{
    					chil_change("#"+oneJson[j].modId);
    				}
				}
   			}
   		}
   		
   }
    
    function left_chang(obj){
       	$("#"+obj).children("a").css("color","#60b24b");
       	$("#"+obj).siblings("li").children("a").css("color","#333");
       	$("#"+obj).next("div").css("display","block");
       	$("#"+obj).siblings("li").next("div").css("display","none");

       	var twoChildData = sessionStorage.getItem("gdylTwoChild");
   		var twoJson=JSON.parse(twoChildData);
       	var parentId=obj;
       	$("#"+obj).next("div").empty();
       		for(var k=0;k<twoJson.length;k++){
       			if(parentId == twoJson[k].modParentId){
       				$("#"+obj).next("div").append('<li onclick="chil_change(this)"  style="padding-left:50px; font-size:14px;"><input type="hidden" value='+twoJson[k].modId+'>-<a href="#" style="text-decoration:none;" title='+twoJson[k].modName+'>'+twoJson[k].modName+'</a></li>');
       			}
       			var liObj = $("#"+obj).next("div").children().eq(0);
        		liObj.css("color","#21acd8");
        		liObj.find("a").css("color","#21acd8");
       		}
       	}
    
       function left_change(obj){
       	$(obj).children("a").css("color","#60b24b");
       	$(obj).siblings("li").children("a").css("color","#333");
       	$(obj).next("div").css("display","block");
       	$(obj).siblings("li").next("div").css("display","none");
       	var twoChildData = sessionStorage.getItem("gdylTwoChild");
   		var twoJson=JSON.parse(twoChildData);
   		//console.log(twoJson);
       	var parentId=$(obj).find("input").val();
       	$(obj).next("div").empty();
       		for(var k=0;k<twoJson.length;k++){
       			if(parentId == twoJson[k].modParentId){
       				$(obj).next("div").append('<li onclick="chil_change(this)"  style="padding-left:50px; font-size:14px;"><input type="hidden" value='+twoJson[k].modId+'>-<a href="#" style="text-decoration:none;" title='+twoJson[k].modName+'>'+twoJson[k].modName+'</a></li>');
       			}
       			var liObj = $(obj).next("div").children().eq(0);
        		liObj.css("color","#21acd8");
        		liObj.find("a").css("color","#21acd8");
       		}
       	}
       function chil_change(obj){
       	$(obj).children("a").css("color","#60b24b");
       	$(obj).siblings("li").children("a").css("color","#333");
       	$(obj).next("div").css("display","block");
    	$(obj).siblings("li").next("div").css("display","none");
       	}
    </script>
</head>
<body>

     <div class="synr1">
        <div class="main">
        <div class="left">
        <div class="ltitle"  style=' color:#60b24b ' >| <a href="#" style=' color:#60b24b '>高端医疗</a></div>
        <div class="leftdh"> 
                   <ul>
                    </ul>
               </div>
          </div>
</body>
</html>