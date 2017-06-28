<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.helloweenvsfei.hibernate.bean.Cat"%>
<%@page import="java.util.List"%>
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
h4{
	color:red;
}
</style>
</head>
<body>

<h4>${ msg }</h4>

所有 Cat 列表 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[
<a href="catServlet?action=initAdd">添加 Cat</a>
][
<a href="catServlet?action=list">Cat 列表</a>
]
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Mother</th>
		<th>Operation</th>
	</tr>
	<%
		@SuppressWarnings("unchecked")
		List<Cat> catList = (List<Cat>) request.getAttribute("catList");

		for (Cat cat : catList) {
			out.write("<tr>");
			out.write("	<td>" + cat.getId() + "</td>");
			out.write("	<td>" + cat.getName() + "</td>");
			out.write("	<td>" + cat.getDescription() + "</td>");
			
			String motherString = "";
			Cat mother = cat.getMother();
			while(mother != null){
				if(motherString.trim().length() == 0)
					motherString = mother.getName();
				else
					motherString = mother.getName() + " / " + motherString;
				mother = mother.getMother();
			}
			out.write("	<td>" + motherString + "</td>");
			out.write("	<td>");
			out.write("		<a href=catServlet?action=delete&id=" + cat.getId() + " onclick=\"return confirm('确定删除？'); \">删除</a>");
			out.write("		<a href=catServlet?action=edit&id=" + cat.getId() + ">修改</a>");
			out.write("</td>");
			out.write("</tr>");
		}
	%>
</table>

</body>
</html>