<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
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
<struts:head theme="simple" />
<style type="text/css">
body,td {
	font-size: 12px;
}
</style>
</head>

<body>
	<hr />
		所有的ID：<struts:property value="#parameters.id"/> <br/>
		第一个ID：<struts:property value="#parameters.id[0]"/> <br/>
		request 中取属性：<struts:property value="#request.account"/> <br/>
		session 中取属性：<struts:property value="#session.account"/> <br/>
		application 中取属性：<struts:property value="#application.account"/> <br/>
		attr 中取属性：<struts:property value="#attr.account"/> <br/>
	<hr />
		价格大于18元的杂志共有 <struts:property value="magazineList.{?#this.price>18}.size()" /> 本，分别是：<br/>
		<struts:iterator value="magazineList.{?#this.price>18}">
			<struts:property value="name" /> - ￥<struts:property value="price" />. <br/>
		</struts:iterator>
	<hr />
		名称包含“时代”二字的杂志共有 <struts:property value="magazineList.{?#this.name.contains('时代')}.size()"/> 本，分别是：<br/>
		<struts:iterator value="magazineList.{?#this.name.contains('时代')}">
			<struts:property value="name" /> - ￥<struts:property value="price" />. <br/>
		</struts:iterator>
	<hr />
		“足球之夜”的价格为 ￥<struts:property value="magazineList.{?#this.name.contains('足球之夜')}[0].price"/>。
	<hr />
		
		<!-- 
		<struts:form>
			<struts:label label="#request.account"></struts:label>
			<struts:label label="%{#request.account}"></struts:label>
		</struts:form>
		 -->
	
	
</body>
</html>
