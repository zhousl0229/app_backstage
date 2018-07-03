<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->


<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/user/edit/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<title>保存用户</title>
</head>
<body>
	<div class="page-container" >
		<form class="form form-horizontal" id="user_from">
			<input type="hidden" value="${ user.id}" id="id" name="id"> 
			<input type="hidden" value="${ user.ip}" id="ip" name="ip"> 
			<input type="hidden" value="${ user.lastIp}" id="lastIp" name="lastIp"> 
			<input type="hidden" value="${ user.loginCount}" id="loginCount" name="loginCount"> 
			<c:if test="${!empty user}">
				<input type="hidden" id="password" name="password"
					value="${user.password}" />
					<input type="hidden" value="${ user.accountType}" id="accountType" name="accountType">
			</c:if>
			<c:if test="${empty user}">
				<input type="hidden" value="1" id="accountType" name="accountType">
			</c:if>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>账号：</label>
					<input type="text" class="input-text" value="${user.account}"
						placeholder="3-10个字符" id="account" name="account"
						onkeyup="this.value=this.value.replace(/^ +| +$/g,'')">
			</div>
			<div class="row cl" id="passwordstyle">
				<label class="form-label col-xs-4 col-sm-3">初始密码：</label>
				
					<input type="password" class="input-text" autocomplete="off"
						value="${user.password}" placeholder="初始密码(5-10个字符)" id="password"
						name="password"
						onkeyup="this.value=this.value.replace(/^ +| +$/g,'')">
			</div>
			<div class="row cl" id="passwordstyle1">
				<label class="form-label col-xs-4 col-sm-3"></span>确认密码：</label>
				
					<input type="password" class="input-text" autocomplete="off"
						value="${user.password}" placeholder="确认密码(5-10个字符)" id="password2"
						name="password2"
						onkeyup="this.value=this.value.replace(/^ +| +$/g,'')">
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"></span>昵称：</label>
				
					<input type="text" class="input-text" value="${user.nickname}"
						placeholder="昵称" id="nickname" name="nickname"
						onkeyup="this.value=this.value.replace(/^ +| +$/g,'')">
			</div>


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">状态：</label>
				
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">

						<div class="radio-box">
							<input name="status" type="radio" id="sex-1" value="0" checked>
							<label for="sex-1">启用</label>
						</div>

						<div class="radio-box">
							<input type="radio" id="sex-2" value="1" name="status"> <label
								for="sex-2">停用</label>
						</div>

					</div>
			</div>




			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"></label>
				
					<button class="btn btn-primary radius" type="submit">
						<i class="Hui-iconfont"></i> 保存
					</button>
					<button onClick="layer_close();" class="btn btn-default radius"
						type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
		</form>
	</div>




    <script type="text/javascript" src="<%=path %>/assets/user/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/user/datatables/1.10.0/jquery.dataTables.min.js"></script>  
    <script type="text/javascript" src="<%=path %>/assets/user/jquery.validation/1.14.0/jquery.validate.js"></script> 
    <script type="text/javascript" src="<%=path %>/assets/user/jquery.validation/1.14.0/validate-methods.js"></script> 
  <script type="text/javascript">
$(function() {
	$(":radio[name='status'][value='${user.status}']").prop("checked", "checked");
	if('${user.id}'!=''){
		$('#passwordstyle').remove();
		$('#passwordstyle1').remove();
	}
	$("#user_from").validate(
			{
				rules : {
					account:{
						required:true,
						isAccount:true,
						rangelength:[3,10],
					},
					nickname:{
						required:true,
						rangelength:[1,10],
					},
					password:{
						required:true,
						rangelength:[5,10],
					},
					password2:{
						required:true,
						equalTo: "#password",
						rangelength:[5,10],
					},
				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$.post('_save.do', $("#user_from").serialize(),
							function(data) {
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

//自定义验证	

//账号
$.validator.addMethod("isAccount",function(value,element){
	 var reg = /^\w+$/;
 return this.optional(element) || (reg.test(value));
},"<font color='#E47068'>只能输入数字、字母、下划线</font>");

	
</script> 
</body>
</html>