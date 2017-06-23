<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>异构签密即时通信系统</title>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script type="text/javascript">
	//结构
	function init() {
		var left = document.getElementById('table');
		left.style.height = (document.body.clientHeight) + 'px';
	}
	window.addEvent('domready', function() {
	var imageTips = new Tips($$('.tips'),{
	       showDelay : 100,
	       hideDelay : 100
	       });
		new Tips($$('.header1'), {
			showDelay : 100,
			hideDelay : 100,
			fixed : true
		});
	});
	//退出
	function loginOut() {
		if (confirm("您确定要退出吗？")) 
			top.location = "login.jsp";
		
		return false;
	};
	function refresh() {
		window.location.reload();
	};
</script>
<base target="mainFrame">
</head>
<body>
	<!-- 顶部状态栏 -->
	<div>
		<div class="top">
			<div class="title">异构签密即时通信系统管理平台</div>
			<ul class="sys-nav">
				<li class="firstLi">&nbsp;</li>
				<li><a onclick="refresh();">首页</a></li>
				<li class="haslist"><a>${user.username}</a></li>
				<li><i class="logout"></i><a href="javascript:loginOut();">退出</a>
				</li>
				<li class="lastLi">&nbsp;</li>
			</ul>
		</div>

		<!-- 左侧功能栏 -->
		<div onload="init();">
			<table id="table" border="0" width="100%">
				<tr>
					<td class="leftTD" width="15%">
						<div class="list">
							<ul class="yiji">
								<li><a class="inactive">个人中心</a>
									<ul>
										<li><a href="UserServlet?action=pwdChange">修改密码</a>
										</li>
										<li><a href="UserServlet?action=view">个人中心</a></li>
										<li><a href="UserServlet?action=edit">修改信息</a></li>
									</ul>
								</li>
								<li><a class="inactive">用户管理</a>
									<ul>
										<li><a href="UserServlet?action=list">用户列表</a></li>
									</ul>
								</li>
								<li><a class="inactive">密码体制管理</a>
									<ul>
										<li><a href="CryptoServlet?action=list">密码体制列表</a>
										</li>
										<li><a href="CryptoServlet?action=edit&cryptoId=0">添加密码体制</a>
										</li>
									</ul></li>
							</ul>
						</div>
					</td>
					<td style="width:85%"><iframe name="mainFrame" id="mainFrame"
							src="ChatServlet?action=wel"></iframe>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
