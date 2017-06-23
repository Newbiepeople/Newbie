<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<a
			href="javascript:window.open('upload/SunSet.jpg?' + new Date().getTime());"
			onclick="window.open('upload/SunSet.jpg?' + new Date().getTime()); return false;">新窗口打开图片</a>
		<br />
		<img src="upload/SunSet.jpg" name="imgTest" width="400" />
	</body>
</html>
