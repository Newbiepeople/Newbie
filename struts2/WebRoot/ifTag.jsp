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

<struts:fielderror></struts:fielderror>

<struts:form action="if">
	<struts:textfield name="name" label="姓名: "></struts:textfield>
	<struts:submit value=" 提交 "></struts:submit>
</struts:form>

<!-- 利用 request 参数判断 -->
<struts:if test="#parameters.name[0] == 'Kurt'">
	Hello, Kurt. 
</struts:if>
<struts:elseif test="#parameters.name[0] == 'Matt'">
	Hello, Matt. 
</struts:elseif>
<struts:else>
	Hello, Other Buddies. 
</struts:else>

<br/>

<!-- 利用 action 属性判断 -->
<struts:if test="name == 'Kurt'">
	Hello, Kurt. 
</struts:if>
<struts:elseif test="name == 'Matt'">
	Hello, Matt. 
</struts:elseif>
<struts:else>
	Hello, Other Buddies. 
</struts:else>

<br/>

<!-- 
<struts:set name="key" value="%{'You are welcome. '}"></struts:set>
<struts:property value="#key" /> <br/>
<struts:property value="%{#key}" /> <br/>
<struts:property value="key" /> <br/>
 -->


</body>
</html>
