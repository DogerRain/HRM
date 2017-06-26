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
					<i class="fa fa-circle"></i>
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
	var eventObj ={
			editEvent: function(id){
				location="${ctx}/business/whiteurlgroup/form?id=" + id;
			},
			deleteEvent: function(id){
				deleteWhiteUrl(id);
			},
			emptyEvent: function(id){
				emptyWhiteUrl(id);
			},
			findDetailEvent: function(id, province){
				location = "${ctx}/business/whiteurl/list?groupId=" + id + "&province=" + province;
			},
			addDetailEvent: function(id, province){
				location="${ctx}/business/whiteurl/form?groupId=" + id + "&province=" + province;
			}
		};
		
		var pageEventObj ={
				initPageEvent:function(){
					$(".search").on("click", function(e) {
						var province = $("#province").val();
						var param = {
							name : $("#name").val(),
							province:province
						};
						$("#tableGrid").datagrid('options').queryParams = param; 
						$("#tableGrid").datagrid('reload');  
				    });
				}
		};
		
		var initDataGrid = function(){
			var province = $("#province").val();
			var param = {
				name : $("#name").val(),
				province:province
			};
			$("#tableGrid").datagrid({
				url: "${ctx}/business/whiteurlgroup/query",
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
					{field:'id',title:'序号',width:50,align:'center'},
					{field:'name',title:'名称',width:240,align:'center'},
					{field:'matchFlag',title:'匹配类型',width:100,align:'center',
						formatter:function(value,row,index){
							if(row.matchFlag == 0){
          		 				return "精准匹配";
          		 			}else if(row.matchFlag == 1){
          		 				return "模糊匹配";
          		 			}else if(row.matchFlag == 2){
          		 				return "域名匹配";
          		 			}
	                    } 	
					},
					{field:'provinceName',title:'省份',width:100,align:'center'},
					{field:'remarks',title:'描述',width:150,align:'center'},
					{field:'createDate',title:'创建时间',width:150,align:'center',
						formatter:function(value,row,index){
							if (row.createDate == undefined || row.createDate == null) {
								return null;
							} else {
								return new Date(row.createDate).format("yyyy-MM-dd HH:mm:ss");	
							}
						} 	
					},
					{field:'operation',title:'操作',width:300,align:'center',
						formatter:function(value,row,index){
							if (row.id == undefined || row.id == null) {
								return null;
							}
							var editBtn = "";
							var deleteBtn = "";
							var emptyBtn = "";
							var findDetailBtn = "";
							var addDetailBtn = "";
								editBtn = "<a href='javascript:void(0);' onclick='eventObj.editEvent(" + row.id+ ");'>修改</a>";
								deleteBtn = "<a href='javascript:void(0);' onclick='eventObj.deleteEvent(" + row.id+ ");'>删除</a>";
								emptyBtn = "<a href='javascript:void(0);' onclick='eventObj.emptyEvent(" + row.id + ");'>清空</a>";
								findDetailBtn = "<a href='javascript:void(0);' onclick='eventObj.findDetailEvent(" + row.id + "," + row.province + ");'>查看明细</a>";
								addDetailBtn = "<a href='javascript:void(0);' onclick='eventObj.addDetailEvent(" + row.id + "," + row.province + ");'>添加明细</a>";
							return editBtn + '&nbsp;' + deleteBtn + '&nbsp;' + emptyBtn + '&nbsp;' + findDetailBtn + '&nbsp;' + addDetailBtn;
	                    }
					}
				]]
			});
		};

		jQuery(document).ready(function() {
			pageEventObj.initPageEvent();
			initDataGrid();
			});
		function deleteWhiteUrl(id){
			$.ajax({
				url:"${ctx}/business/whiteurlgroup/isAllowedDelete?id="+id,
				type:"post",
				success:function(data){
					if(null!=data){
						if(false==data.success){//不可删除
							bootbox.alert(data.message); 
						}else{
							bootbox.confirm("确认要删除白名单URL组吗？", function(result) {
								if(result){
									location='${ctx}/business/whiteurlgroup/delete?id='+id;
								}
							});
						}
					}
				}
			});
		}
		function emptyWhiteUrl(id){
			bootbox.confirm("确认要清空白名单URL组吗？", function(result) {
				if(result){
					location='${ctx}/business/whiteurlgroup/empty?id='+id;
				}
			});
		}
		function initpRrovince(){
			$.ajax({
				url:"${ctx}/sys/user/getUserProvince",
				type:"post",
				success:function(data){
					if(null!=data){
						$("#province").empty();
						$("#province").append("<option value=''>全部</option>");
						$.each(data,function(index,item){
							$("#province").append("<option value='"+item.provinceCode+"'>"+item.provinceName+"</option>");
						});
					}
				}
			});
		}
	</script>
</div>
</body>
</html>