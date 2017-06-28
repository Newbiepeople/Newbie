<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="com.helloweenvsfei.hibernate.bean.Cat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body,div,td,th {
	font-size: 12px;
}
table {
	border-collapse: collapse;
	border: 1px solid #000000;
}
th,td {
	border: 1px solid #000000;
	padding: 2px;
	padding-left: 5px;
	padding-right: 5px;
}
a {
	color: blue;
}
a:hover {
	color: red; 
}
</style>
</head>
<body>

查看 Cat 资料 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ <a href="catServlet?action=initAdd">添加 Cat</a> ][ <a href="catServlet?action=list">Cat 列表</a> ]
<table>
	<tr>
		<td>Name:</td>
		<td>${ cat.name }</td>
	</tr>
	<tr>
		<td>Mother:</td>
		<td>${ cat.mother.name }
		</td>
	</tr>
	<tr>
		<td>Description:</td>
		<td>${ cat.description }</td>
	</tr>
	<tr>
		<td>Create Date:</td>
		<td>${ cat.createDate }</td>
	</tr>
</table>

</body>
</html>