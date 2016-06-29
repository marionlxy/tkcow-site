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
<div>
	<form id="dataForm">
			<div class="fitem">
		    	<label>用户编码:</label>
		        <input name="userCode" class="easyui-textbox" data-options="required:true,validType: ['unNormal'] ">
			</div>
					<div class="fitem">
		    	<label>用户姓名:</label>
		        <input name="userName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>用户密码:</label>
		       <input  name="userPwd" type="password" class="easyui-textbox" data-options="required:true" />   

			</div>
			<div class="fitem">
			    <label>工作状态:</label>
				 <select class="easyui-combobox" name="workStatus" style="width:80px" panelHeight="60px" required="required">
				            <option value=""></option>				        
							<option value="1">在岗</option>
							<option value="0">离岗</option>
				 </select>
			</div>
			<div class="fitem">
		    	<label>用户状态:</label>
		       <select class="easyui-combobox" name="userStatus" style="width:80px" panelHeight="85px" required="required">				        
							<option value=""></option>
							<option value="0">已删除</option>
							<option value="1">正常</option>
							<option value="2">已冻结</option>
				</select>
			</div>
			<div class="fitem">
		    	<label>所属部门:</label>
		        <input name="userDept" class="easyui-textbox">
			</div>
			<div class="fitem">
		    	<label>生效日期:</label>
		        <input name="startValidate" class="easyui-datetimebox" data-options="required:true" >
			</div>
			<div class="fitem">
		    	<label>失效日期:</label>
		        <input name="endValidate" class="easyui-datetimebox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>用户性质:</label>
		        <select class="easyui-combobox" name="userNature" style="width:80px" panelHeight="85px" required="required">                      
                            <option value=""></option>
                            <option value="H">总公司</option>
                            <option value="B">分公司</option>
                </select>
			</div>
					<div class="fitem">
		    	<label>所属公司:</label>
		        <input name="userCom" class="easyui-textbox" >
			</div>
			<div class="fitem">
		    	<label>分公司:</label>
		       <input  name="comCoy" class="easyui-textbox" />   

			</div>
			<div class="fitem">
		    	<label>中支:</label>
		        <input name="comBranch" class="easyui-textbox" >
			</div>
			<div class="fitem">
		    	<label>营销服务部:</label>
		        <input name="comAgenter" class="easyui-textbox" >
			</div>
			
			</form>
    <div id="dlg-buttons" align="center">
       <!-- 页面按钮有无权限控制 -->
       <shiro:hasPermission name="sys:user:edit">
          <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">保存</a>
       </shiro:hasPermission>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBackFromAdd()" style="width:90px">取消</a>
   </div>
</div>
    
    
<script type="text/javascript">
	/**
	 * 保存记录新增用户<br/>
	 */
	function saveOrUpdate() {
		var r = $('#dataForm').form('validate');
		if (!r) {
			return false;
		} else {
			//$('#save').linkbutton('disable');
			$.post("${rootPath}/user/saveUserInfo", $("#dataForm")
					.serializeArray(), function(data) {
				if (data.result == 'true' || data.result == true) {
					$.messager.alert("success", data.msg);
					goBack(1);
				} else {
					$.messager.alert("error", data.msg);
				}
			});
		}
	}

	function goBackFromAdd() {
		$("#divDialog").window('close');
	}
</script>

</body>
</html>
