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
					<a href="javascript:void(0);">员工管理</a> 
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty employee.id}">新增员工</c:when>
						<c:otherwise>修改员工信息</c:otherwise>
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
							<c:when test="${empty employee.id}">新增员工</c:when>
							<c:otherwise>修改员工信息</c:otherwise>
						</c:choose>
					</div>
					<div class="tools">
						<button type="button" class="btn blue btn-xs btn_return" onclick="history.go(-1)">返回</button>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="employeeForm" action="${ctx}/employee/save" method="post" class="form-horizontal">
						<input type="hidden" name="id" value="${employee.id}"/>
						<input type="hidden" name="hideCardId" value="${employee.cardId}"/>
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-1" for="name">
									姓名<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="name" name="name" value="${employee.name}" placeholder="名称"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="sex">
									性别<span class="required" aria-required="true">*</span>
								</label>
								<label class="control-label checkbox-inline ">
									<input type="radio" name="sex" value="0" <c:if test="${employee.sex == 0 || employee.sex == null}">checked</c:if> >男
								</label>
								<label class="control-label checkbox-inline">
									<input type="radio" name="sex" value="1" <c:if test="${employee.sex == 1}">checked</c:if> >女
								</label>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="cardId">
									身份证号<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="cardId" name="cardId" value="${employee.cardId}" placeholder="身份证号"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="provinceCode">
									籍贯<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<select class="form-control" name="provinceCode" id="provinceCode" placeholder="省份">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="provinceCode">
								</label>
								<div class="col-md-3">
									<select class="form-control" name="address" id="cityCode" placeholder="城市">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="birthday">
									生日<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-6">
									<input class="datetimepicker dateformat" style="height: 28px" type="text" readonly="readonly" value="${employee.birthday}" name="birthday" id="birthday">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="phone">
									手机号<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="phone" name="phone" value="${employee.phone}" placeholder="手机号"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="email">
									邮箱<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="email" name="email" value="${employee.email}" placeholder="邮箱"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="party">
									政治身份
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" id="party" name="party" value="${employee.party}" placeholder="政治身份"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="race">
									民族<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<select class="form-control" name="race" id="race">
										<option value="0" selected="selected">汉族</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="edcation">
									最高学历<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<select class="form-control" name="edcation" id="edcation">
										<option value="本科" <c:if test="${employee.edcation == '本科' }">selected='selected'</c:if>>本科</option>
										<option value="硕士" <c:if test="${employee.edcation == '硕士' }">selected='selected'</c:if>>硕士</option>
										<option value="博士" <c:if test="${employee.edcation == '博士' }">selected='selected'</c:if>>博士</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<input  type="hidden" value="${employee.department.id}" name="department.id" id="departmentId" >
								<label class="control-label col-md-1" for="deparment">
									部门<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control" id="departmentName" name="department.name" value="${employee.department.name}" placeholder="部门" readonly="readonly"/>
								</div>
								<div class="col-md-1" style="margin-left:1px 0px;padding:1px 0px;">
									<button type="button" class="btn btn-sm blue margin-bottom" id ="deptBtn"><i class="fa fa-search"></i></button>
								</div>
							</div>
							
							<div class="form-group">
								<input  type="hidden" value="${employee.job.id}" name="job.id" id="jobId" >
								<label class="control-label col-md-1" for="job">
									职位<span class="required" aria-required="true">*</span>
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control" id="jobName" name="job.name" value="${employee.job.name}" placeholder="职位" readonly="readonly"/>
								</div>
								<div class="col-md-1" style="margin-left:1px 0px;padding:1px 0px;">
									<button type="button" class="btn btn-sm blue margin-bottom" id ="jobBtn"><i class="fa fa-search"></i></button>
								</div>
							</div>
							<div class="form-group" name="createByField">
								<label class="control-label col-md-1" for="createBy">
									创建者
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull" disabled="disabled" id="createBy" name="createBy" value="${employee.createBy.username}"/>
								</div>
							</div>
							<div class="form-group" name="createDateField">
								<label class="control-label col-md-1" for="createDate">
									创建时间
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control notnull dateformat" disabled="disabled" id="createDate" name="createDate" value="${employee.createDate}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-1" for="remark">备注</label>
								<div class="col-md-3">
									<textarea class="form-control" id="remark" name="remark">${employee.remark}</textarea>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-1 col-md-9">
									<button type="button" class="btn default return" onclick="location.href ='${ctx}/employee/list'">取消</button>
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

//表单校验
var initFormValidate = function(){
	$("#employeeForm").validate({
		rules:{
			name:{
				required:true
			},
			sex:{
				required:true
			},
			cardId:{
				required:true
			},
			provinceCode:{
				required:true
			},
			cityCode:{
				required:true
			},
			birthday:{
				required:true
			},
			phone:{
				required:true,
				isPhone:true
			},
			email:{
				required:true,
				email:true
			},
			race:{
				required:true
			},
			edcation:{
				required:true
			}
		},
		messages:{
		 	name:{
		 		required:"员工姓名不能为空"
		 	}
		},
		submitHandler:function(form){
			//使用ajax提交数据
			//获取所有的表单数据进行提交
			$.post($(form).attr('action'),$(form).serialize(),'json')
			.done(function(data){
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
		if('${empty employee.id}' == 'true'){
			$('div[name="createByField"]').hide();
			$('div[name="createDateField"]').hide();
		}
	},
	initDateTimePickerEvent: function(){
		$(".datetimepicker").datetimepicker({
			format: 'yyyy-mm-dd',
			autoclose:true,
			todayBtn: true,
			todayHighlight: true,
			startView:3,
			minView:2
		});
	},
	
	initDateFormat:function(){
		if($('.dateformat').val() != ""){
			$('.dateformat').val($.format.date($('.dateformat').val(),'yyyy-MM-dd'));
		}
	},
	
	initValidateMethod:function(){
		jQuery.validator.addMethod("isPhone", function(value, element) {
			var length = value.length;
			var mobile =  /^1[34578]\d{9}$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请正确填写您的手机号码");
		jQuery.validator.addMethod("isMail", function(value, element) {
			var length = value.length;
			var mobile =  /^1[34578]\d{9}$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请正确填写您的手机号码");
		
	},
	//获取省份信息
	initProvince:function(){
		$.ajax({
			url:"${ctx}/dicregion/getProvince",
			type:'post',
			dataType:'json',
			success:function(data){
				if(data != null){
					//设置Province
					$("#provinceCode").empty();
					$("#provinceCode").append("<option value=''></option>");
					var address = '${employee.address}';
					address = address.substr(0,2)+"0000";
					$.each(data,function(index,item){
						var province = item;
						if(address == province.code){
							$("#provinceCode").append("<option value='"+province.code+"' selected='selected'>"+province.name+"</option>");
							$.ajax({
								url:'${ctx}/dicregion/getCity',
								data:{provinceCode : province.code},
								type:'post',
								success:function(data){
									$("#cityCode").empty();
									$.each(data,function(index,item){
										var city = item;
										if(city.cityCode == '${employee.address}')
											$("#cityCode").append("<option value='"+city.cityCode+"' selected='selected'>"+city.cityName+"</option>");
										else
											$("#cityCode").append("<option value='"+city.cityCode+"'>"+city.cityName+"</option>");
									});
								}
							});
						}
						$("#provinceCode").append("<option value='"+province.code+"'>"+province.name+"</option>");
					});
				}
			}
		})
	},
	//初始化民族
	initRace:function(){
		var raceMapper = '${raceMapper}';
		$("#race").empty();
		$.each(JSON.parse(raceMapper),function(index,item){
			if('${employee.race}' == item){
				$("#race").append("<option value='"+item+"' selected='selected'>"+item+"</option>");
			}else{
				$("#race").append("<option value='"+item+"'>"+item+"</option>");
			}
			
		});
	},
	
	//级联更新
	provinceChangeEvent:function(){
		$("#provinceCode").change(function(){
			var provinceCode = $("#provinceCode option:selected").val();
			$.ajax({
				url:'${ctx}/dicregion/getCity',
				data:{provinceCode : provinceCode},
				type:'post',
				success:function(data){
					$("#cityCode").empty();
					$.each(data,function(index,item){
						var city = item;
						$("#cityCode").append("<option value='"+city.cityCode+"'>"+city.cityName+"</option>");
					});
				}
			})
		});
	},
	
	//初始化按钮
	initJobBtn:function(){
		$("#jobBtn").bind("click",function(){
			var selId = $("#jobId").val();
			$.jBox.open("iframe:${ctx}/job/lookup?selId=" + selId,"选择职位", 800, 420, {
				buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
					if (v=="ok"){
						var doc = h.find("iframe")[0].contentWindow.document;
						var inputs = $(doc).find("input[type='hidden']");
	    				$("#jobId").val(inputs[0].value);
						$("#jobName").val(inputs[1].value);
						return;
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			}); 
		});
	},
	
	//初始化部门按钮
	initDeptBtn:function(){
		$("#deptBtn").bind("click",function(){
			var selId = $("#departmentId").val();
			$.jBox.open("iframe:${ctx}/department/lookup?selId=" + selId,"选择部门", 800, 420, {
				buttons:{"确定":"ok","关闭":true}, submit:function(v, h, f){
					if (v=="ok"){
						var doc = h.find("iframe")[0].contentWindow.document;
						var inputs = $(doc).find("input[type='hidden']");
	    				$("#departmentId").val(inputs[0].value);
						$("#departmentName").val(inputs[1].value);
						return;
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			}); 
		});
	}
	
};
jQuery(document).ready(function(){
	pageEvent.initPageEvent();
	pageEvent.initDateTimePickerEvent();
	pageEvent.initDateFormat();
	pageEvent.initProvince();
	pageEvent.initRace();
	pageEvent.initValidateMethod();
	pageEvent.provinceChangeEvent();
	pageEvent.initJobBtn();
	pageEvent.initDeptBtn();
	initFormValidate();
});
</script>
</body>
</html>