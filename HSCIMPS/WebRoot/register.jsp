<%@page import="nwnu.info.hsc.dao.CryptosystemDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	    CryptosystemDao cryptosystemDao = new CryptosystemDao();
		List cryptosystemList = cryptosystemDao.cryptosystemList();
		request.setAttribute("cryptosystemList", cryptosystemList);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>异构签密即时通信系统——注册</title>
    <link href="css/register.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script language="javascript" type="text/javascript" src="JS/WDatePicker/WdatePicker.js"></script>    
    <script type="text/javascript"> 
    	function reg(form){    	  
    	   var username=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; //用户名
    	   var digital = /^[0-9]{1,20}$/;//全为数字
    	   var password = /^(\w){6,20}$/;//密码
           var tel=/^1[34578]\d{9}$/;//电话
           if(form.username.value == ""){
              alert("用户不能为空！"); 
              return false;
           }else if(!username.exec(form.username.value)){
           	  alert("请输入5-20个以字母开头、可带数字、‘_’、‘.’"); 
              return false;
           }else if(form.password.value == ""){
               alert("密码不能为空！");
               return false;
           }else if(!password.exec(form.password.value)){
               alert("密码格式错误！");
               return false;
           }else if(digital.exec(form.password.value)){
               alert("密码不能全为数字！");
               return false;
           }else if(form.password2.value == ""){
               alert("确认密码不能为空！");
               return false;
           }else if(form.password.value != form.password2.value){
               alert("两次密码输入不一致！");
               return false;
           }else if(form.age.value == ""){
               alert("年龄不能为空！");
               return false;
           }else if(form.birthDate.value == ""){
               alert("出生日期不能为空！");
               return false;
           }else if(form.telphone.value == ""){
               alert("联系电话不能为空！");
                return false ;
           }else if (!tel.exec(form.telphone.value)){
		   	   alert("联系电话输入有误！");
		   	   return false ;
		   }else if(form.occupation.value == ""){
               alert("职业不能为空！");
               return false;
           }else if(form.homeAddress.value == ""){
               alert("地址不能为空！");
               return false;
           }
       }
    </script>
    <script type="text/javascript">
		var Gid  = document.getElementById ;
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>";
		};
		Gid('s_county').setAttribute('onchange','showArea()');
	</script>	
  </head>
  
  <body>
  	<div class="header"> 
  		异构签密即时通信系统&mdash;&mdash;注册 
  	</div>
  	<div class="form">
  		<form action="RegisterServlet" method="post" onSubmit="return reg(this)">
	    	<div class="form-field">
	    		<label>用户名</label>
	    		<input type="text" name="username">
	    		<i class="tips">请输入5-20个以字母开头、可带数字、“_”、“.”</i>
	    	</div>
	    	<i class="error">${ info }</i>
	    	<div class="form-field">
	    		<label>密码</label>
	    		<input type="password" name="password">
	    		<i class="tips">请输入6-20个字母、数字、下划线 </i>
	    	</div>
	    	<div class="form-field">
	    		<label>确认密码</label>
	    		<input type="password" name="password2">
	    	</div>
	    	<div class="radio-sex">
	    		<label>性别</label>
	    		<input type="radio" name="sex" value="男" checked="checked" class="radio"><i class="sex">男</i>
	    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="radio" name="sex" value="女" class="radio"><i class="sex">女</i>
	    	</div>
	    	<div class="form-field">
	    		<label>年龄</label>
	    		<input type="text" name="age">
	    	</div>
	    	<div class="form-field">
	    		<label>出生日期</label>
	    		<input type="text" name="birthDate" onclick="WdatePicker()">
	    	</div>
	    	<div class="form-field">
	    		<label>电话</label>
	    		<input type="text" name="telphone">
	    		<i class="tips">必须以数字开头，除数字外，可含有“-”</i>
	    	</div>
	    	<div class="form-field">
	    		<label>职业</label>
	    		<input type="text" name="occupation">
	    	</div>
	    	<div class="form-field">
				<label>地址</label>
				<select id="s_province" name="s_province"></select>
				<select id="s_city" name="s_city"></select>  
				<select id="s_county" name="s_county"></select>
				<script src="JS/area.js" type="text/javascript"></script>
				<script type="text/javascript">_init_area();</script>
				<input type="text" name="homeAddress" style="margin-top:15px;">
	    	</div>
	    	<div class="form-field">
	    		<label>密码体制</label>
	    		<select name="cryptoId">
					<c:forEach items="${ cryptosystemList }" var="cryptosystem">
						<option style="font-size:14px;" value="${ cryptosystem.cryptoId }">${ cryptosystem.cryptoName }</option>
					</c:forEach>
				</select>
	    	</div>
	    	<div class="border"></div>
	    	<div class="form-group space">
	    		<input type="submit" value="提  交" class="btn btn-primary btn-lg">
	    		&nbsp;&nbsp;
	    		<a href="login.jsp" class="btn btn-default btn-lg">登录</a>
	    	</div>	    	
    	</form>
  	</div>
  </body>
</html>