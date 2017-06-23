<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:directive.page import="java.util.Date" />
<jsp:directive.page import="java.text.SimpleDateFormat" />
<%
Date date = (Date) request.getAttribute("date");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>Forward 跳转</TITLE>
		<link rel='stylesheet' type='text/css'
			href='<%=request.getContextPath()%>/css/style.css'>
	</HEAD>
	<BODY>
		<div align='center'>
			<br />
			<fieldset style=width:90%>
				<legend>
					Forward 跳转
				</legend>
				<br />
				<div style='line'>
					<div class='leftDiv' style='width:250px; '>
						从 ForwardServlet 中取到的 Date 为
					</div>
					<div align='left' class='rightDiv'>
						<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
							.format(date)%>
					</div>
				</div>
				<br />
				<div style='line'>
					<div align="center">
						<input type='button'
							onclick='location="<%=request.getContextPath()%>/servlet/ForwardServlet?destination=servlet"; '
							onmouseover="window.status='<%=request.getContextPath()%>/servlet/ForwardServlet?destination=servlet'"
							value='跳转到 Servlet' class=button>
						<input type='button'
							onclick='location="<%=request.getContextPath()%>/servlet/ForwardServlet?destination=file"; '
							onmouseover="window.status='<%=request.getContextPath()%>/servlet/ForwardServlet?destination=file'"
							value='跳转到 web.xml' class=button>
						<input type='button'
							onclick='location="<%=request.getContextPath()%>/servlet/ForwardServlet?destination=jsp"; '
							onmouseover="window.status='<%=request.getContextPath()%>/servlet/ForwardServlet?destination=jsp'"
							value='跳转到 JSP' class=button>
					</div>
				</div>
	</BODY>
</HTML>
