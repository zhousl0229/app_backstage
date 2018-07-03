<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="resource.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<link href="${path}/article/css/icheck_skins/all.css" rel="stylesheet"/>
<link rel="stylesheet" href="${path}/article/css/bootstrap-fileupload.css"/>

<link rel="stylesheet" href="${path}/article/css/tabs.css"/>
<link rel="stylesheet" href="${path}/article/css/layout.css"/>
<link rel="stylesheet" href="${path}/article/css/bootstrap.css"/>
<link rel="stylesheet" href="${path}/article/css/table.css"/>
<link rel="stylesheet" href="${path}/article/css/font-awesome.css"/>

<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/admin/static/jquery-ui-1.12.1.custom/jquery-ui.min.css" />
<style>
    .item_content ul {
        list-style: none;
    }

    .item_content ul li {
        width: 370px;
        height: 430px;
        float: left;
        margin-right: 30px;
    }
    table tfoot th{
        background-color: #7a7a7a;
    }
</style>
<body>
<ul class="tabs" style="background-color: #faf3f3">
    <li class="current">
        <a href="javascript:void(0)" id="#tab1">数据统计</a>
    </li>
    <li>
        <a href="${path}/logout" id="#tab2">注销</a>
    </li>
</ul>
<ul>

</ul>



<div class="tabs_content" style="">

        结算模式：
        <select style="width: 12%" class="select-box" size="1"  id="ctype" name="ctype">
            <option value="" selected>请选择...</option>
            <option value="CPA" >CPA</option>
            <option value="CPS" >CPS</option>
            <option value="CPC" >CPC</option>

        </select>
        合作应用：<input type="text" name="cname" id="cname" placeholder="应用名称" style="width:200px;height: 28px;" class="input-text">

        结算日期	<input  type="text" style="width:190px;height: 28px;"  class="input-text Wdate" id="startTime" name="startTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})" value="<fmt:formatDate value="${activity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly>
        <input  type="text" style="width:190px;height: 28px;" class="input-text Wdate" id="endTime" name="endTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}'})" value="<fmt:formatDate value="${activity.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly>
        <button name="" id="" class="btn btn-success"  onclick="search()" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>

    <div id="tab1" style="display: block;">

        <table id="tbRecord" class="table table-sort">
             <span class="l">
	        <a href="javascript:;" onclick="updateStatus(2)" class="btn btn-danger active"><i class="Hui-iconfont">&#xe6a6;</i>关闭</a>
	        <a href="javascript:;" onclick="updateStatus(1)" class="btn btn-success"><i class="Hui-iconfont">&#xe6a7;</i>开放</a>
	        <a class="btn btn-success" onclick="add()" href="javascript:;"> <i class="Hui-iconfont"><i class="Hui-iconfont">&#xe600;</i></i>添加</a>
	        <a href="javascript:;" onclick="edit()" class="btn btn-primary"><i class="icon-edit" style="margin-right:3px"></i> 编辑</a>
	        <a href="javascript:;" onclick="remove()" class="btn btn-danger"><i class="icon-trash" style="margin-right:3px"></i> 删除</a>
	        <span class="btn-upload form-group">
			<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly="" style="width:200px;display:none">
			<a href="javascript:void();" class="btn btn-primary radius upload"><i class="Hui-iconfont"></i>  数据导入</a>
			<input type="file"  onchange="uploadFile('excelFile','Excel','uploadFile');" id="excelFile"  multiple="" name="excelFile" class="input-file">
			</span>
	    </span>
            <thead>
            <tr class="text-c">
                <th><input type="checkbox" name="select_all" id="select-all"></th>
                <th>序号</th>
                <th>合作日期</th>
                <th>合作应用</th>
                <th>客户名称</th>
                <th>结算模式</th>
                <th>展示次数</th>
                <th>点击次数</th>
                <c:if test="${userSession.accountType==2}">
                    <th>应用激活</th>
                </c:if>
                <th>分成金额</th>
                <th>激活数</th>
            </tr>
            </thead>
            <tfoot>
                    <tr>
                        <th colspan="11">
                        <div style="text-align: right">
                            <h4>激活数汇总 : ${sum} &nbsp; &nbsp; 分成金额汇总 ：${sumSales}</h4>
                        </div>
                    </th></tr>
                    </tfoot>
            <tbody>
            <tr>
            <td>文章标题</td>
            <td style="display: none;">true</td>
            <td>
            首页代码 设计 金...</td>
            <td>2018-04-11</td>
            <td class="td_column_edit" id="td_column_edit_1" align="center" style="cursor:pointer;"><button class="btn btn-primary"><i class="icon-edit" style="margin-right:3px"></i>编辑</button></td>
            <td class="td_column_delete" id="td_column_delete_1" align="center" style="cursor:pointer;"><button class="btn btn-danger"><i class="icon-trash" style="margin-right:3px"></i>删除</button></td>
            </tr>
            </tbody>

        </table>
    </div>
    <script type="text/javascript" src="${path}/article/js/jquery-1.8.3.min.js"></script>
    <script src="${path}/article/js/bootstrap/bootstrap-fileupload.js"></script>
    <script type="text/javascript" charset="utf-8" src="${path}/article/js/kindeditor.js"></script>
</div>
</body>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/assets/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${path}/assets/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/assets/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${path}/assets/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/assets/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${path}/assets/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${path}/assets/admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${path}/assets/admin/static/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        table = $('.table-sort').DataTable({
            "bAutoWidth": true, //自适应宽度
            "sScrollX": "100%",
            "sScrollXInner": "100%",
            "bScrollCollapse": true,
            "aLengthMenu": [10, 15, 20], //动态指定分页后每页显示的记录数。
            "processing": true,//代码没加载完成时 会显示加载中…
            "searching": false,//关闭datatables自带搜索功能（没什么用）
            "bPaginate": true, //翻页功能
            "bLengthChange": false, //改变每页显示数据数量
            "bFilter": false, //过滤功能
            "bSort": false, //排序功能
            "serverSide": true,//服务器端处理数据
            "sPaginationType": "full_numbers",//用这个参数显示的页码工具比较全 除了"full_numbers"还有‘two_button’
            "oLanguage": {   //DataTable中文化 把提示语之类的换成中文
                "sProcessing": "正在获取数据，请稍后...",
                "sLengthMenu": "显示 _MENU_ 条",
                "sZeroRecords": "没有找到数据",
                "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "第一页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "最后一页"
                }
            },
            "ajax": {
                "type": "POST",
                "url": '${path}/cpxdaily/search',
                "data": function (data) {//在此处对data（datatables传给服务器端的数据）进行处理 data.start是从哪个数据开始，data.length是页面长度 通过这两个参数可以分页
                    data.page = data.start / data.length + 1;
                    data.rows = data.length;
                    data.order="desc";
                    data.sort="cdate";
                    data.filter_EQS_ctype = $("#ctype").val();
                    data.filter_LIKES_cname = $("#cname").val();
                    data.filter_GTD_cdate = $("#startTime").val();
                    data.filter_LTD_cdate = $("#endTime").val();
                    data.filter_LEI_cstatus = "${userSession.accountType}";

                },
            },
            "aoColumns": [ //aoColumns设置列
                {
                    "data": function (data) {
                        return '<input class="checkbox_select" onclick="stopEven();" name="checkbox" value="' + data.id + '" type="checkbox"/>';
                    }, "targets": 0, 'sClass': "text-c odd"
                },
                {"data": null, "targets": 0, 'sClass': "text-c odd"},
                {"data": "cdate", "orderable": false, 'sClass': "text-c odd"},
                {"data": "cname", "orderable": false, 'sClass': "text-c odd"},//data 数据 如果复杂逻辑可以写在回调fnRowCallback中否则可以直接返回aoData的属性
                {"data": "aname", "orderable": false, 'sClass': "text-c odd"},
                {"data": "ctype", "orderable": false, 'sClass': "text-c odd"},
                {"data": "shows", "orderable": false, 'sClass': "text-c odd"},
                {"data": "clicks", "orderable": false, 'sClass': "text-c odd"},
                <c:if test="${userSession.accountType==2}">
                {
                    "data": function (data) {
                        if (data.cstatus == 2) return "<span>关闭</span>"; else return " <span>开放</span>";
                    }, "orderable": false, 'sClass': "text-c odd"
                },
                </c:if>
                {"data": "sales", "orderable": false, 'sClass': "text-c odd"},
                {"data": "actives", "orderable": false, 'sClass': "text-c odd"},
            ],

            "fnDrawCallback": function () {
                var api = this.api();
                var startIndex = api.context[0]._iDisplayStart;//获取到本页开始的条数
                api.column(1).nodes().each(function (cell, i) {
                    cell.innerHTML = startIndex + i + 1;
                });
            }
        });
//标记选中的列
        $('.table-sort tbody').on('click', 'tr', function (e) {
            if ($(this).find("input[type='checkbox']").is(':checked')) {
                //$(this).removeClass('selected');
                $(this).find("input").prop("checked", false);
            } else {
                $(this).find("input").prop("checked", true);
                //$(this).addClass('selected');
            }
        });

//页面上点击此属性，将当前页的列表数据全部选中
        $('#select-all').on('click', function () {
            if (this.checked) {
                $('.checkbox_select').each(function () {
                    this.checked = true;
                });
            } else {
                $('.checkbox_select').each(function () {
                    this.checked = false;
                });
            }
        });

    });

    function stopEven()//阻止事件冒泡
    {
        event.stopPropagation();
    }

    //修改状态
    function updateStatus(status) {
        var ids = new Array();
        var i = 0;
        $("input[name='checkbox']:checked").each(function () {
            ids[i++] = $(this).val();
        })

        if (ids.length == 0) {
            layer.msg('请选择一行', {
                icon: 2,
                time: 2000
            });
        } else if (ids.length > 1) {
            layer.msg('只能选择一行', {
                icon: 2,
                time: 2000
            });
        } else {
            layer.confirm('您确定要操作选中的行？', {
                icon: 3,
                title: '提示'
            }, function (index) {
                $.ajax({
                    type: "POST", //使用post方法访问后台
                    dataType: "json", //返回json格式的数据
                    url: '${path}/cpxdaily/logicallyDelete?idd=' + ids[0] + "&value=" + status + "&field=cstatus", //要访问的后台地址
                    success: function (result) {//result为返回的数据
                        if (result.code == 1)
                            setTimeout(search(), 2000);
                        layer.msg(result.msg, {
                            icon: result.code,
                            time: 2000
                        });
                    }
                });
                layer.close(index);
            });
        }
    }

    //删除
    function remove() {
        var ids = new Array();
        var i = 0;
        $("input[name='checkbox']:checked").each(function () {
            ids[i++] = $(this).val();
        })

        if (ids.length == 0) {
            layer.msg('请选择一行', {
                icon: 2,
                time: 2000
            });
            return false;
        } else {
            layer.confirm('您确定要操作选中的行？', {
                icon: 3,
                title: '提示'
            }, function (index) {
                $.ajax({
                    type: "POST", //使用post方法访问后台
                    dataType: "json", //返回json格式的数据
                    url: '${path}/cpxdaily/remove?ids=' + ids, //要访问的后台地址
                    success: function (result) {//result为返回的数据
                        if (result.code == 1)
                            setTimeout(search(), 2000);
                        layer.msg(result.msg, {
                            icon: result.code,
                            time: 2000
                        });
                    }
                });
                layer.close(index);
            });
        }
    }

    //查询
    function search() {
        table.ajax.reload();
    }

    /*新增*/
    function add() {

        var url = '${path}/cpxdaily/edit';
        layer_show('新增用户', url, '800', '700');

    }

    /* 编辑 */
    function edit() {
        var ids = new Array();
        var i = 0;
        $("input[name='checkbox']:checked").each(function () {
            ids[i++] = $(this).val();
        })

        if (ids.length == 0) {
            layer.msg('请选择一行', {
                icon: 2,
                time: 2000
            });
            return false;
        } else if (ids.length > 1) {
            layer.msg('只能选择一行', {
                icon: 2,
                time: 2000
            });
            return false;
        }
        var url = '${path}/cpxdaily/edit?id=' + ids[0];
        layer_show('编辑广告数据', url, '800', '700');

    }

    //上传
    /*
    id           文件标签ID
    fileName     保存到哪个目录下
    path         上传路径
    */
    function uploadFile(id, fileName, path) {
        var index = layer.load(1, {
            shade: [0.5, '#494848'] //0.1透明度的白色背景
        });
        var file = $('#' + id).val();

        if (file == '') {
            layer.closeAll('loading');
            return false;
        }

        var point = file.lastIndexOf(".");
        var suffix = file.substr(point);
        var fileObj = document.getElementById(id).files[0]; // 获取文件对象
        var fileSize = 0;
        var size = fileObj.size / 1024 * 1024;
        if (size > (1024 * 30000)) {
            layer.msg("文件大小不能超过30M");
            $('#' + id).val('');
            layer.closeAll('loading');
            return false;
        }

        if (!/.(xlsx|xls)$/.test(file)) {
            $('#' + id).val('');
            layer.closeAll('loading');
            layer.msg("请上传Excel文件", {icon: 2, time: 3000});
            return false;
        }

        var FileController = "${path}/uploadFile.do?fileDir=" + fileName + "&suffix=" + suffix;
// FormData 对象
        var form = new FormData();
        form.append("author", "hooyes");      // 可以增加表单数据
        form.append("file", fileObj);         // 文件对象
// XMLHttpRequest 对象
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = callback;
        xhr.open("post", FileController, true);
        xhr.onload = function (data) {
            //alert("上传成功!");
        };

        function callback() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var data = eval("data =" + xhr.responseText);
                    layer.closeAll('loading');
                    layer.msg(data.msg);
                }
            }
        }

        xhr.send(form);
    }

</script>

</html>