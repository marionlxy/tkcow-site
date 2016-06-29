function getContextPath() {
	var contextPath=document.location.href;
	contextPath=contextPath.split("site")[0];
	return contextPath+"site";
}
var path=getContextPath();
$(function(){
	var data = document.getElementById("params").value;
	data = JSON.parse(data);
	var json = data.params;
	var textStr="";
	for(var i=0;i<json.length;i++){
		textStr+='<li><a href="' + path +'/'+json[i].url+'">'+json[i].title+'</a><span>'+json[i].create_time+'</span></li>';
	}
	document.getElementById('news_ul').innerHTML=textStr;
	});