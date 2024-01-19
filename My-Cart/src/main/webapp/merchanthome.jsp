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
}
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/merchnatnav.jsp"%>
	<%@include file="components/message.jsp"%>
	<div class="container mt-3 admin">
		<div class="row">
			<!-- Product -->
			<div class="row mt-3">
				<h1 class="text-center">Product</h1>
				<div class="col-md-4">
					<a href="addproduct.jsp">
						<div class="card text-center">
							<div class="card-body">
								<div class="container">
									<img alt="" src="img/addproduct.png" style="max-width: 100px">
								</div>
								<h2 class="text-uppercase text-muted text-color">Add
									Products</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<div class="card text-center">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/update-product.png"
									style="max-width: 100px">
							</div>
							<h2 class="text-uppercase text-muted text-color">Update
								Products</h2>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card text-center">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/delete-product.png"
									style="max-width: 100px">
							</div>
							<h2 class="text-uppercase text-muted text-color">Delete
								Products</h2>
						</div>
					</div>
				</div>
			</div>

			<!--  category -->
			<div class="row mt-3">
				<h1 class="text-center">Category</h1>
				<div class="col-md-4">
					<div class="card text-center" data-bs-toggle="modal"
						data-bs-target="#addCategories">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/addcategory.png" style="max-width: 90px">
							</div>
							<h2 class="text-uppercase text-muted text-color">Add
								Categories</h2>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card text-center">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/update-category.png"
									style="max-width: 90px">
							</div>
							<h2 class="text-uppercase text-muted text-color">Update
								Categories</h2>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card text-center">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/delete-category.png"
									style="max-width: 90px">
							</div>
							<h2 class="text-uppercase text-muted text-color">Delete
								Categories</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 100px"></div>

	<!-- Add Modal -->
	<%@include file="components/addcategories.jsp"%>


	<!-- End Modal -->
</body>
</html>