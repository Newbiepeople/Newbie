<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript">    	
		//退出
    	function loginOut(){    		
			if (confirm("您确定要退出吗？")){
				window.location.href = "ChatServlet?action=leave";
				alert("欢迎您下次光临！");
            }
         	return false;
		};
	 </script>
  </head>
  
  <body>
    <div>
    	<div class="top">
		    <div class="title">异构签密即时通信系统</div>
		    <ul>
		    	<li>&nbsp;</li>
		    	<li><a href="ChatServlet?action=frame">首页</a></li>
		    	<li class="haslist">
		    		<a>${user.username}</a>
		    		<ul>
		    			<li class="modify-pwd"><i class="modify-pwd"></i><a href="UserServlet?action=pwdChange" target="bodyFrame">修改密码</a></li>
		    			<li class="user-center"><i class="user-center"></i><a href="UserServlet?action=view" target="bodyFrame">个人中心</a></li>
		    			<li class="modify-info"><i class="modify-info"></i><a href="UserServlet?action=edit" target="bodyFrame">修改信息</a></li>
		    		</ul>
		    	</li>
		    	<li><i class="logout"></i><a onclick="loginOut()">退出</a></li>
		    	<li>&nbsp;</li>
		    </ul>
		 </div>
    	<iframe name="bodyFrame" id="bodyFrame" src="ChatServlet?action=main&type=1"></iframe>
    </div>
  </body>
</html>
