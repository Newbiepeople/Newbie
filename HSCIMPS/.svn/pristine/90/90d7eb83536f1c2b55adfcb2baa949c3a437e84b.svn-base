<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统</title>
    <link href="css/elements.css" rel="stylesheet"/>
    <style type="text/css">
		a{text-decoration: none;}
	</style>
  </head>
  
  <body>
  	<div class="list-warper">  
  	  <div class="list">
    	<div class="list-title"> 
    		用户列表 
    	</div>	
    	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="list-table">
    		<tr>
    			<th></th>
    			<th width="5%">姓名</th>
    			<th width="5%">性别</th>
    			<th width="5%">年龄</th>
    			<th width="10%">出生日期</th>
    			<th width="10%">职业</th>
    			<th width="10%">电话</th>
    			<th width="15%">家庭住址</th>
    			<th width="15%">创建时间</th>
    			<th width="15%">密码体制</th>
    			<th width="10%">操作</th>
    		</tr>
    		<c:forEach items="${userList}" var="user">
    			<tr align="center">
    				<td>
    					<input type="checkbox" name="userId" value="${user.userId}"/>
    				</td>
    				<td>${user.username}</td>
    				<td>${user.sex}</td>
    				<td>${user.age}</td>
    				<td>${user.birthDate }</td>
    				<td>${user.occupation}</td>
    				<td>${user.telphone}</td>
    				<td>${user.homeAddress}</td>    				
    				<td>${user.createDate}</td>
    				<td>${user.cryptosystem.cryptoName}</td>
    				<td> 
    					<c:if test="${user.status==0}">
    						已启用
    						<a href="UserServlet?action=stop&userId=${user.userId}">停用</a>
    					</c:if>
    					<c:if test="${user.status==1}">
    						<a href="UserServlet?action=start&userId=${user.userId}">启用</a>
    						已停用
    					</c:if>
    					<a href="UserServlet?action=edit&userId=${user.userId}">编辑</a>
    					<a href="UserServlet?action=del&userId=${user.userId}" onclick="return confirm('确定删除？')">删除</a>
    					<a href="UserServlet?action=view&userId=${user.userId}">详情</a>
    				</td>
    			</tr>    			
    		</c:forEach>
    	</table>
    	<div style="text-align:center; margin-top:10px;font-size:15px;">
	    	<form action="UserServlet?action=list" method="post" >
	    		<a href="UserServlet?action=list&pageNos=1">首页</a>
		    	<c:if test="${pageNos>1}">
		    		<a href="UserServlet?action=list&pageNos=${pageNos-1}">上一页</a>
		    	</c:if>
		    	<c:if test="${pageNos<=1}">
		    		上一页
		    	</c:if>
		    	<c:if test="${pageNos<recordCount}">
		    		<a href="UserServlet?action=list&pageNos=${pageNos+1}">下一页</a>    			
		    	</c:if>
		    	<c:if test="${pageNos>=recordCount}">
		    		下一页		
		    	</c:if>
		    	<a href="UserServlet?action=list&pageNos=${recordCount}">末页</a> 
		    	&nbsp;共${recordCount}页
		    	<input type="text" value="${pageNos}" name="pageNos" size="1">页
				<input type="submit" value="跳转">
	    	</form>
	    </div>
      </div>
  	</div>
	
  </body>
</html>


