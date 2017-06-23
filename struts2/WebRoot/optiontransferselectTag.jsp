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
select {
	width: 120px; 
}
</style>
</head>

<body>
<%
	List<String> provinceSelected = new ArrayList<String>();

	provinceSelected.add("北京");
	provinceSelected.add("上海");
	provinceSelected.add("天津");
	provinceSelected.add("重庆");
	provinceSelected.add("河北");
	provinceSelected.add("河南");
	provinceSelected.add("山东");
	provinceSelected.add("山西");
	provinceSelected.add("江苏");
	provinceSelected.add("浙江");

	request.setAttribute("provinceSelected", provinceSelected);

	List<String> provinceUnselected = new ArrayList<String>();

	provinceUnselected.add("湖南");
	provinceUnselected.add("湖北");
	provinceUnselected.add("云南");
	provinceUnselected.add("广东");
	provinceUnselected.add("广西");

	request.setAttribute("provinceUnselected", provinceUnselected);
%>
<struts:form action="login">
	<struts:optiontransferselect name="province"
		doubleList="#request.provinceSelected"
		list="#request.provinceUnselected" doubleName="city" leftUpLabel="向上"
		leftDownLabel="向下" rightDownLabel="向下" rightUpLabel="向上"
		leftTitle="已经选中的省份" headerKey="" headerValue="---请选择省份---"
		rightTitle="剩余的省份" />
</struts:form>

</body>
</html>
