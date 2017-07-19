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
					<a href="javascript:void(0);">文件管理</a> 
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty document.id}">新增文件</c:when>
						<c:otherwise>修改文件信息</c:otherwise>
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
						  <c:when test="${empty document.id}">新增文件</c:when>
						  <c:otherwise>修改文件信息</c:otherwise>
						</c:choose>
					</div>
					<div class="tools">
						<button type="button" class="btn blue btn-xs btn_return" onclick="history.go(-1)">返回</button>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="documentForm" action="${ctx}/doc/upload" method="post" enctype="multipart/form-data"  class="form-horizontal">
						<input type="hidden" name="id" value="${document.id}"/>
						<input type="hidden" name="hideTitle" value="${document.title}"/>
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-1" for="title">
									标题<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="title" name="title" value="${document.title}" placeholder="标题"/>
								</div>
							</div>
							<div class="form-group" name="uploadFile">
								<label class="control-label col-md-1" for="file">
								上传文件:<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input name="file" type="file" maxlength="200" class="form-control notnull required"  />
								</div>
							</div>
							<div class="form-group" name="createByField">
								<label class="control-label col-md-1" for="createBy">
									创建者
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" disabled="disabled" id="createBy" name="createBy" value="${document.createBy.username}"/>
								</div>
							</div>
							<div class="form-group" name="createDateField">
								<label class="control-label col-md-1" for="createDate">
									创建时间
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull dateformat" disabled="disabled" id="createDate" name="createDate" value="${document.createDate}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="remark">备注</label>
								<div class="col-md-3">
									<textarea class="form-control" id="remark" name="remark">${document.remark}</textarea>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-1 col-md-9">
									<button type="button" class="btn default return" onclick="location.href ='${ctx}/doc/list'">取消</button>
									<button type="submit" class="btn green save">提交</button>
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
	$("#documentForm").validate({
		rules:{
			title:{
				required:true,
			}
		},
		messages:{
		 	title:{
		 		required:"文档标题不能为空",
		 	}
		}
	});
}
		
	

var pageEvent = {
	initPageEvent:function(){
		//新建时隐藏 创建时间和创建者 文本框
		if('${empty document.id}' == 'true'){
			$('div[name="createByField"]').hide();
			$('div[name="createDateField"]').hide();
		}else{
			$("div[name='uploadFile']").hide();
		}
	},
	
	initSaveBtn:function(){
		//ajax提交表单
		$(".save").on("click",function(){
			$("#documentForm").ajaxSubmit({
				dataType:'json',
				type:'post',
				success:function(data){
					var success = data.success;
					var message = data.message;
					if(success == true){
						bootbox.alert(message, function() {
	 						$('.btn_return').trigger("click");
	                	});
					}else{
						bootbox.alert(message);
					}
				},
				error:function(data){
				}
			});
		});
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
	pageEvent.initSaveBtn();
	initFormValidate();
});
</script>
</body>
</html>


