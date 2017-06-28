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
a {
	color: blue;
}
a:hover {
	color: red; 
}
</style>
</head>
<body>

${ param.action == 'initAdd' ? '添加 Cat 资料' : '修改 Cat 资料' } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ <a href="catServlet?action=initAdd">添加 Cat</a> ][ <a href="catServlet?action=list">Cat 列表</a> ]
<form action="catServlet" method="post">
<input type="hidden" name="action" value="${ param.action == 'initAdd' ? 'add' : 'save' }">
<input type="hidden" name="id" value="${ cat.id }">
<table>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="name" value="${ cat.name }"/></td>
	</tr>
	<tr>
		<td>Mother:</td>
		<td><select name="motherId">
			<option value="0">---请选择---</option>
			<%
				@SuppressWarnings("unchecked")
				List<Cat> catList = (List<Cat>) request.getAttribute("catList");
		
				for (Cat cat : catList) {
					out.write("	<option value=" + cat.getId() + ">");
					
					String name = cat.getName();
					Cat mother = cat.getMother();
					while(mother != null){
						name = mother.getName() + " / " + name;
						mother = mother.getMother();
					}
					out.write("" + name + "");
					out.write("</option>");
				}
			%>
		</select>
		<script type="text/javascript">document.getElementsByName('motherId')[0].value = '${ 0 + cat.mother.id }'; </script>
		</td>
	</tr>
	<tr>
		<td>Description:</td>
		<td><textarea name="description">${ cat.description }</textarea></td>
	</tr>
	<tr>
		<td></td>
		<td><input type=submit value="${ param.action == 'initAdd' ? ' 提交 ' : ' 保存 ' }" /></td>
	</tr>
</table>
</form>

</body>
</html>