<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>异构签密即时通信系统</title>
<link rel="stylesheet"	href="css/wel.css">
<script type="text/javascript">
	function refresh(){
		window.location.reload();
	}
</script>
</head>

<body>
    <table class="table" border="0" width="100%" align="center">
    	<tbody>
    		<tr>
    			<th class="bg_tr" align="left" colspan="2" height="25">
    				系统信息统计
    			</th>
    		</tr>
    		<tr>
    			<td class="td_bg" width="50%" height="23">服务器名称：
    				<span class="TableRow2"><%=request. getServerName()%></span>
    			</td>
    			<td class="td_bg" width="50%">端口号：<span class="TableRow1"><%=request.getServerPort()%></span></td>
    		</tr>
    		<tr>
    			<td class="td_bg" width="50%" height="23">站点物理路径：
    				<span class="TableRow2"> <%= this.getServletContext().getRealPath("/")%> </span>
    			</td>
      			<td class="td_bg" width="50%">IP地址：
      				<span class="TableRow1"><%=request.getLocalAddr()%></span>
      			</td>
    		</tr>
    		<tr>    			
      			<td class="td_bg" width="50%" height="23">数据库使用：
    			 	<span class="TableRow1">
			        	MySql 5.0
			        </span>
			     </td>
			     <td class="td_bg" width="50%">协议：
      				<span class="TableRow1"><%=request.getProtocol()%></span>
      			</td>			     
    		</tr>
    		<tr>    			
      			<td class="td_bg" width="50%" height="23">语言环境：
    			 	<span class="TableRow1">
			        	<%=request.getLocale()%>
			        </span>
			     </td>
			     <td class="td_bg" width="50%">context路径：
      				<span class="TableRow1"><%=request.getContextPath()%></span>
      			</td>			     
    		</tr>
    		<tr>
    			<td class="td_bg" width="100%" height="23" colspan="2">浏览器名：
    			 	<span class="TableRow1">
			        	<%=request.getHeader("User-Agent") %>
			        </span>
			    </td>
    		</tr>
    	</tbody>
    </table>
    <br/>
	<table class="table" border="0" width="100%" align="center">
    	<tbody>
    		<tr>
    			<th class="bg_tr" align="left" colspan="2" height="25">
    				网站管理系统开发
    			</th>
    		</tr>
    		<tr>
    			<td class="td_bg" width="17%" height="23">程序制作
    				<span class="TableRow2"></span>
    			</td>
    			<td class="td_bg" width="83%"><strong>西北师范大学 计算机科学与技术学院 信息安全实验室</strong></td>
    		</tr>
    		<tr>
    			<td class="td_bg" width="17%" height="23">联系方式
    				<span class="TableRow2"></span>
    			</td>
      			<td class="td_bg" width="83%">
      				<span class="TableRow1">E_mail：********@126.com</span>
      			</td>
    		</tr>
    		<tr>    			
      			<td class="td_bg" width="17%" height="23">程序主页
    			 	<span class="TableRow1"></span>
			     </td>
			     <td class="td_bg" width="83%" height="23">
    			 	<a onclick="refresh();">异构签密即时通信系统</a>
			    </td>
    		</tr>
    	</tbody>
    </table>
    
</body>
</html>
