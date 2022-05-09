<%@ page import="com.xkk.listener.OnlineCounter" %>
<%@ page language="java" pageEncoding="GB2312" %>
<html> 
<head><title>在线人数统计</title></head> 
<body bgcolor="#FFFFFF"> 
当前在线人数:<%=OnlineCounter.getOnline()%>
<a href="logout.jsp">注销</a>
</body> 
</html> 
