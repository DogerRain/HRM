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
					<a href="javascript:void(0);">用户管理</a> 
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty user.id}">新增用户</c:when>
						<c:otherwise>修改用户信息</c:otherwise>
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
						  <c:when test="${empty user.id}">新增用户</c:when>
						  <c:otherwise>修改用户信息</c:otherwise>
						</c:choose>
					</div>
					<div class="tools">
						<button type="button" class="btn blue btn-xs btn_return" onclick="history.go(-1)">返回</button>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="userForm" action="${ctx}/user/save" method="post" class="form-horizontal">
						<input type="hidden" name="id" value="${user.id}"/>
						<input type="hidden" name="hideName" value="${user.loginname}"/>
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-1" for="loginname">
									登陆名<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="loginname" name="loginname" value="${user.loginname}" placeholder="登陆名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="username">
									用户名<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="username" name="username" value="${user.username}" placeholder="用户名"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="password">
									密码<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="password" class="form-control notnull" id="password" name="password" value="${user.password}" placeholder="密码"/>
								</div>
							</div>
							<div class="form-group" name="createDateField">
								<label class="control-label col-md-1" for="createDate">
									创建时间
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull dateformat" disabled="disabled" id="createDate" name="createDate" value="${user.createDate}"/>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-1 col-md-9">
									<button type="button" class="btn default return" onclick="location.href ='${ctx}/user'">取消</button>
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
	$("#userForm").validate({
		rules:{
			loginname:{
				required:true
			},
			username:{
				required:true
			},
			password:{
				required:true
			}
		},
		messages:{
		 	loginname:{
		 		required:"登陆名称不能为空"
		 	},
		 	username:{
		 		required:"用户名称不能为空"
		 	},
		 	password:{
		 		required:"密码不能为空"
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


var pageEvent = {
	initPageEvent:function(){
		//新建时隐藏 创建时间和创建者 文本框
		if('${empty user.id}' == 'true'){
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