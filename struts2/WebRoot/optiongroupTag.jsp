<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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

<struts:head theme="ajax" />

<style type="text/css">
body,td {
	font-size: 12px;
}
</style>
</head>

<body>

<%
	request.setAttribute("cityList", new ArrayList<String>() {
		{
			add("北京");
			add("上海");
			add("天津");
			add("重庆");
		}
	});

	Map provinceMap = new HashMap();

	provinceMap.put("山东", new HashMap() {
		{
			put("济南", "济南");
			put("青岛", "青岛");
			put("烟台", "烟台");
			put("淄博", "淄博");
			put("潍坊", "潍坊");
		}
	});
	provinceMap.put("河北", new HashMap<String, String>() {
		{
			put("石家庄", "石家庄");
			put("唐山", "唐山");
			put("沧州", "沧州");
			put("邯郸", "邯郸");
		}
	});

	request.setAttribute("provinceMap", provinceMap);
%>


<struts:form action="login">

	<struts:select name="city" list="#request.cityList" label="请选择城市">

		<struts:iterator value="#request.provinceMap">
			<!--注意：optgroup 的 list 属性不接受 List 对象 -->
			<struts:optgroup label="%{key}" list="%{value}" />
		</struts:iterator>

	</struts:select>
</struts:form>

</body>
</html>
