<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h1>搜索引擎系统</h1>
	<%-- <shiro:hasRole name="admin">
		<h2>管理员</h2>
	</shiro:hasRole>
	<shiro:hasPermission name="查询">
		<h2>查询</h2>
	</shiro:hasPermission> --%>
	
	<a href="http://127.0.0.1:8080/zzcms/shiro-cas">cms发布系统</a>
	
	<a href="http://127.0.0.1:8082/InteractionSystem/shiro-cas">互动交流</a>
	
	<a href="http://127.0.0.1:8083/SearchEngine/shiro-cas">搜索引擎系统</a>
	
	<a href="http://127.0.0.1:8083/SearchEngine/logout">单点登出</a>
</body>
</html>