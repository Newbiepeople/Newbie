<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>异构签密即时通信系统</title>
    <link href="css/login.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" href="css/supersized.css"> 
	
	<script type="text/javascript">
		function reg(form){
			if(form.username.value==""){
				alert("用户名不能为空！");
				form.username.focus();
				return false;	
			}else if(form.password.value==""){
				alert("密码不能为空！");
				form.password.focus();
				return false;	
			}else{
				var inputCode = document.getElementById("inputCode").value;
	            if (inputCode.length <= 0) 
	            {
	                alert("请输入验证码！");
	                return false;
	            }else if (inputCode.toUpperCase() != code.toUpperCase()){
	                alert("验证码输入有误！");	               
	                createCode();
	                 return false;
	            }
            }
		}
		
	</script>
    <script language="javascript" type="text/javascript">
        var code;
        function createCode() {
            code = "";
            var codeLength = 6; //验证码的长度
            var checkCode = document.getElementById("checkCode");
            var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
            for (var i = 0; i < codeLength; i++) 
            {
                var charNum = Math.floor(Math.random() * 52);
                code += codeChars[charNum];
            }
            if (checkCode) 
            {
                checkCode.className = "code";
                checkCode.innerHTML = code;
            }
        }         
     </script>
  </head>
  
  <body  onload="createCode()">
    <div class="page-container">
    	<div class="main_box">
    		<div class="login_box">
    			<div class="login_logo">
    				异构签密即时通信系统
				</div>
	    		<div class="login_form">
			    	<form action="LoginServlet" method="post" onSubmit="return reg(this)">
			    		<div class="form-group">
							<label class="error">${error}</label>
						</div>
				    	<div class="form-group">
				    		<label for="j_username" class="t">用户名</label>
				    		<input type="text" name="username" class="form-control x319 in"/>
				    	</div>
				    	<div class="form-group">
				    		<label for="j_password" class="t">密码</label>
				    		<input type="password" name="password" class="password form-control x319 in"/>
				    	</div>
				    	  
				    	<!-- <div class="form-group">
							<label for="j_captcha" class="t">验证码</label>
							<input id="inputCode" name="inputCode" type="text" class="form-control x164 in" placeholder="请输入验证码">
							<i class="code" id="checkCode" onclick="createCode()"></i>
						</div>
								 -->				
				    	<div class="form-group">
							<label class="t"></label>
							<label for="j_remember" class="m">
							<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
						</div>
				    	<div class="form-group space">
				    		<label class="t"></label>
				    		<input type="submit" value="登    录" class="btn btn-primary btn-lg">&nbsp;
				    		<a href="register.jsp" class="btn btn-default btn-lg">注  册</a>
				    	</div>
				    </form>
			    </div>
		    </div>
    	</div>
    </div>
    <script src="JS/jquery-1.8.2.min.js"></script>
    <script src="JS/supersized.3.2.7.min.js"></script>
    <script src="JS/supersized-init.js"></script>
  </body>
</html>