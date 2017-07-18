<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- css -->
<link href="${ctxIndex}/hrm/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/js/bootstrap/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/js/jBox/jbox.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/layout.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="${ctxIndex}/hrm/css/layout/custom.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/style.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/layout.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="${ctxIndex}/hrm/css/layout/custom.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/style.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/js/easyui/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/js/easyui/themes/icon.css" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/layout/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="${ctxIndex}/hrm/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- js -->
<script src="${ctxIndex}/hrm/js/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/jquery/jquery-migrate.min.js" type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/jquery/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/jquery/messages_zh.js"	type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/bootstrap/js/bootstrap.min.js"	type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/bootbox/bootbox.min.js"></script>
<script src="${ctxIndex}/hrm/js/echarts/echarts.min.js"></script>
<script src="${ctxIndex}/hrm/js/easyui/jquery.easyui.min.js" type="text/javascript" ></script>
<script src="${ctxIndex}/hrm/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" ></script>
<script src="${ctxIndex}/hrm/js/common/metronic.js" type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/common/jquery-dateFormat.min.js" type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/bootstrap/js/bootstrap-datetimepicker.min.js"	type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"	 type="text/javascript"></script>
<script src="${ctxIndex}/hrm/js/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>


<title>后台管理系统</title>
</head>
<body>
<div class="page-header">
	<div class="page-header-menu">
		<div class="container">
			<div class="hor-menu ">
				<ul class="nav navbar-nav" id="topMenu">
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/department/list">部门管理</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/job/list">岗位管理</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/employee/list">员工管理</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/notice/list">通知管理</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/document/list">文档管理</a>
					</li>
					<li class="menu-dropdown classic-menu-dropdown">
						<a data-hover="megamenu-dropdown" data-close-others="true" href="/HRM/a/user/list">用户管理</a>
					</li>
				</ul>
			</div>
			<div class="hor-menu" style="float:right;">
				<ul class="nav navbar-nav">		
					<li class="menu-dropdown classic-menu-dropdown">
						<a href="javascript:;" class="hover-initialized" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-mobile "><i class="icon-user"></i>系统管理员</span>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							</li>					
							<li>
								<a href="#" id="logoutId">
								<i class="icon-key" ></i> 退出 </a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>