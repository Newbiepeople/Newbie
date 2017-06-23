<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

<s:bean id="date" name="java.util.Date" />

<s:if test="%{#request.status == 'success'}">

	欢迎您, <s:property value="#session.username" />. 登录时间：<s:date name="%{#date}" />. 
	
	<s:url action="divLogin!logout" id="divLogoutUrl"></s:url>
	<s:a href="%{#divLogoutUrl}" theme="ajax" executeScripts="true">注销</s:a>

	<script>	
		document.getElementById('errorDiv').innerHTML = '';
		document.getElementById('loginDiv').style.display = 'none';
		document.getElementById('loginSuccessDiv').style.display = '';
	</script>
	
</s:if>
<s:elseif test="%{#request.status == 'failed'}">
	<script>	
		document.getElementById('errorDiv').innerHTML = "登录失败. 错误的用户名密码. ";
	</script>
</s:elseif>
<s:else>
	<script>
		document.getElementById('loginDiv').style.display = '';
		document.getElementById('loginSuccessDiv').innerHTML = '';
		document.getElementById('loginSuccessDiv').style.display = 'none';
	</script>
</s:else>

</body>
</html>