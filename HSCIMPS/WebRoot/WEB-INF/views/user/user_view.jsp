<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统</title>
    <style>
    	.warper{
    		text-align: center;
    	}
    	.header{
    		font-size: 40px;
    		border-bottom: 1px #ccc solid;
    	}
    	.form{
    		margin-top: 17px;
    		font-size: 18px;
    		line-height: 29px;
    	}
    	.form-field{
    		position: relative;
		    padding: 8px 0 8px 110px;
    	}
    	.title{
    		position: absolute;
		    left: 420px;
		    width: 100px;
		    text-align: right;
		    color: #333;
    	}
    	.content{
    		 text-align: left;
    	}
    </style>
  </head>
  
  <body>
  	<div class="warper">
	  	<div class="header">
	  		用户信息
	  	</div>
  		<div class="form">  		
	    	<div class="form-field">
	    		<label class="title">用户名：</label>
	    		<label class="content">${user.username}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">性别：</label>
	    		<label class="content">${user.sex}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">年龄：</label>
	    		<label class="content">${user.age}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">出生日期：</label>
	    		<label class="content">${user.birthDate}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">联系电话：</label>
	    		<label class="content">${user.telphone}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">职业：</label>
	    		<label class="content">${user.occupation}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">地址：</label>
	    		<label class="content">${user.homeAddress}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">创建日期：</label>
	    		<label class="content">${user.createDate}</label>
	    	</div>
	    	<div class="form-field">
	    		<label class="title">密码体制：</label>
	    		<label class="content">${user.cryptosystem.cryptoName}</label>
	    	</div>	    	
	    	<div class="form-field">
	    		<label class="title">权限：</label>
	    		<c:if test="${user.state==0}">
	    			<label class="content">超级管理员</label>
	    		</c:if>
	    		<c:if test="${user.state==1}">
	    			<label class="content">普通用户</label>
	    		</c:if>
	    	</div>	    	
  		</div>
  	</div>  	
  	<c:if test="${user.state==1}">
  		<hr/>
  		公钥：${ pk }
		私钥：${ sk }
  	</c:if>  	
  </body>
</html>
