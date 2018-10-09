<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body background="images/bg.png">
  
  	<div>
  		<table width="100%" >
  			<tr>
  			    <td width="165px" >
  					
  				</td>
  				<!-- <td width="165px" style="text-align: center">
  					<img alt="" src="#" width="160px" height="120px">
  				</td> -->
  				<td valign="top"><font face="SimSun" color="#6495ED" size="26">通用教学管理系统</font></td>
  				<td align="right" valign="bottom" style="padding-right: 30px">
  				   <font face="SimSun" color="#6495ED" style="text-decoration:none" size="5">
  					  欢迎您! &nbsp; ${user.name }</font> <a style="cursor:pointer">
  				    <font color="red" size="5">
  				          <a  href="admin/loginout" onclick="top.location.href='page/index.jsp'" > 退出</a>
  				    </font></a>
  				</td>
  			</tr>
  		</table>
  	</div>
  </body>
</html>
