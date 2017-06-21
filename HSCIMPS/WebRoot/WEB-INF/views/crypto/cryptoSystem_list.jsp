<%@page import="nwnu.info.hsc.dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统管理平台</title>
    <link href="css/elements.css" rel="stylesheet"/>
  </head>
  
  <body>
    <div class="list-warper">
      <div class="list">
    	<div class="list-title">
    		密码体制列表
    	</div>
    	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="list-table">
    		<tr>
    			<th></th>
    			<th width="10%">密码体制名称</th>
    			<th width="20%">英文名称</th>
    			<th width="40%">简介</th>
    			<th width="20%">创建时间</th>
    			<th width="10%">操作</th>
    		</tr>
    		<c:forEach items="${cryptosystemList}" var="cryptosystem">
    			<tr align="center">
    				<td>
    					<input type="checkbox" name="cryptoId" value="${cryptosystem.cryptoId}"/>
    				</td>
    				<td>${cryptosystem.cryptoName}</td>
    				<td>${cryptosystem.englishName}</td>
    				<td>${cryptosystem.cryptoDesc}</td>
    				<td>${cryptosystem.createDate}</td>    				
    				<td>
    					<a href="CryptoServlet?action=edit&cryptoId=${cryptosystem.cryptoId}" >编辑</a>
    					<a href="CryptoServlet?action=del&cryptoId=${cryptosystem.cryptoId}" onclick="return confirm('确定删除？')">删除</a>
    				</td>
    			</tr>    			
    		</c:forEach>
    	</table>
    	<div style="text-align:center; margin-top:10px;font-size:15px;">
	    	<form action="CryptoServlet?action=list" method="post" >
	    		<a href="CryptoServlet?action=list&pageNos=1">首页</a>
	    		<c:if test="${pageNos>1}">
	    			<a href="CryptoServlet?action=list&pageNos=${pageNos-1}">上一页</a>
	    		</c:if>
	    		<c:if test="${pageNos<=1}">
	    			上一页
	    		</c:if>
	    		<c:if test="${pageNos<recordCount}">
	    			<a href="CryptoServlet?action=list&pageNos=${pageNos+1}">下一页</a>    			
	    		</c:if>
	    		<c:if test="${pageNos>=recordCount}">
	    			下一页		
	    		</c:if>
	    		<a href="CryptoServlet?action=list&pageNos=${recordCount}">末页</a> 
		    	&nbsp;共${recordCount}页
		    	<input type="text" value="${pageNos}" name="pageNos" size="1">页
				<input type="submit" value="跳转">
	    	</form>
	    </div>
      </div>
    </div>
  </body>
</html>
