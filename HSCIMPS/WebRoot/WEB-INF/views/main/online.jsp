<%@page import="nwnu.info.hsc.entity.User"%>
<%@page import="nwnu.info.hsc.utils.UserUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%
	UserUtil  list = UserUtil.getInstance();
	Vector<User> vector = list.getList();
	int amount=0;
%>
<table style="width:100%; border:0; cellpadding:0;cellspacing:0;">
  <tr>
  	<td height="32" align="center" class="word_orange ">
  		<font size="3px">欢迎您的到来！</font>
  	</td>
  </tr>
  <%
 	if(vector != null && vector.size() > 0){
		String username="";	 
		amount = vector.size();
		for(int i=0;i<amount;i++){
			username = vector.elementAt(i).getUsername();
  %>
  <tr>
    <td height="23" align="center">
    	<a href="#" onclick="set('<%=username%>')">
    		<%=username%>
    	</a>
    </td>
  </tr>
  <%
  		}
  	}
  %>
</table>
<div class="online_footer">
 	当前在线[<font color="#FF6600"><%=amount%></font>]人
</div>