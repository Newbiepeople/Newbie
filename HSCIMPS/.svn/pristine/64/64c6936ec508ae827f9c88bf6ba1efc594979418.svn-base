<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <meta charset="utf-8" />
        <title>异构签密即时通讯系统</title>
        
        <!-- The stylesheet -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        <script type="text/javascript">
    	function reg(form){
    	   var password = /^(\w){6,20}$/;//密码
    	   var digital = /^[0-9]{1,20}$/;//全为数字     
           if(form.oldPassword.value == ""){
               alert("原始密码不能为空！");
               return false;
           }else if(form.newPassword.value == ""){
               alert("新密码不能为空！");
               return false;
           }else if(!password.exec(form.newPassword.value)){
               alert("密码格式错误！");
               return false;
           }else if(digital.exec(form.newPassword.value)){
               alert("密码不能全为数字！");
               return false;
           }else if(form.newPassword2.value == ""){
               alert("确认密码不能为空！");
               return false;
           }else if(form.newPassword.value == form.oldPassword.value){
               alert("新旧密码相同！");
               return false;
           }else if(form.newPassword.value != form.newPassword2.value){
               alert("两次密码输入不一致！");
               return false;
           }           
       }
    </script>
    </head>
    
    <body>
        <div id="main">
        	<h1>修改密码</h1>
        	<form  action="UserServlet?action=pwdSave" method="post" onSubmit="return reg(this)" >
        		<div class="error">${MsgInfo}</div>
        		<div class="row pass">
	    			<input type="password" name="oldPassword" class="input" placeholder="请输入旧密码" />
        		</div>
        		
        		<div class="row pass">
        			<input type="password" class="input" name="newPassword" placeholder="请输入新密码" />
        		</div>
        		
        		<div class="row pass">
        			<input type="password" class="input" name="newPassword2" placeholder="请再次输入新密码"  />
        		</div>
        		
        		<!-- 指针样式 -->
        		<div class="arrowCap"></div>
        		<div class="arrow"></div>
        		<!-- 指针下边字体-->
        		<p class="meterText">Password Meter</p>
        		<!-- 提交按钮 -->
        		
               	<input  type="submit" value="确定" />
        	</form>
        </div>
                
    </body>
</html>