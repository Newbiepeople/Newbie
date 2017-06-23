<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Enter first and last name</title>
<s:head theme="ajax" debug="false" />
</head>
<body>

<!-- 清空 session 的计数器 -->
<s:set name="clear" value="%{#session.updatedTimes = 0}"></s:set>

<!-- 要显示页面的 URL -->
<s:url id="news" action="divNews" />

<!-- indicator -->
<span id="indicator" style="background: #FFF000; padding: 4px;">
	正在刷新 <s:property value="#news" /> ...
</span>

<!-- div标签 显示一个页面  每隔5秒钟刷新一次 -->
<s:div theme="ajax" href="%{news}" showLoadingText="false"
	updateFreq="5000" indicator="indicator" />

<!-- Ajax查询表单 -->
<s:form name="newsActionForm" id="newsActionForm">
	<s:textfield name="key" label="关键词" />
	<s:submit value="查询新闻" href="%{news}" formId="newsActionForm"
		theme="ajax" targets="divNewsSearch" />
</s:form>

<!-- 查询结果显示在这里 -->
<div id="divNewsSearch"></div>

</body>
</html>
