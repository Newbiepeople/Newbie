<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统管理平台</title>
    <link href="css/elements.css" rel="stylesheet">
  </head>
  
  <body>
    <div class="form-warper" style="width:98%">
    	<div class="form-title">
    		<c:if test="${empty cryptosystem.cryptoId}">密码体制添加</c:if>
    		<c:if test="${not empty cryptosystem.cryptoId}">密码体制编辑</c:if>
    	</div>
    	<form action="CryptoServlet?action=save" method="post">
    		<div class="form-content double fn-left">
    			<input type="hidden" name="cryptoId" value="${cryptosystem.cryptoId}"/>
    			<ul class="form-table">
    				<li><i class="must_input">*</i>请输入密码体制名称</li>
    				<li>
    					<input type="text" name="cryptoName" class="input" value="${cryptosystem.cryptoName }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>请输入密码体制英文名称</li>
    				<li>
    					<input type="text" name="englishName" class="input" value="${cryptosystem.englishName}"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>密码体制简介</li>
    				<li>
    					<textarea class="textarea" name="cryptoDesc">${ cryptosystem.cryptoDesc}</textarea>
    					<i class="form-icon-clear"></i>
    				</li>
    			</ul>
    		</div>
    		<div style="clear:both;"></div>
    		<div class="form-btn">
    			<input type="submit" id="submit-btn" value="保存" class="btn green"/>
    		</div>
    	</form>
    </div>
  </body>
</html>
