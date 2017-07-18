<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<div class="page-container">
			<div class="table-container">
				<input type="hidden" id="selectedId" value="${selId}"/>
				<input type="hidden" id="selectedName"/>
				<table id="dataGrid"></table>
			</div>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			$("#dataGrid").datagrid({
				url: "${ctx}/job/lookupTable",
				idField : 'id',
				//method: 'post',
				title: '',
				iconCls: '',
				fitColumns: true,
				width:'100%',
				height:420,
				pagination:true,
				pageSize:10,
				striped:true,
				singleSelect:true,
				columns:[[
					{field:'ck',checkbox:true },
					{field:'id',title:'ID',align:'center'},
					{field:'name',title:'名称',align:'center'},
					{field:'remark',title:'描述',align:'center'},
					{field:'createBy',title:'创建人',align:'center',
						formatter:function(value,row,index){
							if(value != null){
								return value.username;
							}
						}	
					},
					{field:'createDate',title:'创建时间',align:'center'},
					{field:'updateBy',title:'修改人',align:'center',
						formatter:function(value,row,index){
							if(value != null){
								return value.username;
							}
						}
					},
					{field:'updateDate',title:'修改时间',align:'center'}
				]],
				selectOnCheck: true,
				checkOnSelect: true,
				onSelect: function (rowIndex, rowData) {
	               $("#selectedId").val(rowData.id);
	               $("#selectedName").val(rowData.name);
		        },
				onLoadSuccess:function(data){
					if(data){
						$.each(data.rows, function(index, item){
							var selId = $("#selectedId").val();
							if(item.id==selId){
								$('#dataGrid').datagrid('checkRow', index);
							}
						});
					}
				}
			});
		});
	</script>
</div>
</body>
</html>