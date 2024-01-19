<%@page import="com.jsp.entities.Category"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dao.CategoryDao"%>

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
<title>Add Products</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/merchnatnav.jsp"%>
	<div class="container card mt-3">
		<div class="container-flex" style="width: 90%;">
			<form action="addproduct" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Product
						name</label> <input type="text" name="productname" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp"
						required="required">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Product
						Description</label>
					<textarea style="height: 200px" class="form-control"
						name="productdesc" placeholder="Enter Category Description"
						required="required"></textarea>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Product
						Price</label> <input type="number" name="productprice"
						class="form-control" id="exampleInputPassword1"
						required="required">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Product
						Discount</label> <input type="number" name="productdiscount"
						class="form-control" id="exampleInputPassword1"
						required="required">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Product
						Quantity</label> <input type="number" name="productquantity"
						class="form-control" id="exampleInputPassword1"
						required="required">
				</div>
				<!-- Get Category -->
				<%
				CategoryDao dao = new CategoryDao(Persistence.createEntityManagerFactory("jeeban"));
				List<Category> li = dao.getCategories();
				Iterator<Category> it = li.iterator();
				%>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Product
						Quantity</label> <select name="optCat">
						<%
						while (it.hasNext()) {
							Object ob = (Object) it.next();
							Category c = (Category) ob;
						%>
						<option value="<%=c.getCategoryId()%>"><%=c.getCategoryTitel()%></option>
						<%
						}
						%>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>