<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

<html>
	<head>
		<title>JSP for CatForm form</title>
		<style type="text/css">
		body, td, th, input {font-size: 12px; }
		table {border-collapse: collapse; border: 1px solid #000000; }
		th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
		</style>
	</head>
	<body>
		<html:form action="/cat">
			<input type="hidden" name="action" value="add" />
			<html:text property="name" />
			<html:submit value="添加" />
		</html:form>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>CreateDate</th>
			</tr>
			<logic:iterate id="cat" name="catList">
				<tr>
					<td><bean:write name="cat" property="id" /></td>
					<td><bean:write name="cat" property="name" /></td>
					<td><bean:write name="cat" property="createdDate" format="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</logic:iterate>
		</table>
		
	</body>
</html>

