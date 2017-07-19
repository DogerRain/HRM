<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<div class="page-container">
	<div class="page-head">
		<div class="container">
			<div class="page-title">
				<h1>文件管理</h1>
			</div>
		</div>
	</div>
	<div class="page-content">
		<div class="container">
	   	<div class="page-bar">
	 		<ul class="page-breadcrumb breadcrumb">
				<li>
					<i class="fa fa-home"></i>
					<a href="${ctx }/index">首页</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="#"></a>
					<a href="#">文件管理</a>
				</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="portlet light">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift font-green-sharp"></i>
							<span class="caption-subject font-green-sharp bold uppercase">文件管理</span>
						</div>
						<div class="actions">
							<a href="${ctx}/doc/form" class="btn btn-default btn-circle new">
								<i class="fa fa-plus"></i>
								<span class="hidden-480">添加</span>
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-container">
							<div class="row list-separated">
								<div class="form-group">
									<label class="col-sm-1 control-label" for="title">名称</label>
									<div class="col-sm-3">
										<input class="form-control" id="title" name="title" type="text" />
									</div>
									<div class="col-md-1">
									<button class="btn yellow filter-submit search" id="search"><i class="fa fa-search"></i>查询</button>
									</div>
								</div>
							</div>
							<div class="row list-separated">
							</div>
							<div class="row list-separated">
								<table id="tableGrid"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	  </div>
</div>
<script type="text/javascript">
	jQuery(document).ready(function() {
		pageEventObj.initPageEvent();
		initDataGrid();
	});
		
	var pageEventObj = {
		initPageEvent:function(){
			$(".search").on("click", function(e) {
				var param = {
						title : $("#title").val(),
				};
				$("#tableGrid").datagrid('options').queryParams = param; 
				$("#tableGrid").datagrid('reload');  
				});
			}
	};
		
	var initDataGrid = function(){
		var param = {
			title : $("#title").val(),
		};
		$("#tableGrid").datagrid({
			url: "${ctx}/doc/query",
 			queryParams: param,
			idField : 'id',
			method: 'post',
			title: '',
			iconCls: '',
			height: 480,
			pagination:true,
			pageSize:10,
			striped:true,
			singleSelect:true,
			fitColumns :true, 
			columns:[[
				{field:'id',title:'ID',width:50,align:'center'},
				{field:'title',title:'标题',width:100,align:'center'},
				{field:'fileName',title:'文件名',width:100,align:'center'},
				{field:'remark',title:'备注',width:100,align:'center'},
				{field:'createBy',title:'创建人',width:80,align:'center',
					formatter:function(value,row,index){
						if(value != null){
							return value.username;
						}
					}	
				},
				{field:'createDate',title:'创建时间',width:120,align:'center'},
				{field:'updateBy',title:'修改人',width:80,align:'center',
					formatter:function(value,row,index){
						if(value != null){
							return value.username;
						}
					}
				},
				{field:'updateDate',title:'修改时间',width:120,align:'center'},
				{field:'operation',title:'操作',width:150,align:'center',
					formatter:function(value,row,index){
						var modBtn = '';
						var delBtn = '';
						var downloadBtn= '';
						if(row.id != null){
							modBtn = "<a href=\"${ctx}/doc/form?id="+row.id+"\">修改</a>";
							delBtn = "<a href=\"javascript:void(0);\" onclick=\"deleteDoc("+row.id+");\">删除</a>";
							downloadBtn = "<a href=\"${ctx}/doc/download?id="+row.id+"\">下载</a>"
						}
						return modBtn + "&nbsp;&nbsp;" + delBtn + "&nbsp;&nbsp;" + downloadBtn;
					}
				}
			]]
		});
	};


	function deleteDoc(id){
		bootbox.confirm({
			message:"确定要删除该文件吗",
			buttons:{
				confirm:{
					label:'确定',
					className: 'btn-danger'
				},
				cancel:{
					label:'取消',
					className:'btn-success'
				}
			},
			callback:function(result){
				if(result){
					location="${ctx}/doc/delete?id="+id;
				}
			}
		});
	}
</script>
</div>
</body>
</html>