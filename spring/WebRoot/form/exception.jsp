<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true" %>

<html>
	<head>
		<title>JSP for CatForm form</title>
		<style>
		body, input {font-size: 12px; }
		</style>
	</head>
	<body> 
		发生错误，原因： 
		${ requestScope['org.apache.struts.action.EXCEPTION'].message }
		<input type="button" value="返回" onclick="history.go(-1); " />
	</body>
</html>

