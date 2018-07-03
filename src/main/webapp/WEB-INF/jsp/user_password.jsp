<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/style.css" />

    <script type="text/javascript" src="<%=path %>/assets/user/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/user/datatables/1.10.0/jquery.dataTables.min.js"></script>  
    <script type="text/javascript" src="<%=path %>/assets/user/jquery.validation/1.14.0/jquery.validate.js"></script> 
    <script type="text/javascript" src="<%=path %>/assets/user/jquery.validation/1.14.0/validate-methods.js"></script> 
  <script type="text/javascript">
$(function(){

	$("#form-admin-add").validate({
		rules:{
			newPassword:{
				required:true,
				rangelength:[5,10],
			},
			password2:{
				required:true,
				equalTo: "#newPassword",
				rangelength:[5,10],
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
            $.post('updateUserPassword.do', $("#form-admin-add").serialize(), function (data) {
				if (data.code == 1) {
					parent.layer.msg(data.msg,{icon:1,time:5000});
					parent.$('#btable').bootstrapTable('refresh');
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					parent.layer.close(index);  // 关闭layer
				}else{
					layer.msg(data.msg,{icon:2,time:5000});
				}
            }, 'json');
		}
	});
});
</script> 

<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add">
		<input type="hidden" id="id" name="id" value="${user.id}"/>
		<div class="row cl" id="passwordstyle">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input  onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" type="password" class="input-text" autocomplete="off" placeholder="密码" id="newPassword" name="newPassword">
			</div>
		</div>
		<div class="row cl" id="passwordstyle1">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" type="password" class="input-text" autocomplete="off" placeholder="确认新密码" id="password2" name="password2">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
</body>
</html>