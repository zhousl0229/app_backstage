<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Moonlight CSS Template</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="<%=path%>/index/apple-touch-icon.png">

    <link rel="stylesheet" href="<%=path%>/index/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/index/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="<%=path%>/index/css/fontAwesome.css">
    <link rel="stylesheet" href="<%=path%>/index/css/light-box.css">
    <link rel="stylesheet" href="<%=path%>/index/css/templatemo-main.css">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <%--插件--%>
    <link rel="stylesheet"  href="<%=path%>/assets/user/bootstrap-table/src/bootstrap-table.css">
    <link href="<%=path%>/assets/css/bootstrap.css" rel="stylesheet">
    <script src="<%=path %>/assets/user/jquery-1.9.1.min.js"></script>
    <script src="<%=path %>/assets/js/modernizr.custom.js"></script>
    <link rel="stylesheet"  href="<%=path%>/assets/user/bootstrap-table/src/bootstrap-table.css">

    <script src="<%=path%>/index/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>

<body>

<div class="sequence">

    <div class="seq-preloader">
        <svg width="39" height="16" viewBox="0 0 39 16" xmlns="http://www.w3.org/2000/svg" class="seq-preload-indicator"><g fill="#F96D38"><path class="seq-preload-circle seq-preload-circle-1" d="M3.999 12.012c2.209 0 3.999-1.791 3.999-3.999s-1.79-3.999-3.999-3.999-3.999 1.791-3.999 3.999 1.79 3.999 3.999 3.999z"/><path class="seq-preload-circle seq-preload-circle-2" d="M15.996 13.468c3.018 0 5.465-2.447 5.465-5.466 0-3.018-2.447-5.465-5.465-5.465-3.019 0-5.466 2.447-5.466 5.465 0 3.019 2.447 5.466 5.466 5.466z"/><path class="seq-preload-circle seq-preload-circle-3" d="M31.322 15.334c4.049 0 7.332-3.282 7.332-7.332 0-4.049-3.282-7.332-7.332-7.332s-7.332 3.283-7.332 7.332c0 4.05 3.283 7.332 7.332 7.332z"/></g></svg>
    </div>

</div>


<nav>
    <div class="logo">
        <img src="<%=path%>/index/img/logo.png" alt="">
    </div>
    <div class="mini-logo">
        <img src="<%=path%>/index/img/mini_logo.png" alt="">
    </div>
    <ul>
        <li><a href="#1"><i class="fa fa-home"></i> <em>Home</em></a></li>
        <li><a href="#2"><i class="fa fa-user"></i> <em>About</em></a></li>

        <li></li>
        <li></li>

    </ul>
</nav>

<div class="slides">
    <div class="slide" id="1">
        <div class="content first-content">
            <div class="container-fluid">
                <div class="col-md-3">
                    <div class="author-image"><img src="<%=path%>/index/img/author_image.png" alt=""></div>
                </div>
                <div class="col-md-9">
                    <h2>${nickname}</h2>
                    <p> </p>
                    <div class="main-btn"><a href="#2">Read More</a></div>
                    <div class="fb-btn"><a href="<%=path%>/logout" target="_blank">log out</a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="slide" id="2">
        <div class="content second-content">

            <div class="container-fluid">

                <div class="col-md-12">

                    <div class="left-content">
                        <div class="panel panel-widget">

                            结算模式： <select style="width:15%;display: inline;" class="form-control"
                                          size="1" id="ctype" name="ctype">
                            <option value="" selected>select...</option>
                            <option value="CPA">CPA</option>
                            <option value="CPS">CPS</option>
                            <option value="CPC">CPC</option>
                        </select>
                            结算日期: <input placeholder="begin date"  style="width:15%;display: inline;" type="text" class="form-control" id="startTime" name="startTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})"  />
                            <input placeholder="end date"  style="width:15%;display: inline;" type="text" class="form-control" id="endTime" name="endTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}'})" />
                            合作应用: <input type="text" class="form-control" style="width:18%;display: inline;" placeholder="enter app name" id="cname" name="cname">
                            <button type="submit"  class="btn btn-default" onclick="search()"> search</button>

                        </div>
                        <div class="fit-body">
                            <table id="btable" class="table table-striped table-bordered table-hover" style="color: #0e90d2" id="dataTables-example">
                            <tfoot>
			                    <tr>
			                        <th colspan="11">
			                        <div style="text-align: right">
			                            <h4>激活数汇总 : ${sum} &nbsp; &nbsp; 分成金额汇总 ：${sumSales}</h4>
			                        </div>
			                    </th></tr>
			                    </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="slide" id="3">
        <div class="content third-content">
            <div class="container-fluid">
                <div class="col-md-12">
                    <div class="row">
                        <div class="first-section">
                            <div class="container-fluid">
                                <div class="row">

                                </div>
                            </div>
                        </div>
                        <div class="second-section">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="left-image">

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="slide" id="4">
        <div class="content fourth-content">
            <div class="container-fluid">
                <div class="row">

                </div>
            </div>
        </div>
    </div>

    <div class="slide" id="5">
        <div class="content fifth-content">
            <div class="container-fluid">

            </div>
        </div>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="<%=path%>/index/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>



<script src="<%=path%>/index/js/datepicker.js"></script>
<script src="<%=path%>/index/js/plugins.js"></script>
<script src="<%=path%>/index/js/main.js"></script>



</body>
<script type="text/javascript" src="<%=path%>/assets/js/dev-loaders.js"></script>
<script type="text/javascript" src="<%=path%>/assets/js/dev-layout-default.js"></script>
<script type="text/javascript" src="<%=path%>/assets/js/jquery.marquee.js"></script>
<script type="text/javascript" src="<%=path%>/assets/js/jquery.jqcandlestick.min.js"></script>
<!--max-plugin-->
<script type="text/javascript" src="<%=path%>/assets/js/plugins.js"></script>
<!--//max-plugin-->
<script src="<%=path%>/assets/js/jquery.nicescroll.js"></script>
<script src="<%=path%>/assets/js/scripts.js"></script>
<script src="<%=path%>/assets/user/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/assets/user/bootstrap-table/src/bootstrap-table.js"></script>
<script src="<%=path%>/assets/user/bootstrap-table/src/extensions/filter-control/bootstrap-table-filter-control.js"></script>
<script src="<%=path%>/assets/user/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=path%>/assets/user/layer/layer.js"></script>

<script type="text/javascript" src="<%=path%>/assets/user/My97DatePicker/4.8/WdatePicker.js"></script>
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
                url : '<%=path%>/cpxdaily/searchForBootstraptable', //请求后台的URL（*）
                method : 'post', //请求方式（*）
                contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                toolbar : '#toolbar', //工具按钮用哪个容器
                striped : false, //是否显示行间隔色
                cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination : true, //是否显示分页（*）
                sortable : false, //是否启用排序
                queryParams : oTableInit.queryParams,//传递参数（*）
                sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
                search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch : true,
                singleSelect : true, // 单选
                showColumns : false, //是否显示所有的列
                showRefresh : false, //是否显示刷新按钮
                minimumCountColumns : 2, //最少允许的列数
                clickToSelect : true, //是否启用点击选中行
                //height:tableHeight(),
                uniqueId : "id", //每一行的唯一标识，一般为主键列
                showToggle : false, //是否显示详细视图和列表视图的切换按钮
                cardView : false, //是否显示详细视图
                columns : [ {checkbox : true},
                    {field: 'cdate', title: 'dates',sortable: false,align: 'center'},
                    {field: 'cname',title:'app',sortable: false,align: 'center'},
                    {field: 'aname', title: 'cusname',sortable: false,align: 'center'},
                    {field: 'ctype',title:'paytype',sortable: false,align: 'center'},
                    {field: 'shows', title: 'shows',sortable: false,align: 'center'},
                    {field: 'clicks',title:'clicks',sortable: false,align: 'center'},
                    {field: 'sales',title:'sales',sortable: false,align: 'center'},
                    {field: 'actives',title:'actives',sortable: false,align: 'center'},
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
                //'filter_LIKES_account' : $("#name").val(),
                //'filter_LTI_status': 2,
                //'filter_EQI_functionType' : 1
                sort : "cdate",
                order: "desc",
                filter_EQS_ctype:$("#ctype").val(),
                filter_GTD_cdate:$("#startTime").val(),
                filter_LTD_cdate:$("#endTime").val(),
                filter_LIKES_cname:$("#cname").val(),
                filter_LEI_cstatus:"${userSession.accountType}",
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

    // 删除
    function updateStatus(status){
        var ids = $.map($('#btable').bootstrapTable('getSelections'), function (row) {
            return row.id;
        });
        if(ids.length>0){
            if(ids.length==1){
                layer.confirm('您确定要操作选中的行？', {icon: 3, title:'提示'}, function(index){
                    $.ajax({
                        url: '${path}/cpxdaily/logicallyDelete',
                        type: 'post',
                        data: {'idd': ids[0],'value':status,'field':'cstatus'},
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
</html>