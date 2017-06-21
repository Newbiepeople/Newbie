<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>异构签密即时通信系统</title>
    <link href="css/elements.css" rel="stylesheet"/>
    <script language="javascript" type="text/javascript" src="JS/WDatePicker/WdatePicker.js"></script>    
    
  </head>
  
  <body>
   <div class="form-warper" style="width:98%">
    	<div class="form-title">    		
    		修改个人信息
    	</div>
    	<form action="UserServlet?action=save" method="post">
    		<div class="form-content double fn-left">
    			<input type="hidden" name="userId" value="${user.userId}"/>
    			<ul class="form-table">
    				<li><i class="must_input">*</i>用户名</li>
    				<li>
    					<input type="text" name="username" class="input" value="${user.username}"/>
    					<i class="form-icon-clear"></i>
    				</li>    				
    				<li><i class="must_input">*</i>年龄</li>
    				<li>
    					<input type="text" name="age" class="input" value="${user.age }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>出生日期</li>
    				<li>
    					<input type="text" name="birthDate" class="input" onclick="WdatePicker()" value="${user.birthDate }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>联系电话</li>
    				<li>
    					<input type="text" name="telphone" class="input" value="${user.telphone }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>职业</li>
    				<li>
    					<input type="text" name="occupation" class="input" value="${user.occupation }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<li><i class="must_input">*</i>家庭住址</li>
    				<li>
    					<input type="text" name="homeAddress" class="input" value="${user.homeAddress }"/>
    					<i class="form-icon-clear"></i>
    				</li>
    				<c:if test="${state==0 }">
    					<li><i class="must_input">*</i>密码体制</li>    				
    					<li>
				    		<select name="cryptoId">
								<c:forEach items="${ cryptosystemList }" var="cryptosystem">
									<option value="${ cryptosystem.cryptoId }">${ cryptosystem.cryptoName }</option>
								</c:forEach>
							</select>
    					</li>
    				</c:if>    				
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
