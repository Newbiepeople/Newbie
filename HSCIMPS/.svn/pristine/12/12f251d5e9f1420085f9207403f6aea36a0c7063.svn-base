<%@page import="nwnu.info.hsc.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>聊天室</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">

	window.setInterval("showContent();", 1000);
	window.setInterval("showOnline();", 10000);

	var sysBBS = "<span style='font-size:14px; line-height:30px;'>欢迎光临聊天室，请遵守聊天室规则。</span><br><span style='line-height:22px;'>";
	//此处需要加?nocache="+new Date().getTime()，否则将出现在线人员列表不更新的情况
	function showOnline() {
		var loader = new net.AjaxRequest("ChatServlet?action=online&nocache=" + new Date().getTime(), deal_online, "GET");
	}
	function showContent() {
		var loader1 = new net.AjaxRequest("ChatServlet?action=getMessages&nocache=" + new Date().getTime(), deal_content, "GET");
	}
	
	function deal_online() {
		online.innerHTML = this.req.responseText;
	}
	function onerror() {
		alert("很抱歉，服务器出现错误，当前窗口将关闭！");
		window.opener = null;
		window.close();
	}
	function deal_content() {
		var returnValue = this.req.responseText; //获取Ajax处理页的返回值
		var h = returnValue.replace(/\s/g, ""); //去除字符串中的Unicode空白符
		if (h == "error") {
			alert("您的账户已经过期，请重新登录！");
			Exit();
		} else {
			content.innerHTML = sysBBS + returnValue + "</span>";
			document.getElementById('content').scrollTop = document.getElementById('content').scrollHeight * 2; 
			//当聊天信息超过一屏时，设置最先发送的聊天信息不显示
		}
	}

	window.onload = function() {
		showContent(); //当页面载入后显示聊天内容
		showOnline(); //当页面载入后显示在线人员列表				
	}

	window.onbeforeunload = function() { //当用户单击浏览器中的关闭按钮时执行退出操作
		if (event.clientY<0 && event.clientX>document.body.scrollWidth) {
			Exit(); //执行退出操作
		}
	}
</script>
<script language="javascript">
	function send() { //验证聊天信息并发送
		if (form1.to.value == "") {
			alert("请选择聊天对象！");
			return false;
		}
		if (form1.content1.value == "") {
			alert("发送信息不可以为空！");
			form1.content1.focus();
			return false;
		}
		var param = "from=" + form1.from.value + "&to=" + form1.to.value + "&content=" + form1.content1.value;
		var loader = new net.AjaxRequest("ChatServlet?action=sendMessage", deal_send, onerror, "POST", param);
	}
	
	function deal_send() {
		content.innerHTML = sysBBS + this.req.responseText + "</span>";
	}

//	function dec() { //解密+++++++++++++++++++
//		var param = "from=" + form1.from.value +  "&to=" + form1.to.value;
//		var loader = new net.AjaxRequest("ChatServlet?action=decMessages",	deal_send, onerror, "POST", param);
//	}
//	function deal_dec() {
//		content2.innerHTML = sysBBS + this.req.responseText + "</span>";
//	}

</script>
<script language="javascript">
	function set(selectPerson) { //自动添加聊天对象
		if (selectPerson != "${user.username}") {
			form1.to.value = selectPerson;
		} else {
			alert("请重新选择聊天对象！");
		}
	}
</script>
<script type="text/javascript">
	function checkScrollScreen() {
		if (!form1.scrollScreen.checked) {
			document.getElementById("content").style.overflow = 'scroll';
			//document.getElementById("content2").style.overflow = 'scroll';
		} else {
			document.getElementById("content").style.overflow = 'hidden';
			//document.getElementById("content2").style.overflow = 'hidden';
			//当聊天信息超过一屏时，设置最先发送的聊天信息不显示
			document.getElementById('content').scrollTop = document.getElementById('content').scrollHeight * 2;
			//document.getElementById('content2').scrollTop = document.getElementById('content2').scrollHeight * 2;
		}
		setTimeout('checkScrollScreen()', 500);
	}
</script>
</head>
<body>
	<div align="center">
	<table style="width:100%;height:500px;border:0;cellpadding:0;cellspacing:0;" >
		<tr>
			<td width="300px" valign="top" background="images/online.jpg" bgcolor="#f6fded" id="online" style="padding:5px">
				在线人员列表
			</td>
			<c:if test="${type==1}">
				<td width="600px" valign="top" background="images/main_bj.jpg"	bgcolor="#FFFFFF" style="padding:5px; ">
					<div style="height:500px; overflow:hidden" id="content">聊天内容</div>
				</td>
			</c:if>
			<c:if test="${type==2}">
			<td width="600px" valign="top" background="images/main_bj.jpg"	bgcolor="#FFFFFF" style="padding:5px;">
				<div style="height:30px; overflow:hidden;font-size:30px;text-align:center;">您的消息</div>
				<ul style='list-style-type:none;font-size:25px;'>
					<li>${target}</li>
					<li><a href="ChatServlet?action=main&type=1" id="back">返回</a></li>
				</ul>
			</td>
			</c:if>
		</tr>
	</table>
	<form action="" name="form1" method="post">
		<table background="images/bottom.jpg" style="width:100%;height:100px;border:0;cellpadding:0;cellspacing:0; bordercolor:#D6D3CE;">
			<tr>
				<td width="5%" height="50px" align="left">&nbsp;</td>
				<td width="90%"align="left">
					<table border="0" width="100%">
						<tr>
							<td><input name="from" type="hidden" value="${user.username}">[${user.username}]对</td>
							<td><input name="to" type="text" value="" size="20px" style="height:30px;" readonly="readonly" id="text">说：</td>
							<td><input name="content1" id="text" type="text" size="120px" style="height:30px;" onKeyDown="if(event.keyCode==13 && event.ctrlKey){send();}"></td>
							<td><input name="Submit2" type="button" class="btn_send" value=" 发  送 " onClick="send()"></td>
							<td width="19" align="left"><input name="scrollScreen"	type="checkbox" class="noborder" id="scrollScreen"	onClick="checkScrollScreen()" value="1" checked></td>
						</tr>
					</table>
				</td>
				<td width="5%" height="50px" align="right">&nbsp;</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
