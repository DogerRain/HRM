<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ include file="/WEB-INF/view/include/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>人事管理系统</title>
<meta http-equiv="Content-type" content="text/html;charset=utf-8">
<link href="${ctxIndex}/hrm/css/login/login.css" rel="stylesheet" type="text/css">
</head>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form id="loginForm" class="form-horizontal" action="${ctx}/login" method="post">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" 
                    		name="username" placeholder="用户名" autocomplete="off">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password"
                    	name="password" autocomplete="off" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default" >登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
     $(document).ready(function(){
    	$("#loginForm").validate(); 
     });
     $.validator.setDefaults({
    	 submitHandler:function(){
    		 alert("submit");
    	}
     });
//表单校验
function LoginFormSubmit(){
	var username = $("#username").val();
	var password = $("#password").val();
	if(username==''||password==''){
		alert("用户名或密码不能为空");
	}
	$("#loginForm").submit();
	
}

</script>
</body>
</html>