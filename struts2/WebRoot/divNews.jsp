<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Enter first and last name</title>
<s:head theme="ajax" debug="false" />
<style type="text/css">
div,body,td {
	font-size: 12px;
}
</style>
</head>
<body>
<%
Thread.sleep(1000);
%>
<div style="padding: 10px; width: 350px; background-color: #E5E5E5;">

	<s:iterator value="news">
		<s:property /> <br/>
	</s:iterator>

	<s:if test="%{key == ''}">
		<hr />
		<s:set name="updatedTimes" value="%{#session.updatedTimes + 1}"></s:set>
		<s:set name="update" value="%{#session.updatedTimes = #updatedTimes}"></s:set>
	
		第 <s:property value="#session.updatedTimes" /> 次更新, 
		<s:bean name="java.util.Date" id="date" /> 
		时间: <s:date name="date" format="yyyy-MM-dd HH:mm:ss" /></div>
	</s:if>

</body>
</html>
