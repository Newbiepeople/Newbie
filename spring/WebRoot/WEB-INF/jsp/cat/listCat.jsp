<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

		<table>
			<tr>
				<th>
					ID
				</th>
				<th>
					名称
				</th>
				<th>
					创建日期
				</th>
			</tr>
			<c:forEach items="${ catList }" var="cat">
				<tr>
					<td>
						${ cat.id }
					</td>
					<td>
						${ cat.name }
					</td>
					<td>
						${ cat.createdDate }
					</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>

