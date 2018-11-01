<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--开启el表达式--%>
<%@ page  isELIgnored="false"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>404</title>
		<link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<body>
		
		<%-- <div class="header">
			<img src="${pageContext.request.contextPath}/images/a.jpg" />
		</div> --%>
		
		<p class="error">404</p>
		
		<div class="content">
			<h2>资源未找到</h2>
			
			<!-- <p class="text">
				检查参数，或者联系管理员
			</p> -->
				
			<p class="links">
				<a href="javascript:history.back(-1)">返回上一页</a>
			</p>
		</div>
		
	</body>
</html>