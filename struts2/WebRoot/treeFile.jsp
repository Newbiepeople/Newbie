<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.helloweenvsfei.struts2.bean.FileWrapper"%>
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

<%
	request.setAttribute("file", new FileWrapper(new File(getServletContext().getRealPath("WEB-INF"))));
%>

<s:set name="i" value="0"></s:set>

<s:tree id="root" theme="ajax" rootNode="%{#request.file}" nodeTitleProperty="file.name"
	nodeIdProperty="%{#i+1}" childCollectionProperty="children"  />

</body>
</html>