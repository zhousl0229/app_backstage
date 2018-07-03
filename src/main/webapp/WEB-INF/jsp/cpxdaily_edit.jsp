<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="resource.jsp" %>
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
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>保存广告数据</title>
</head>
<body>
	<div class="page-container">
		<form class="form form-horizontal" id="cpxdaily_from">
			<input type="hidden" value="${ cpxdaily.id}" id="id" name="id"> 
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">合作日期：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="<fmt:formatDate value="${cpxdaily.cdate}" pattern="yyyy-MM-dd"/>"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly  placeholder="合作日期" id="cdate" name="cdate" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">合作应用：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.cname}"   placeholder="合作应用" id="cname" name="cname" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">客户名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.aname}"   placeholder="客户名称" id="aname" name="aname" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">展示次数：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.shows}"   placeholder="展示次数" id="shows" name="shows" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">点击次数：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.clicks}"   placeholder="点击次数" id="clicks" name="clicks" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">激活数：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.actives}"   placeholder="激活数" id="actives" name="actives" >
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">分成金额：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${cpxdaily.sales}"   placeholder="分成金额" id="sales" name="sales" >
				</div>
			</div>
			

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">应用激活：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">

						<div class="radio-box">
							<input name="cstatus" type="radio" id="sex-1" value="1" checked>
							<label for="sex-1">开放</label>
						</div>

						<div class="radio-box">
							<input type="radio" id="sex-2" value="2" name="cstatus"> <label
								for="sex-2">关闭</label>
						</div>

					</div>
				</div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">结算模式：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">

						<div class="radio-box">
							<input name="ctype" type="radio" id="sex-1" value="CPA" checked>
							<label for="sex-1">CPA</label>
						</div>

						<div class="radio-box">
							<input type="radio" id="sex-2" value="CPS" name="ctype"> <label
								for="sex-2">CPS</label>
						</div>
						
						<div class="radio-box">
							<input type="radio" id="sex-2" value="CPC" name="ctype"> <label
								for="sex-2">CPC</label>
						</div>

					</div>
				</div>
			</div>


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"></label>
				<div class="formControls col-xs-8 col-sm-9">
					<button class="btn btn-primary radius" type="submit">
						<i class="Hui-iconfont"></i> 保存
					</button>
					<button onClick="layer_close();" class="btn btn-default radius"
						type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</div>
		</form>
	</div>




	<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/assets/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/assets/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/assets/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/assets/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/assets/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${path}/assets/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${path}/assets/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="${path}/assets/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript">

$(function() {
	$(":radio[name='cstatus'][value='${cpxdaily.cstatus}']").prop("checked", "checked");
	$(":radio[name='ctype'][value='${cpxdaily.ctype}']").prop("checked", "checked");
	$('.skin-minimal input').iCheck({
		checkboxClass : 'icheckbox-blue',
		radioClass : 'iradio-blue',
		increaseArea : '20%'
	});

	$("#cpxdaily_from").validate(
			{
				rules : {
					cdate:{
						required:true,
					},
					cname:{
						required:true,
					},
					aname:{
						required:true,
					},
					shows:{
						required:true,
					},
					clicks:{
						required:true,
					},
					actives:{
						required:true,
					},
					sales:{
						required:true,
					},

				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$.post('save.do', $("#cpxdaily_from").serialize(),
							function(data) {
								if (data.code == 1) {
									parent.layer.msg(data.msg, {
										icon : 1,
										time : 5000
									});
									parent.table.ajax.reload();
									var index = parent.layer
											.getFrameIndex(window.name); //获取窗口索引
									parent.layer.close(index); // 关闭layer
								} else {
									layer.msg(data.msg, {
										icon : 2,
										time : 5000
									});
								}
							}, 'json');
				}
			});
	});



	
</script> 
</body>
</html>