function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
/**
 * 初始化页面信息
 */
var path = getContextPath();
$.ajax({
	   type: "POST",
	   datatype : "json",
	   contentType : "application/json; charset=utf-8",
	   url: path + "/homepage/BottomMenu",
	   data: "",
	   success: function(data){
		var BottomMenuData=JSON.parse(JSON.stringify(data)).BottomMenu;
		var dataLength=BottomMenuData.length;
		loadSelect();
		for(var i=0;i<dataLength;i++){
			if(i==dataLength-1)
				{
					$(".foot_menu").append('<a href="' + path + '/'+BottomMenuData[i].MOD_URL+'">'+BottomMenuData[i].MOD_NAME+'</a>')
				}
			else{
				$(".foot_menu").append('<a href="' + path + '/'+BottomMenuData[i].MOD_URL+'">'+BottomMenuData[i].MOD_NAME+'</a>|')
			}
		}
	   }
	});
	
	function loadSelect(){
		var dictList = getDictList('weblink');
		var jsonData=dictList.list;
		var jsonDatas=JSON.parse(JSON.stringify(jsonData));
		 for(var i=0;i<jsonData.length;i++){
			  if(jsonData[i].dictTypeId=="weblink")
				  {                  
				  $("#searchUrl").append('<option value="'+jsonData[i].data.seq_no+'">'+jsonData[i].dictName+'</option>')
				  }
		 }
	}			 