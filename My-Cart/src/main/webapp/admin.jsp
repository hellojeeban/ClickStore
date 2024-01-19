<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dao.MerchantDao"%>
<%@page import="com.jsp.entities.Merchant"%>
<%@page import="com.jsp.entities.Admin"%>
<%
Admin admin = (Admin) session.getAttribute("current-admin");
if (admin == null) {
	session.setAttribute("message", "you are not loged in ! Log in First");
	response.sendRedirect("adminlogin.jsp");
	return;
} else if (admin.getUserType().equals("normal_user")) {
	session.setAttribute("message", "you are not Admin ! You can't access");
	response.sendRedirect("login.jsp");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/adminnav.jsp"%>
	<%@include file="components/message.jsp"%>
	<div class="container mt-3 admin">
		<div class="row">
			<div class="col-md-4">
				<div class="card text-center">
					<div class="card-body">
						<div class="container">
							<img alt="" src="img/numofuser.png" style="max-width: 100px">
						</div>
						<h1>34</h1>
						<h1 class="text-uppercase text-muted text-color">Users</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-center">
					<div class="card-body">
						<div class="container">
							<img alt="" src="img/categories.png" style="max-width: 100px">
						</div>
						<h1>34</h1>
						<h1 class="text-uppercase text-muted text-color">Categories</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-center">
					<div class="card-body">
						<div class="container">
							<img alt="" src="img/listofproduct.png" style="max-width: 100px">
						</div>
						<h1>34</h1>
						<h1 class="text-uppercase text-muted text-color">Products</h1>
					</div>
				</div>
			</div>

			<!--  view data -->
			<div class="row mt-3">
				<h1 class="text-center">Merchant</h1>
				<div class="container">
					<div class="container-fluid card">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Status</th>
									<th scope="col">Update</th>
									<th scope="col">Delete</th>
								</tr>
							</thead>
							<tbody>
								<%
								MerchantDao dao = new MerchantDao(Persistence.createEntityManagerFactory("jeeban"));
								List<Merchant> li = dao.data();
								Iterator<Merchant> it = li.iterator();
								while (it.hasNext()) {
									Object ob = (Object) it.next();
									Merchant m = (Merchant) ob;
									System.out.println(m.getEmail());
								%>
								<tr>
									<td><%=m.getId()%></td>
									<td><%=m.getMname()%></td>
									<td><%=m.getEmail()%></td>
									<td><%=m.getStatus()%></td>
									<td><a href="updatestatus?id=<%=m.getId()%>">Update</a></td>
									<td><a href="deletemerchant?id=<%=m.getId()%>">Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 100px"></div>
</body>
</html>