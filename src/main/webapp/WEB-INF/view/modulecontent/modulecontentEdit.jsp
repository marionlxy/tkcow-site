<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
    <title></title>
</head>
<body>
<div class="easyui-panel" title="XX详细信息编辑" style="width:600px">
	<form id="dataForm">
			<div class="fitem">
		    	<label>contentId:</label>
		        <input name="contentId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modId:</label>
		        <input name="modId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modNumber:</label>
		        <input name="modNumber" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>contentImg:</label>
		        <input name="contentImg" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>contentImgBig:</label>
		        <input name="contentImgBig" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>hasBanner:</label>
		        <input name="hasBanner" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>bannerId:</label>
		        <input name="bannerId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>content:</label>
		        <input name="content" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>isDisplay:</label>
		        <input name="isDisplay" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>weight:</label>
		        <input name="weight" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createdTime:</label>
		        <input name="createdTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createdBy:</label>
		        <input name="createdBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modifiedTime:</label>
		        <input name="modifiedTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modifiedBy:</label>
		        <input name="modifiedBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>version:</label>
		        <input name="version" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>delflag:</label>
		        <input name="delflag" class="easyui-textbox" data-options="required:true">
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">保存</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(0)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var rowId;
jQuery(function(){ 

	//初始化下拉框-示例，请根据需要自定义实现
   	/*
   	 $('#combo1').combobox({    
  	        url:'${rootPath}/getDictlist?dicttypeid=userstatus',    
  	        valueField:'dictid',    
  	        textField:'dictname',
  	     	panelHeight:'auto'
  	    }); 
  	  */ 
	
	rowId ='${rowId}';
	
	if (rowId != null && rowId != "" && rowId!=0){
		var url='${rootPath}/moduleContent/getOne?rowId=' + rowId;
		$('#dataForm').form('load', url);
	}
});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/moduleContent/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
				goBack(1);
			}
			else
			{
				$.messager.alert('提示',data.msg,'error');
				$('#save').linkbutton('enable');
			}
		});
	}
}
 
//返回父页面  
function goBack(flag){
	parent.returnParent(flag);
}
</script>

</body>
</html>