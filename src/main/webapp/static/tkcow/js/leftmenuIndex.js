/**
 * 初始化页面信息
 */
var path = getContextPath();
$(function(){
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	var id = document.getElementById("id").value;
	if (id != null && id != "" && id!=0){
		var MenuUrl= path +'/leftMenu/menuList'; 
		$.ajax({
			   type: "POST",
			   datatype : "json",
		  	   contentType : "application/json; charset=utf-8",
			   url: MenuUrl,
			   data:"id:"+id,
			   success: function(data){
				var jsonData=JSON.parse(JSON.stringify(data)).resultList;
				var oneJson = JSON.parse(JSON.stringify(data)).OneChildList;
				var menuName = JSON.parse(JSON.stringify(data)).menuName;
				var childId = JSON.parse(JSON.stringify(data)).childId;
				var twochildId = JSON.parse(JSON.stringify(data)).twoLevelId;
				var thirdchildId = JSON.parse(JSON.stringify(data)).thirdLevelId;
				var childLevel = JSON.parse(JSON.stringify(data)).childLevel;
				var savaData=JSON.stringify(jsonData);
				var oneCData=JSON.stringify(oneJson);
				sessionStorage.setItem("hlylChild",oneCData);
				var twoChildData = JSON.parse(JSON.stringify(data)).twoChildList;
				//console.log(twoChildData);
				if(twoChildData != "undefined" && twoChildData != undefined){
					var twoCData=JSON.stringify(twoChildData);
					sessionStorage.setItem("hlylTwoChild",twoCData);
				}
				$(".ltitle").append('| <a href="#" style="text-decoration:none;color:#f07905" value='+menuName+'>'+menuName+'</a>');
				$(".leftdh").find("ul").empty().append('<li class="no"></li>');
				var oneJsons = sessionStorage.getItem("hlylChild");
				 var oneJson;
				 if (oneJson != "undefined" && oneJson != undefined) {
					 oneJson=JSON.parse(oneJsons)
				 }
				 var appendHTML="";
				for(var i=0;i<jsonData.length;i++){
			    	appendHTML = '<li onclick="leftLiClick(this)" style="text-overflow:ellipsis;word-break:keep-all;white-space:nowrap;overflow:hidden;"><input type="hidden" class="oneLeve" style="padding-left:25px; font-size:14px;" value='+jsonData[i].modId+'><a href="'+ path +'/'+jsonData[i].modUrl+'"   title='+jsonData[i].modName+'  style="text-decoration:none;" >'+jsonData[i].modName+'</a></li><div style="display:none;" class="twoDIV"></div>';
    				$(".leftdh").children("ul").append(appendHTML);
    					var appendSTR="";
    					if (oneJson != "undefined" && oneJson != undefined) {
    						for(var j=0;j<oneJson.length;j++){
	    						if(jsonData[i].modId == oneJson[j].modParentId){
	    							appendSTR='<li onclick="left_change(this)" style="padding-left:25px; font-size:14px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;word-break:keep-all;" id='+oneJson[j].modId+'><input type="hidden" class="twoLeve" value='+oneJson[j].modId+'>-<a href="'+ path +'/'+oneJson[j].modUrl+'" style="text-decoration:none;" title='+oneJson[j].modName+'>'+oneJson[j].modName+'</a></li><div style="display:none;" class="thirDIV"></div>';
	    							$(".twoDIV").eq(i).append(appendSTR);
	    							
	    							if(twoChildData != "undefined" && twoChildData != undefined){
	    								var appendTEXT="";
	    								for(var a=0;a<twoChildData.length;a++){
	    									if(oneJson[j].modId == twoChildData[a].modParentId){
	    										appendTEXT+='<li onclick="chil_change(this)"  style="padding-left:50px; font-size:14px;"text-overflow:ellipsis;word-break:keep-all;white-space:nowrap;overflow:hidden;"><input type="hidden" value='+twoChildData[a].modId+' class="thirLeve">-<a href="'+ path +'/'+twoChildData[a].modUrl+'" style="text-decoration:none;" title='+twoChildData[a].modName+'>'+twoChildData[a].modName+'</a></li>';
	    									}
		    							}
	    								$(".thirDIV").eq(j).html(appendTEXT);
	    		    				}
	    							
	    						}
	    					}
    					}
				}
					$(".leftdh").find(".oneLeve").each(function(){
    					if($(this).val()==twochildId){
    						$(this).parent("li").css("color","#f07905");
    						$(this).next("a").css("color","#f07905").parent("li").siblings("li").find("a").css("color","#333");
    						$(this).parents("li").next("div").css("display","block").siblings("div").css("display","none");
    					}
    				})
    				
				$(".leftdh").find(".twoLeve").each(function(){
					if($(this).val()==thirdchildId){
						$(this).parent("li").css("color","#f07905");
						$(this).next("a").css("color","#f07905").parent("li").siblings("li").find("a").css("color","#333");
						$(this).parent("li").next("div").css("display","block").siblings("div").css("display","none");
					}
				});
					
				$(".leftdh").find(".thirLeve").each(function(){
					if($(this).val()==childId){
						$(this).parent("li").css("color","#f07905");
						$(this).next("a").css("color","#f07905").parent("li").siblings("li").find("a").css("color","#333");
					}
				});
				}
			});
	}
	
})
//左侧树形菜单选中状态
function leftLiClick(obj){
$(obj).css("color","#f07905");
$(obj).siblings("li").css("color","#333");
var oneJson = sessionStorage.getItem("hlylChild");
var oneJson=JSON.parse(oneJson);
$(obj).children("a").css("color","#f07905");
$(obj).siblings("li").children("a").css("color","#333");
$(obj).next("div").css("display","block");
$(obj).siblings("li").next("div").css("display","none");
var parentId=$(obj).find("input").val();
$(obj).next("div").empty();
for(var j=0;j<oneJson.length;j++){
		if(parentId == oneJson[j].modParentId){
			$(obj).next("div").append('<li onclick="left_change(this)" style="padding-left:25px; font-size:14px;" id='+oneJson[j].modId+'><input type="hidden" value='+oneJson[j].modId+'>-<a href='+oneJson[j].modUrl+' style="text-decoration:none;" title='+oneJson[j].modName+'>'+oneJson[j].modName+'</a></li><div style="display:none;"></div>');
			if(j==0){
			var twoChildData = sessionStorage.getItem("hlylTwoChild");
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
function left_change(obj){
	$(obj).css("color","#f07905").siblings("li").css("color","#333");
	$(obj).children("a").css("color","#f07905");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
	var twoChildData = sessionStorage.getItem("hlylTwoChild");
	var twoJson=JSON.parse(twoChildData);
	var parentId=$(obj).find("input").val();
	$(obj).next("div").empty();
		for(var k=0;k<twoJson.length;k++){
			if(parentId == twoJson[k].modParentId){
				$(obj).next("div").append('<li onclick="chil_change(this)"  style="padding-left:50px; font-size:14px;"><input type="hidden" value='+twoJson[k].modId+'>-<a href='+twoJson[k].modUrl+' style="text-decoration:none;" title='+twoJson[k].modName+'>'+twoJson[k].modName+'</a></li>');
		}
			var liObj = $(obj).next("div").children().eq(0);
    		liObj.css("color","#f07905");
    		liObj.find("a").css("color","#f07905");
	}
}

function left_chang(obj){
	$(obj).css("color","#f07905").siblings("li").css("color","#333");
	$("#"+obj).children("a").css("color","#f07905");
	$("#"+obj).siblings("li").children("a").css("color","#333");
	$("#"+obj).next("div").css("display","block");
	$("#"+obj).siblings("li").next("div").css("display","none");

	var twoChildData = sessionStorage.getItem("hlylTwoChild");
	var twoJson=JSON.parse(twoChildData);
	var parentId=obj;
	$("#"+obj).next("div").empty();
		for(var k=0;k<twoJson.length;k++){
			if(parentId == twoJson[k].modParentId){
				$("#"+obj).next("div").append('<li onclick="chil_change(this)"  style="padding-left:50px; font-size:14px;"><input type="hidden" value='+twoJson[k].modId+'>-<a href='+twoJson[k].modUrl+' style="text-decoration:none;" title='+twoJson[k].modName+'>'+twoJson[k].modName+'</a></li>');
			}
			var liObj = $("#"+obj).next("div").children().eq(0);
    		liObj.css("color","#f07905");
    		liObj.find("a").css("color","#f07905");
		}
	}
function chil_change(obj){
	$(obj).children("a").css("color","#f07905");
	$(obj).siblings("li").children("a").css("color","#333");
	$(obj).next("div").css("display","block");
	$(obj).siblings("li").next("div").css("display","none");
}