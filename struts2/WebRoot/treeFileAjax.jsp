<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.io.File"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Struts 2 AJAX - More Tree</title>
<s:head theme="ajax" debug="false" />
<style type="text/css">
body,div {
	font-size: 12px;
}
</style>
</head>
<body>
<h3>Ajax Tree Example</h3>

<%
	request.setAttribute("file", new File(getServletContext().getRealPath("")));
%>

<div dojoType="TreeRPCController" widgetId="treeController"
	DNDcontroller="create" RPCUrl="treeFileAjaxData.jsp"></div>
<div dojoType="Tree" widgetId="appFiles" toggle="fade"
	controller="treeController">
<div dojoType="TreeNode" title='<s:property value="#request.file.name" />'
	widgetId='<s:property value="#request.file.absolutePath" />'
	isFolder='<s:property value="#request.file.directory" />'
	objectId='<s:property value="#request.file.absolutePath" />'></div>
</div>

</body>
</html>