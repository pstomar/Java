<%@page import="com.tomar.constants.GlobalResources"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<% 
	String code = request.getParameter("code");
	out.println("<img src='/"+GlobalResources.CONTEXT_NAME+"/images/error_"+code+".jpg'/>");
%>
</center>
</body>
</html>