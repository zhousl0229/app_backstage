<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Tables</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Baxster Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="<%=path %>/assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="<%=path %>/assets/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link rel="icon" href="favicon.ico" type="image/x-icon" >
<!-- font-awesome icons -->
<link href="<%=path %>/assets/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- chart -->
<script src="<%=path %>/assets/js/Chart.js"></script>
<!-- //chart -->
 <!-- js-->
<script src="<%=path %>/assets/user/jquery-1.9.1.min.js"></script>
<script src="<%=path %>/assets/js/modernizr.custom.js"></script>
<link href="<%=path %>/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"  href="<%=path%>/assets/user/bootstrap-table/src/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/css/jqcandlestick.css" />
<!--webfonts-->
<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="<%=path %>/assets/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="<%=path %>/assets/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="<%=path %>/assets/js/metisMenu.min.js"></script>
<script src="<%=path %>/assets/js/custom.js"></script>
<link href="<%=path %>/assets/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class="sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right dev-page-sidebar mCustomScrollbar _mCS_1 mCS-autoHide mCS_no_scrollbar" id="cbp-spmenu-s1">
					<div class="scrollbar scrollbar1">
						<ul class="nav" id="side-menu">
							
							<li>
								<a href="index"><i class="fa fa-th-large nav_icon"></i>广告数据</a>
							</li>
						
							<li>
								<a href="user" class="chart-nav"><i class="fa fa-bar-chart nav_icon"></i>用户数据</a>
							</li>
							
						</ul>
					</div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<ul>	
							<li><img src="<%=path %>/assets/images/logo1.png" alt="" /></li>
							<li><h1>bostar</h1></li>
							<div class="clearfix"> </div>
						</ul>
					</a>
				</div>
				<!--//logo-->
				<div class="header-right header-right-grid">
					<div class="profile_details_left"><!--notifications of menu start -->
						<ul class="nofitications-dropdown">
							<li class="dropdown head-dpdn">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i><span class="badge">0</span></a>
								<ul class="dropdown-menu anti-dropdown-menu">
									<li>
										<div class="notification_header">
											<h3>You have 0 new messages</h3>
										</div>
									</li>
								</ul>
							</li>
							<li class="dropdown head-dpdn">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">0</span></a>
								<ul class="dropdown-menu anti-dropdown-menu">
									<li>
										<div class="notification_header">
											<h3>You have 0 new notification</h3>
										</div>
									</li>
								</ul>
							</li>	
							<li class="dropdown head-dpdn">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">0</span></a>
								<ul class="dropdown-menu anti-dropdown-menu">
									<li>
										<div class="notification_header">
											<h3>You have 0 pending task</h3>
										</div>
									</li>
								</ul>
							</li>	
						</ul>
						<div class="clearfix"> </div>
					</div>
				</div>
				
				
				<div class="clearfix"> </div>
			</div>
		
			<div class="header-right">
				
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="<%=path %>/assets/images/a.png" alt=""> </span> 
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="logout"><i class="fa fa-sign-out"></i>注销</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		
		<div id="page-wrapper">
			<div class="main-page">
				<!--grids-->
				<div class="grids">
					<div class="panel panel-widget">
						 名称：
		<input type="text" class="form-control" style="width:250px;display: inline;" placeholder="请输入账号" id="name" name="name">
		<button type="submit"  class="btn btn-default" onclick="search()"> 搜索</button>
	</div>
			
				<c:if test="${userSession.accountType==2}">
					<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default" onclick="add()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default" onclick="edit()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;&nbsp;编辑
			</button>
			<button id="btn_remove" type="button" class="btn btn-default" onclick="remove()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;&nbsp;删除
			</button>
			<button id="btn_edit" type="button" class="btn btn-default" onclick="passWord()">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;&nbsp;修改密码
			</button>
					</div>
				</c:if>
						<div >
							<div class="fit-body">
								<table id="btable" class="table table-bordered"></table>
								</div>
						</div>
					</div>
				</div>
				<!--//grids-->
				
			</div>
		</div>
		<!--footer-->
		 <div class="dev-page">
	 
			<!-- page footer -->   
			<!-- dev-page-footer-closed dev-page-footer-fixed -->
            <div class="dev-page-footer dev-page-footer-fixed"> 
				<!-- container -->
				<div class="container">
					<div class="copyright">
						<p>Copyright &copy; 2016.Company name All rights reserved.More Templates </p> 
					</div>
                </div>
				<!-- //container -->
            </div>
            <!-- /page footer -->
		</div>
        <!--//footer-->
	</div>
	<!-- Classie -->
		<script src="<%=path %>/assets/js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
		

        <script type="text/javascript" src="<%=path %>/assets/js/dev-loaders.js"></script>
        <script type="text/javascript" src="<%=path %>/assets/js/dev-layout-default.js"></script>
		<script type="text/javascript" src="<%=path %>/assets/js/jquery.marquee.js"></script>
		<script type="text/javascript" src="<%=path %>/assets/js/jquery.jqcandlestick.min.js"></script>
		<!--max-plugin-->
		<script type="text/javascript" src="<%=path %>/assets/js/plugins.js"></script>
		<!--//max-plugin-->
		<script src="<%=path %>/assets/js/jquery.nicescroll.js"></script>
		<script src="<%=path %>/assets/js/scripts.js"></script>
		<script src="<%=path%>/assets/user/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/assets/user/bootstrap-table/src/bootstrap-table.js"></script>
<script src="<%=path%>/assets/user/bootstrap-table/src/extensions/filter-control/bootstrap-table-filter-control.js"></script>
<script src="<%=path%>/assets/user/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="<%=path%>/assets/user/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="<%=path%>/assets/user/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="<%=path%>/assets/user/layer/layer.js"></script>
      <script type="text/javascript">
$(function() {
	//初始化Table
	var oTable = new TableInit();
	oTable.Init();
	$('#btable').on('click-row.bs.table', function (e, row, $element) {
    });
});

var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function() {
		$('#btable').bootstrapTable( {
			url : '<%=path%>/user/searchForBootstraptable', //请求后台的URL（*）
			method : 'post', //请求方式（*）
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, //是否显示分页（*）
			sortable : false, //是否启用排序
			queryParams : oTableInit.queryParams,//传递参数（*）
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			singleSelect : true, // 单选
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			height:tableHeight(),
			uniqueId : "id", //每一行的唯一标识，一般为主键列
			showToggle : false, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			columns : [ {checkbox : true}, 
						{field: 'account', title: '账号',sortable: false,align: 'center'},
						{field: 'nickname',title:'昵称',sortable: false,align: 'center'},
						{field: 'status',title: '状态',sortable: true,align: 'center', formatter: function (value, row, index) {
							if(value==0) return "启用"; if(value==1) return "停用";}},
					    {field: 'ip', title: 'ip',sortable: false,align: 'center'},
					    {field: 'lastIp', title: '上次登录IP',sortable: false,align: 'center'},
					    {field: 'loginCount', title: '登录次数',sortable: false,align: 'center'},
					    {field: 'createTime', title: '注册时间',sortable: false,align: 'center'},
						 ]
		});
	};

	//得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			rows : params.limit, //页面大小
			page : params.offset / params.limit + 1, //页码
            //sort : params.sort,
            //order : params.order,
            'filter_LIKES_account' : $("#name").val(),
            'filter_LTI_status': 2,
            //'filter_EQI_functionType' : 1
		};
		return temp;
	};
	return oTableInit;
};

function tableHeight() {
	var window_height = $(window).height();
	var obj_off_y = $(".fit-body").offset().top;
	var result_height = window_height - obj_off_y;
	return result_height;
}

// 新增
function add(){
	var url = '<%=path%>/user/edit';
	layer.open({
		type: 2,
		area: ['40%','50%'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: "添加账号",
		content: url
	});
}

// 修改密码
function passWord(){
		var ids = $('#btable').bootstrapTable('getSelections');
	    if(ids.length>0){
		    if(ids.length==1){
		    	var url = '<%=path%>/user/password?id='+ids[0].id;
				layer.open({
					type: 2,
					area: ['40%','50%'],
					fix: false, //不固定
					maxmin: true,
					shade:0.4,
					title: "修改密码",
					content: url
				});
		    }else{
		    	layer.msg("请选择一条数据编辑",{icon:2,time:5000});
		    }
	    }else{
	    	layer.msg("请选择数据",{icon:2,time:5000});
	    }
	}

// 编辑
function edit(){
	var ids = $('#btable').bootstrapTable('getSelections');
    if(ids.length>0){
	    if(ids.length==1){
			var url = '<%=path%>/user/edit?id='+ids[0].id;
			layer.open({
				type: 2,
				area: ['40%','50%'],
				fix: false, //不固定
				maxmin: true,
				shade:0.4,
				title: "编辑账号",
				content: url
			});
	    }else{
	    	layer.msg("请选择一条数据编辑",{icon:2,time:5000});
	    }
    }else{
    	layer.msg("请选择数据",{icon:2,time:5000});
    }
}

// 删除
function remove(){
    var ids = $.map($('#btable').bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
    if(ids.length>0){
    	if(ids.length==1){
    	layer.confirm('您确定要删除选中的行？', {icon: 3, title:'提示'}, function(index){
            $.ajax({
                url: '<%=path %>/user/logicallyDelete',
                type: 'post',
                data: {idd: ids[0],value:2,filed:'status'},
                traditional: true,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 1) {
                    	layer.msg(data.msg,{icon:1,time:5000});
						$('#btable').bootstrapTable('refresh');
                    } else {
                    	layer.msg(data.msg,{icon:2,time:5000});
                    }
                }
            });
    		layer.close(index);
    	});
    	}
    	else{
	    	layer.msg("请选择一条数据编辑",{icon:2,time:5000});
	    }
    }else{
    	layer.msg("请选择数据",{icon:2,time:5000});
    }
}

// 查询
function search(){
	$('#btable').bootstrapTable('refresh');
}
</script>
</body>
</html>