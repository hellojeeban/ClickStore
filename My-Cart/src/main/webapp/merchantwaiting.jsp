<%@page import="com.jsp.dao.MerchantDao"%>
<%@page import="com.jsp.entities.Merchant"%>
<%@page import="com.jsp.entities.Merchant"%>
<%
Merchant merchant = (Merchant) session.getAttribute("current-merchant");
if (merchant == null) {
	session.setAttribute("message", "you are not loged in ! Log in First");
	response.sendRedirect("merchantlogin.jsp");
	return;
} else if (merchant.getStatus().equals("pending")) {
	session.setAttribute("message", "your status is pending ! You can't access");
	response.sendRedirect("merchantwaiting.jsp");
	return;
} else if (merchant.getStatus().equals("merchant")) {
	session.setAttribute("message", "Welcome " + merchant.getMname()+" Status is pending!");
	response.sendRedirect("merchanthome.jsp");
	return;
}

%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/merchnatnav.jsp" %>
<%@include file="components/message.jsp" %>
<h1>Status pending</h1>
</body>
</html>