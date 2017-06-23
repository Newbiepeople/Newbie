<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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


<struts:text name="struts.messages.error.uploading" /> <br />

<struts:i18n name="otherResources">
	<struts:text name="hello.world"></struts:text>
</struts:i18n> <br/>

<hr />

<struts:text name="none.resource">没有资源，显示标签体内的字符串。</struts:text> <br/>
<struts:text name="没有资源，也没有标签体内容，则显示name属性" /> <br/>

<hr />

<struts:property value="%{getText('struts.messages.error.uploading')}" />

</body>
</html>
