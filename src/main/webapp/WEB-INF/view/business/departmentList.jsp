<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<div class="page-container">
	<div class="page-head">
		<div class="container">
			<div class="page-title">
				<h1>部门管理</h1>
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
					<a href="#">部门管理</a>
				</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="portlet light">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift font-green-sharp"></i>
							<span class="caption-subject font-green-sharp bold uppercase">部门管理</span>
						</div>
						<div class="actions">
							<a href="${ctx}/department/form" class="btn btn-default btn-circle new">
								<i class="fa fa-plus"></i>
								<span class="hidden-480">添加</span>
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-container">
							<div class="row list-separated">
								<div class="form-group">
									<label class="col-sm-1 control-label" for="name">名称</label>
									<div class="col-sm-3">
										<input class="form-control" id="name" name="name" type="text" />
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
						name : $("#name").val(),
				};
				$("#tableGrid").datagrid('options').queryParams = param; 
				$("#tableGrid").datagrid('reload');  
				});
			}
	};
		
	var initDataGrid = function(){
		var param = {
			name : $("#name").val(),
		};
		$("#tableGrid").datagrid({
			url: "${ctx}/department/query",
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
				{field:'name',title:'名称',width:240,align:'center'},
				{field:'remark',title:'描述',width:150,align:'center'},
				{field:'operation',title:'操作',width:150,align:'center',
					formatter:function(value,row,index){
						var modBtn = '';
						var delBtn = '';
						if(row.id != null){
							modBtn = "<a href=\"${ctx}/department/form?id="+row.id+"\">修改</a>";
							delBtn = "<a href=\"javascript:void(0);\" onclick=\"deleteDepartment("+row.id+");\">删除</a>"
						}
						return modBtn + "&nbsp;&nbsp;" + delBtn;
					}
				}
			]]
		});
	};


	function deleteDepartment(id){
		bootbox.confirm({
			message:"确定要删除该部门吗",
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
					location="${ctx}/department/delete?id="+id;
				}
			}
		});
	}
</script>
</div>
</body>
</html>