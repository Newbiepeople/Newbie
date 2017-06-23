<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Enter first and last name</title>
<s:head theme="ajax" debug="false" />
<style type="text/css">
div,body,td,span {
	font-size: 12px;
}
form {
	padding: 0px; 
	margin: 0px; 
}
.div {
	padding: 10px;
	width: 320px;
	background-color: #E5E5E5;
}

#errorDiv {
	color: red;
	text-align: center;
	font-weight: bold; 
}
</style>
</head>
<body>

<div class="div" id="loginDiv">
	<div id="errorDiv"></div>
	<s:form name="divLoginForm" id="divLoginForm">
		<s:label label="请输入用户名密码"></s:label>
		<s:textfield name="username" label="帐号" value="helloween" />
		<s:password name="password" label="密码" value="1234" title="1234" />
	
		<s:url action="divLogin!login" id="divLoginUrl"></s:url>
		<s:submit value=" 登 录 " formId="divLoginForm" theme="ajax"
			href="%{divLoginUrl}" targets="loginSuccessDiv" executeScripts="true" />
	</s:form>
</div>

<div id="loginSuccessDiv" class="div" style="display: none;"></div>

</body>
</html>






