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
					<a href="javascript:void(0);">岗位管理</a> 
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty job.id}">新增岗位</c:when>
						<c:otherwise>修改岗位信息</c:otherwise>
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
						  <c:when test="${empty job.id}">新增岗位</c:when>
						  <c:otherwise>修改岗位信息</c:otherwise>
						</c:choose>
					</div>
					<div class="tools">
						<button type="button" class="btn blue btn-xs btn_return" onclick="history.go(-1)">返回</button>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="jobForm" action="${ctx}/job/save" method="post" class="form-horizontal">
						<input type="hidden" name="id" value="${job.id}"/>
						<input type="hidden" name="hideName" value="${job.name}"/>
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-1" for="name">
									名称<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="name" name="name" value="${job.name}" placeholder="名称"/>
								</div>
							</div>
							<div class="form-group" name="createByField">
								<label class="control-label col-md-1" for="createBy">
									创建者
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" disabled="disabled" id="createBy" name="createBy" value="${job.createBy.username}"/>
								</div>
							</div>
							<div class="form-group" name="createDateField">
								<label class="control-label col-md-1" for="createDate">
									创建时间
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull dateformat" disabled="disabled" id="createDate" name="createDate" value="${job.createDate}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="remark">备注</label>
								<div class="col-md-3">
									<textarea class="form-control" id="remark" name="remark">${job.remark}</textarea>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-1 col-md-9">
									<button type="button" class="btn default return" onclick="location.href ='${ctx}/job/list'">取消</button>
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
	$("#jobForm").validate({
		rules:{
			name:{
				required:true,
			}
		},
		messages:{
		 	name:{
		 		required:"岗位名称不能为空",
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
 						$('.btn_return').trigger("click");
                	});
				}else{
					bootbox.alert(message);
				}
			});
		}
	});
}	


var pageEvent = {
	initPageEvent:function(){
		//新建时隐藏 创建时间和创建者 文本框
		if('${empty job.id}' == 'true'){
			$('div[name="createByField"]').hide();
			$('div[name="createDateField"]').hide();
		}
	},
	dateFormat:function(){
		if($('.dateformat').val() != ""){
			$('.dateformat').val($.format.date($('.dateformat').val(),'yyyy-MM-dd HH:mm:ss'));
		}
	}
};
jQuery(document).ready(function(){
	//Metronic.init();
	pageEvent.initPageEvent();
	pageEvent.dateFormat();
	initFormValidate();
});
</script>
</body>
</html>