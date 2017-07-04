<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
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
					<a href="javascript:void(0);">部门管理</a> 
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty department.id}">新建部门</c:when>
						<c:otherwise>修改部门信息</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
		<div class="row">
		<div class="col-md-12">
			<div class="portlet light">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>
						<c:choose>
						  <c:when test="${empty department.id}">新建部门</c:when>
						  <c:otherwise>修改部门信息</c:otherwise>
						</c:choose>
					</div>
					<div class="tools">
						<button type="button" class="btn blue btn-xs btn_return" onclick="history.go(-1)">返回</button>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="departmentForm" action="${ctx}/department/save" method="post" class="form-horizontal">
						<input type="hidden" name="id" value="${department.id}"/>
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-1" for="name">
									名称<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="name" name="name" value="${department.name}" placeholder="名称"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="remark">备注</label>
								<div class="col-md-3">
									<textarea class="form-control" id="remark" name="remark">${department.remark}</textarea>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-1 col-md-9">
									<button type="button" class="btn default return" onclick="location.href ='${ctx}/department'">取消</button>
									<button type="submit" class="btn green">提交</button>
									<!-- 
									<shiro:hasPermission name="sys:role:edit">
										<button type="submit" class="btn green">提交</button>
									</shiro:hasPermission>
									 -->
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	 </div>
</div>
</div>
<script type="text/javascript">
var initFormValidate = function(){
	$("#departmentForm").validate({
		rules:{
			name:{
				required:true,
				minlength:3
			}
		},
		message:{
		 	name:{
		 		required:"部门名称不能为空",
		 		minlength:"部门名称至少三个字符"
		 	}
		},
		submitHandler:function(form){
			//使用ajax提交数据
			$.post($(form).attr('action'),$(form).serialize(),'json')
			.done(function(data){
		//		Metronic.stopPageLoading();
				var success = data.success;
				var message = data.message;
				if(success == true){
					bootbox.alert(message, function() {
 						$('.return').trigger("click");
                	});
				}else{
					bootbox.alert(message);
				}
			});
		}
	});
}	
jQuery(document).ready(function(){
	//Metronic.init();
	initFormValidate();
});
</script>
</body>
</html>